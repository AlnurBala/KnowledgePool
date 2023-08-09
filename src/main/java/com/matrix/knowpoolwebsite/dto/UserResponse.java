package com.matrix.knowpoolwebsite.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String paymentDetails;
    private String role;
}
