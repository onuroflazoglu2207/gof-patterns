package com.example.demo.mapper;

import com.example.demo.dto.AutomotiveDto;
import com.example.demo.model.Automotive;

import java.util.List;

public abstract class AutomotiveMapperAbs extends AutomotiveMapper {

    public abstract AutomotiveDto automotiveDto(Automotive automotive);

    public abstract List<AutomotiveDto> automotiveDtoList(List<Automotive> automotiveList);

}
