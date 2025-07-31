package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.requests.CreateCarRequest;
import com.example.rentacar.business.responses.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    void add(CreateCarRequest createCarRequest);
}
