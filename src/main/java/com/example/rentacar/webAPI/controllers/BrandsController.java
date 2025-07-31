package com.example.rentacar.webAPI.controllers;

import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.requests.CreateBrandRequest;
import com.example.rentacar.business.requests.UpdateBrandRequest;
import com.example.rentacar.business.responses.GetAllBrandsResponse;
import com.example.rentacar.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBrand(@Valid CreateBrandRequest createBrandRequest){
        brandService.addBrand(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getBrand(@PathVariable int id){
        return brandService.getBrand(id);
    }

    @PutMapping
    public void updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id){
        brandService.delete(id);
    }
}
