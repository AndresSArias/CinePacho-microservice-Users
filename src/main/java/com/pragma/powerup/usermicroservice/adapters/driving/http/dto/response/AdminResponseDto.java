package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdminResponseDto {
    private String idAdmin;
    private String numberDocument;
    private String name;
    private String dateBirth;
    private String phone;
    private String email;
    private String codeEmployee;
    private String Salary;
    private String dateContract;
    private String idMultiplex;
}
