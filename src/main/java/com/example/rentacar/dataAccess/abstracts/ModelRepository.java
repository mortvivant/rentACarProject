package com.example.rentacar.dataAccess.abstracts;

import com.example.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    boolean existsByName(String name);
}
