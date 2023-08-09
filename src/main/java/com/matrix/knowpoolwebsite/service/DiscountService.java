package com.matrix.knowpoolwebsite.service;

import com.matrix.knowpoolwebsite.dto.request.DiscountRequest;
import com.matrix.knowpoolwebsite.dto.response.DiscountResponseDto;

import java.util.List;

public interface DiscountService {
    List<DiscountResponseDto> getAllDiscounts();
    DiscountResponseDto updateDiscount(Integer id, DiscountRequest discountRequest);

    DiscountResponseDto createDiscount(DiscountRequest discountRequest);
}
