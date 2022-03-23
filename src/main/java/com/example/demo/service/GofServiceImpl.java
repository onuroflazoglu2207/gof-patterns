package com.example.demo.service;

import com.example.demo.decorator.*;
import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GofServiceImpl implements GofService {

    private final AutomotiveDecorator automotiveDecorator = new AutomotiveDecorator();
    private final BusDecorator busDecorator = new BusDecorator();
    private final TruckDecorator truckDecorator = new TruckDecorator();

    private final AutomotiveRepository automotiveRepository;
    private final BusRepository busRepository;
    private final TruckRepository truckRepository;


    @Override
    public ResponseEntity<?> getAll(String type) {
        if (type == null)
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
        if (type.equals(CarDto.AUTOMOTIVE_NAME))
            return ResponseEntity.ok(automotiveDecorator.automotiveDtoList(automotiveRepository.findAll()));
        else if (type.equals(CarDto.BUS_NAME))
            return ResponseEntity.ok(busDecorator.busDtoList(busRepository.findAll()));
        else if (type.equals(CarDto.TRUCK_NAME))
            return ResponseEntity.ok(truckDecorator.truckDtoList(truckRepository.findAll()));
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
    }

    @Override
    public ResponseEntity<?> getById(Long identity, String type) {
        try {
            if (type == null)
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
            if (type.equals(CarDto.AUTOMOTIVE_NAME))
                return ResponseEntity.ok(automotiveDecorator.automotiveDto(automotiveRepository.findById(identity).get()));
            else if (type.equals(CarDto.BUS_NAME))
                return ResponseEntity.ok(busDecorator.busDto(busRepository.findById(identity).get()));
            else if (type.equals(CarDto.TRUCK_NAME))
                return ResponseEntity.ok(truckDecorator.truckDto(truckRepository.findById(identity).get()));
            else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found!");
        }
    }

    @Override
    public ResponseEntity<?> save(CarDto car) {
        try {
            if (car instanceof AutomotiveDto)
                return ResponseEntity.ok(automotiveDecorator.automotiveDto(
                        automotiveRepository.save(automotiveDecorator.automotive((AutomotiveDto) car))));
            else if (car instanceof BusDto)
                return ResponseEntity.ok(busDecorator.busDto(busRepository.save(busDecorator.bus((BusDto) car))));
            else if (car instanceof TruckDto)
                return ResponseEntity.ok(truckDecorator.truckDto(
                        truckRepository.save(truckDecorator.truck((TruckDto) car))));
            else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable Type!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unacceptable field!");
        }
    }

    @Override
    public ResponseEntity<?> update(CarDto car, Long identity) {
        try {
            if (car instanceof AutomotiveDto) {
                if (automotiveRepository.findById(identity).isEmpty())
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found!");
                else
                    return ResponseEntity.ok(automotiveDecorator.automotiveDto(
                            automotiveRepository.save(automotiveDecorator.automotive((AutomotiveDto) car))));
            } else if (car instanceof BusDto) {
                if (busRepository.findById(identity).isEmpty())
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found!");
                else
                    return ResponseEntity.ok(busDecorator.busDto(busRepository.save(busDecorator.bus((BusDto) car))));
            } else if (car instanceof TruckDto) {
                if (truckRepository.findById(identity).isEmpty())
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found!");
                else
                    return ResponseEntity.ok(truckDecorator.truckDto(
                            truckRepository.save(truckDecorator.truck((TruckDto) car))));
            } else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable Type!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unacceptable field!");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long identity, String type) {
        try {
            if (type == null)
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
            if (type.equals(CarDto.AUTOMOTIVE_NAME)) {
                Automotive automotive = automotiveRepository.findById(identity).get();
                automotiveRepository.delete(automotive);
                return ResponseEntity.ok(automotiveDecorator.automotiveDto(automotive));
            } else if (type.equals(CarDto.BUS_NAME)) {
                Bus bus = busRepository.findById(identity).get();
                busRepository.delete(bus);
                return ResponseEntity.ok(busDecorator.busDto(bus));
            } else if (type.equals(CarDto.TRUCK_NAME)) {
                Truck truck = truckRepository.findById(identity).get();
                truckRepository.delete(truck);
                return ResponseEntity.ok(truckDecorator.truckDto(truck));
            } else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unacceptable type!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found!");
        }
    }
}
