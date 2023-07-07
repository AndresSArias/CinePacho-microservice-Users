package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MemberEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {

    UserEntity saveUserEmployee (User user);

    UserEntity saveUserCustomer (User user);

    User getUserByDocument(String numberDocument);

    List<UserEntity> getAllUserAdmin ();

    MemberEntity getMemberById (String id);

}
