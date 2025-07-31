package com.example.rentacar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
    private int id;
    private String brandName;
    private String modelName;
    private String plate;
    private int modelYear;
    private double dailyPrice;
    private int state;
}
