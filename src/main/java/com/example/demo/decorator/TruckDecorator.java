package com.example.demo.decorator;

import com.example.demo.dto.TruckDto;
import com.example.demo.mapper.TruckMapper;
import com.example.demo.mapper.TruckMapperAbs;
import com.example.demo.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckDecorator extends TruckMapperAbs {

    private final TruckMapper mapper = new TruckMapper();

    @Override
    public TruckDto truckDto(Truck Truck) {
        return decorator(Truck);
    }

    @Override
    public List<TruckDto> truckDtoList(List<Truck> Trucks) {
        List<TruckDto> list = new ArrayList<>();
        for (Truck Truck : Trucks)
            list.add(decorator(Truck));
        return list;
    }

    private TruckDto decorator(Truck truck) {
        TruckDto dto = mapper.truckDto(truck);
        if (truck.getWeight() != null && truck.getTotal() != null)
            dto.setSumWeight(Long.valueOf(truck.getWeight().intValue() * truck.getTotal().intValue()));
        else dto.setSumWeight(null);
        return dto;
    }
}