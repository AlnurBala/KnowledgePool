package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.dto.request.DiscountRequest;
import com.matrix.knowpoolwebsite.dto.response.DiscountResponseDto;
import com.matrix.knowpoolwebsite.entity.Discount;
import com.matrix.knowpoolwebsite.mapper.DiscountMapper;
import com.matrix.knowpoolwebsite.repository.DiscountRepository;
import com.matrix.knowpoolwebsite.service.DiscountService;
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
    public List<DiscountResponseDto> getAllDiscounts() {
        var discountEntity=discountRepository.findAll();
        return discountMapper.toDTOs(discountEntity);
    }
    @Override
    public DiscountResponseDto updateDiscount(Integer id, DiscountRequest discountRequest) {
        var newDiscount = discountRepository.findById(id).orElse(new Discount());
        discountMapper.mapUpdateRequestToEntity(newDiscount, discountRequest);
        discountRepository.save(newDiscount);
        return discountMapper.toDTO(newDiscount);
    }

    @Override
    public DiscountResponseDto createDiscount(DiscountRequest discountRequest) {
        var discountEntity=discountMapper.fromDTO(discountRequest);
        discountEntity=discountRepository.save(discountEntity);
        return discountMapper.toDTO(discountEntity);
    }
}
