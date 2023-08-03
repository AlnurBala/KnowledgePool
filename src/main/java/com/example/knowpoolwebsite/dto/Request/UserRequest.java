package com.example.knowpoolwebsite.dto.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Integer userId;
    private String name;
    private String emailAddress;
    private String password;
    private String paymentDetails;
//    private Enrollment enrollment;

}
