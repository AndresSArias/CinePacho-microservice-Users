package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.PointsClientResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Client;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    void updateRating (QualificationRequestDto qualificationRequestDto);
    User getUserByDocument (String numberDocument);

    List<AdminResponseDto> getAllAdmins();

    User saveClient (User user);

   MessageCodeResponseDto isExist(String numDocument);

    ClienteCreateResponseDto saveAdmin (UserAdminRequestDto userAdminRequestDto);
    Client updatePoints (Long id, int points);

    PointsClientResponseDto getPoints (String numberDocument);
}
