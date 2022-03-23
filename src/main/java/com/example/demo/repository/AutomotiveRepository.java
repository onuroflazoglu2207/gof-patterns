package com.example.demo.repository;

import com.example.demo.model.Automotive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomotiveRepository extends JpaRepository<Automotive, Long> {
}
