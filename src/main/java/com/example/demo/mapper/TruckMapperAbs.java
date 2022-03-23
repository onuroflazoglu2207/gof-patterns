package com.example.demo.mapper;

import com.example.demo.dto.TruckDto;
import com.example.demo.model.Truck;

import java.util.List;

public abstract class TruckMapperAbs extends TruckMapper {

    public abstract TruckDto truckDto(Truck truck);

    public abstract List<TruckDto> truckDtoList(List<Truck> truckList);


}
