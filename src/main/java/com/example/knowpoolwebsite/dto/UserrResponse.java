package com.example.knowpoolwebsite.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserrResponse {
    private Integer userId;
    private String name;
    private String emailAddress;
    private String password;
    private String paymentDetails;
}
