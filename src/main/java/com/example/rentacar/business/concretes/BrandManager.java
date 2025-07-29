package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import com.example.rentacar.business.rules.BrandBusinessRules;
import com.example.rentacar.core.utilities.mappers.ModelMapperService;
import com.example.rentacar.dataAccess.abstracts.BrandRepository;
import com.example.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService mapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponses = brands.stream().map(Brand->this.mapperService.forResponse().map(Brand,GetAllBrandsResponse.class)).toList();
        return getAllBrandsResponses;
    }

    @Override
    public void addBrand(CreateBrandRequest brandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(brandRequest.getName());
        Brand brand = this.mapperService.forRequest().map(brandRequest,Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getBrand(int id) {
        return this.mapperService.forResponse().map(this.brandRepository.getReferenceById(id),GetByIdBrandResponse.class);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.mapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }
}
