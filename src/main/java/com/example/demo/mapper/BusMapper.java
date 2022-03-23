package com.example.demo.mapper;

import com.example.demo.dto.BusDto;
import com.example.demo.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusMapper {

    public BusDto busDto(Bus bus) {
        if (bus == null) return null;
        return BusDto.builder().plate(bus.getPlate()).make(bus.getMake()).type(bus.getType()).
                year(bus.getYear()).color(bus.getColor()).busType(bus.getBusType()).
                seatCount(bus.getSeatCount()).fromWhere(bus.getFromWhere()).
                toWhere(bus.getToWhere()).build();
    }

    public List<BusDto> busDtoList(List<Bus> busList) {
        if (busList == null) return null;
        List<BusDto> list = new ArrayList<BusDto>(busList.size());
        for (Bus bus : busList)
            list.add(busDto(bus));
        return list;
    }

    public Bus bus(BusDto busDto) {
        if (busDto == null) return null;
        return Bus.builder().plate(busDto.getPlate()).make(busDto.getMake()).type(busDto.getType()).
                year(busDto.getYear()).color(busDto.getColor()).busType(busDto.getBusType()).
                seatCount(busDto.getSeatCount()).fromWhere(busDto.getFromWhere()).
                toWhere(busDto.getToWhere()).build();
    }

    public List<Bus> bus(List<BusDto> busDtoList) {
        if (busDtoList == null) return null;
        List<Bus> list = new ArrayList<Bus>(busDtoList.size());
        for (BusDto busDto : busDtoList)
            list.add(bus(busDto));
        return list;
    }
}