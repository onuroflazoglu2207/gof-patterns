package com.example.demo.service;

import com.example.demo.dto.CarDto;
import org.springframework.http.ResponseEntity;

public interface GofService {
    public ResponseEntity<?> getAll(String type);

    public ResponseEntity<?> getById(Long identity, String type);

    public ResponseEntity<?> save(CarDto car);

    public ResponseEntity<?> update(CarDto car, Long identity);

    public ResponseEntity<?> delete(Long identity, String type);
}
