package com.example.rentacar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {

    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE); // response nesnesinde neler varsa onu mappleyerek gevşek eşleştirme sağlar.
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD); // request nesnesinde ne varsa her onları mappleyerek standart eşleştirme yapar.
        return this.modelMapper;
    }
}
