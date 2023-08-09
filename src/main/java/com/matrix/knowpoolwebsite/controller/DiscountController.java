package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.DiscountRequest;
import com.matrix.knowpoolwebsite.dto.response.DiscountResponseDto;
import com.matrix.knowpoolwebsite.service.DiscountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
@Tag(name = "Discount",description = "Discount Management APIs")
public class DiscountController {
    private final DiscountService discountService;

    @GetMapping
    public List<DiscountResponseDto> getAllDiscounts() {

        return discountService.getAllDiscounts();
    }

    @PutMapping("/{id}")
    public DiscountResponseDto updateDiscount(@PathVariable Integer id, @RequestBody DiscountRequest discountRequest) {
        return discountService.updateDiscount(id, discountRequest);
    }

    @PostMapping
    public DiscountResponseDto createDiscount(@RequestBody DiscountRequest discountRequest) {
        return discountService.createDiscount(discountRequest);
    }


}
