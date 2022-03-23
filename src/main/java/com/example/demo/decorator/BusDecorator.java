package com.example.demo.decorator;

import com.example.demo.dto.BusDto;
import com.example.demo.mapper.BusMapper;
import com.example.demo.mapper.BusMapperAbs;
import com.example.demo.model.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusDecorator extends BusMapperAbs {

    private final BusMapper mapper = new BusMapper();

    @Override
    public BusDto busDto(Bus Bus) {
        return decorator(Bus);
    }

    @Override
    public List<BusDto> busDtoList(List<Bus> busList) {
        List<BusDto> list = new ArrayList<>();
        for (Bus Bus : busList)
            list.add(decorator(Bus));
        return list;
    }

    private BusDto decorator(Bus bus) {
        BusDto dto = mapper.busDto(bus);
        dto.setBigBus(bus.getSeatCount() == null ? null : bus.getSeatCount().intValue() > 20);
        return dto;
    }
}
