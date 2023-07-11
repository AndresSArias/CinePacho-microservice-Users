package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MemberEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.QualificationRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.PointsClientResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Client;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {

    UserEntity saveUserEmployee (User user);

    PointsClientResponseDto getPoints (String numberDocument);
    User getUserByDocument(String numberDocument);

    List<UserEntity> getAllUserAdmin ();

    MemberEntity getMemberById (String id);

    User saveClient (User user);

    MessageCodeResponseDto isExist(String numDocument);

    ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto);

    User getUserById (long id);

    Client getClientByDocument (String document);

    Client updateClient (Client client);

    void updateRating(QualificationRequestDto qualificationRequestDto);
}
