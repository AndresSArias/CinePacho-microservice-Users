package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AuthUserResponse;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response.IUserResponseMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.request.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.configuration.security.jwt.JwtProvider;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    private final JwtProvider jwtProvider;

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        return userResponseMapper.toListDto(userServicePort.getAllAdmin());
    }

    /*
        @Override
        public void saveUserOwner(UserRequestDto userRequestDto) {
            userServicePort.saveUserOwner(userRequestMapper.toUserOwner(userRequestDto));
        }

        @Override
        public void saveUserCustomer(UserRequestDto userRequestDto) {
            userServicePort.saveUserCustomer(userRequestMapper.toUserOwner(userRequestDto));
        }
    */
    @Override
    public AuthUserResponse getUsuario(String numberDocument) {
        return userResponseMapper.userToAuthUserResponse(userServicePort.getUserByDocument(numberDocument));
    }

}
