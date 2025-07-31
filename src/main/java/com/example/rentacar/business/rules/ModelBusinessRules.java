package com.example.rentacar.business.rules;

import com.example.rentacar.core.utilities.exceptions.BusinessException;
import com.example.rentacar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;


    public void checkIfModelNameExists(String name){
        if(modelRepository.existsByName(name)){
            throw new BusinessException("Model is already exists.");
        }
    }
}
