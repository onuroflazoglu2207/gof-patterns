package com.example.demo.decorator;

import com.example.demo.dto.AutomotiveDto;
import com.example.demo.mapper.AutomotiveMapper;
import com.example.demo.mapper.AutomotiveMapperAbs;
import com.example.demo.model.Automotive;

import java.util.ArrayList;
import java.util.List;

public class AutomotiveDecorator extends AutomotiveMapperAbs {

    private final AutomotiveMapper mapper = new AutomotiveMapper();

    @Override
    public AutomotiveDto automotiveDto(Automotive automotive) {
        return decorator(automotive);
    }

    @Override
    public List<AutomotiveDto> automotiveDtoList(List<Automotive> automotiveList) {
        List<AutomotiveDto> list = new ArrayList<>();
        for (Automotive automotive : automotiveList) {
            list.add(decorator(automotive));
        }
        return list;
    }

    private AutomotiveDto decorator(Automotive automotive) {
        AutomotiveDto dto = mapper.automotiveDto(automotive);
        dto.setFast(automotive.getGearbox() != null && automotive.getGearbox().toLowerCase().equals("manual"));
        return dto;
    }
}
