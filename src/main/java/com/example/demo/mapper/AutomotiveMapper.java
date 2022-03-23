package com.example.demo.mapper;

import com.example.demo.dto.AutomotiveDto;
import com.example.demo.model.Automotive;

import java.util.ArrayList;
import java.util.List;

public class AutomotiveMapper {

    public AutomotiveDto automotiveDto(Automotive automotive) {
        if (automotive == null) return null;
        return AutomotiveDto.builder().plate(automotive.getPlate()).make(automotive.getMake()).
                type(automotive.getType()).year(automotive.getYear()).color(automotive.getColor()).
                bodyType(automotive.getBodyType()).fuelType(automotive.getFuelType()).
                gearbox(automotive.getGearbox()).build();
    }

    public List<AutomotiveDto> automotiveDtoList(List<Automotive> automotiveList) {
        if (automotiveList == null) return null;
        List<AutomotiveDto> list = new ArrayList<AutomotiveDto>(automotiveList.size());
        for (Automotive automotive : automotiveList)
            list.add(automotiveDto(automotive));
        return list;
    }

    public Automotive automotive(AutomotiveDto automotiveDto) {
        if (automotiveDto == null) return null;
        return Automotive.builder().plate(automotiveDto.getPlate()).make(automotiveDto.getMake()).
                type(automotiveDto.getType()).year(automotiveDto.getYear()).color(automotiveDto.getColor()).
                bodyType(automotiveDto.getBodyType()).fuelType(automotiveDto.getFuelType()).
                gearbox(automotiveDto.getGearbox()).build();
    }

    public List<Automotive> automotiveList(List<AutomotiveDto> automotiveDtoList) {
        if (automotiveDtoList == null) return null;
        List<Automotive> list = new ArrayList<Automotive>(automotiveDtoList.size());
        for (AutomotiveDto automotiveDto : automotiveDtoList)
            list.add(automotive(automotiveDto));
        return list;
    }
}
