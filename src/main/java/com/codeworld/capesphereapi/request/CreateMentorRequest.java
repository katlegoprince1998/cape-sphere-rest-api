package com.codeworld.capesphereapi.request;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class CreateMentorRequest {
    private String name;
    private String email;
    private String phone;

}
