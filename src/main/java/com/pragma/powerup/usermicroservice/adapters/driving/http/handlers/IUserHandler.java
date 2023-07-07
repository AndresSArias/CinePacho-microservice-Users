package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserEmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.*;

import java.util.List;

public interface IUserHandler {
    /*
    void saveUserOwner(UserRequestDto userRequestDto);

    void saveUserCustomer(UserRequestDto userRequestDto);
*/
    List<AdminResponseDto> getAllAdmins ();

    AuthUserResponse getUsuario (String numberDocument);

    ClienteCreateResponseDto saveClient (UserRequestDto userResponseDto);

    MessageCodeResponseDto isExist (String numDocument);

    ClienteCreateResponseDto saveAdmin (UserAdminRequestDto userAdminRequestDto);

}
