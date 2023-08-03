package com.example.knowpoolwebsite.service.impl;

import com.example.knowpoolwebsite.dto.Request.DiscountRequest;
import com.example.knowpoolwebsite.dto.Response.DiscountResponse;
import com.example.knowpoolwebsite.entity.Discount;
import com.example.knowpoolwebsite.mapper.DiscountMapper;
import com.example.knowpoolwebsite.repository.DiscountRepository;
import com.example.knowpoolwebsite.service.DiscountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;
    @Override
    public List<DiscountResponse> getAllDiscounts() {
        var discountEntity=discountRepository.findAll();
        return discountMapper.toDTOs(discountEntity);
    }
    @Override
    public DiscountResponse updateDiscount(Integer id, DiscountRequest discountRequest) {
        var newDiscount = discountRepository.findById(id).orElse(new Discount());
        discountMapper.mapUpdateRequestToEntity(newDiscount, discountRequest);
        discountRepository.save(newDiscount);
        return discountMapper.toDTO(newDiscount);
    }

    @Override
    public DiscountResponse createDiscount(DiscountRequest discountRequest) {
        var discountEntity=discountMapper.fromDTO(discountRequest);
        discountEntity=discountRepository.save(discountEntity);
        return discountMapper.toDTO(discountEntity);
    }
}
