package com.example.knowpoolwebsite.controller;

import com.example.knowpoolwebsite.dto.Request.DiscountRequest;
import com.example.knowpoolwebsite.dto.Response.DiscountResponse;
import com.example.knowpoolwebsite.service.DiscountService;
import com.example.knowpoolwebsite.service.impl.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
@Tag(name = "Discount",description = "Discount Management APIs")
public class DiscountController {
    private final DiscountService discountService;
    private final EmailService emailService;

    @GetMapping
    public List<DiscountResponse> getAllDiscounts() {

        return discountService.getAllDiscounts();
    }

    @PutMapping("/{id}")
    public DiscountResponse updateDiscount(@PathVariable Integer id, @RequestBody DiscountRequest discountRequest) {
        return discountService.updateDiscount(id, discountRequest);
    }

    @PostMapping
    public DiscountResponse createDiscount(@RequestBody DiscountRequest discountRequest) {
        return discountService.createDiscount(discountRequest);
    }


//    @PostMapping
//    public DiscountResponse createDiscount(@RequestBody DiscountRequest discountRequest) {
//        DiscountResponse discountResponse = discountService.createDiscount(discountRequest);
//
//        String recipientEmail = discountRequest.getRecipientEmail();
//        String subject = "Discount Information";
//        String body = "You have received a discount for a course. Enjoy!";
//        emailService.sendDiscountEmail(recipientEmail, subject, body);
//
//        return discountResponse;
//    }
}
