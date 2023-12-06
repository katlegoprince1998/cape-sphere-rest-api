package com.codeworld.capesphereapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthResponse {

    private String jwt;
    private String message;

}
