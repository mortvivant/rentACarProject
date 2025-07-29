package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void addBrand(CreateBrandRequest brandRequest);
    GetByIdBrandResponse getBrand(int id);
    void delete(int id);
    void update(UpdateBrandRequest updateBrandRequest);
}
