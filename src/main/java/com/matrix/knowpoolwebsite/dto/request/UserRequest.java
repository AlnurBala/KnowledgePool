package com.matrix.knowpoolwebsite.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String paymentDetails;
    private String role;

}
