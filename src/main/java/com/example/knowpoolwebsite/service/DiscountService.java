package com.example.knowpoolwebsite.service;

import com.example.knowpoolwebsite.dto.Request.CourseRequest;
import com.example.knowpoolwebsite.dto.Request.DiscountRequest;
import com.example.knowpoolwebsite.dto.Response.CourseResponse;
import com.example.knowpoolwebsite.dto.Response.DiscountResponse;

import java.util.List;

public interface DiscountService {
    List<DiscountResponse> getAllDiscounts();
    DiscountResponse updateDiscount(Integer id,DiscountRequest discountRequest);

    DiscountResponse createDiscount(DiscountRequest discountRequest);
}
