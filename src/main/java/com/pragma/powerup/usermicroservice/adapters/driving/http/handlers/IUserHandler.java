package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserEmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AuthUserResponse;

import java.util.List;

public interface IUserHandler {
    /*
    void saveUserOwner(UserRequestDto userRequestDto);

    void saveUserCustomer(UserRequestDto userRequestDto);
*/
    List<AdminResponseDto> getAllAdmins ();

    AuthUserResponse getUsuario (String numberDocument);
}
