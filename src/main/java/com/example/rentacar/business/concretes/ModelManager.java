package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.requests.CreateModelRequest;
import com.example.rentacar.business.responses.GetAllModelsResponse;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.ModelRepository;
import com.example.rentacar.entities.concretes.Brand;
import com.example.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<GetAllModelsResponse> getAllModelsResponses = modelRepository.findAll().stream().map(model -> this.modelMapperService.forResponse()
                .map(model,GetAllModelsResponse.class)).toList();
        return getAllModelsResponses;
    }

    @Override
    public void addModel(CreateModelRequest createModelRequest) {
        Model model = new Model();
        Brand brand = new Brand();
        brand.setId(createModelRequest.getBrandId());
        model.setBrand(brand);
        model.setName(createModelRequest.getName());
        this.modelRepository.save(model);
    }
}
