package com.example.demo.controller;

import com.example.demo.dto.CarDto;
import com.example.demo.service.GofServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gof")
@RequiredArgsConstructor
public class GofController {

    private final GofServiceImpl service;

    @GetMapping("/getAll/{type}")
    public ResponseEntity<?> getAll(@PathVariable String type) {
        return service.getAll(type);
    }

    @GetMapping("/getById/{type}/{identity}")
    public ResponseEntity<?> getById(@PathVariable Long identity, @PathVariable String type) {
        return service.getById(identity, type);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CarDto car) {
        return service.save(car);
    }

    @PutMapping("/update/{identity}")
    public ResponseEntity<?> update(@RequestBody CarDto car, @PathVariable Long identity) {
        return service.update(car, identity);
    }

    @DeleteMapping("/delete/{type}/{identity}")
    public ResponseEntity<?> delete(@PathVariable Long identity, @PathVariable String type) {
        return service.delete(identity, type);
    }
}
