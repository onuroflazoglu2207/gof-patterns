package com.example.demo.mapper;

import com.example.demo.dto.BusDto;
import com.example.demo.model.Bus;

import java.util.List;

public abstract class BusMapperAbs extends BusMapper {

    public abstract BusDto busDto(Bus bus);

    public abstract List<BusDto> busDtoList(List<Bus> busList);
}
