package com.example.demo.mapper;

import com.example.demo.dto.TruckDto;
import com.example.demo.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckMapper {

    public TruckDto truckDto(Truck truck) {
        if (truck == null) return null;
        return TruckDto.builder().plate(truck.getPlate()).make(truck.getMake()).type(truck.getType()).
                year(truck.getYear()).color(truck.getColor()).goods(truck.getGoods()).
                weight(truck.getWeight()).total(truck.getTotal()).fromWhere(truck.getFromWhere()).
                toWhere(truck.getToWhere()).build();
    }

    public List<TruckDto> truckDtoList(List<Truck> truckList) {
        if (truckList == null) return null;
        List<TruckDto> list = new ArrayList<TruckDto>(truckList.size());
        for (Truck truck : truckList)
            list.add(truckDto(truck));
        return list;
    }

    public Truck truck(TruckDto truckDto) {
        if (truckDto == null) return null;
        return Truck.builder().plate(truckDto.getPlate()).make(truckDto.getMake()).type(truckDto.getType()).
                year(truckDto.getYear()).color(truckDto.getColor()).goods(truckDto.getGoods()).
                weight(truckDto.getWeight()).total(truckDto.getTotal()).fromWhere(truckDto.getFromWhere()).
                toWhere(truckDto.getToWhere()).build();
    }

    public List<Truck> truckList(List<TruckDto> truckDtoList) {
        if (truckDtoList == null) return null;
        List<Truck> list = new ArrayList<Truck>(truckDtoList.size());
        for (TruckDto truckDto : truckDtoList)
            list.add(truck(truckDto));
        return list;
    }
}

