package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MemberEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.PrincipalUser;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMemberRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IMemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String numberDocument) throws UsernameNotFoundException {
        
        UserEntity usuario =  userRepository.findByNumberDocument(numberDocument).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        MemberEntity member = memberRepository.findByNumberDocument(numberDocument).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        if (member.getIdMultiplex() == null){
            member.setIdMultiplex(0L);
        }
        List<UserEntity> userEntity = userRepository.findAllById(usuario.getId());

        if (userEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found with number document: " + numberDocument);
        }

        List<RoleEntity> roles = new ArrayList<>();

        for (UserEntity user : userEntity) {
            roles.add(user.getRoleEntity());
        }

        return PrincipalUser.build(usuario, member,roles);
    }
}
