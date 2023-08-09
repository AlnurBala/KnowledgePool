package com.matrix.knowpoolwebsite.dto.request;

import com.matrix.knowpoolwebsite.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private Set<Role> roles = Collections.singleton(Role.USER);

}
