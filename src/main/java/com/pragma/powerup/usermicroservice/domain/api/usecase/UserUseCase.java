package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MemberEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserAdminRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ClienteCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MessageCodeResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IPlazoletaClient;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.AgeNotAllowedForCreationException;
import com.pragma.powerup.usermicroservice.domain.exceptions.DNIIsSoBigException;
import com.pragma.powerup.usermicroservice.domain.exceptions.NitRestaurantException;
import com.pragma.powerup.usermicroservice.domain.exceptions.PhoneLenghtException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.usermicroservice.configuration.Constants.*;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;
    private final IUserEntityMapper userEntityMapper;
    private final IPlazoletaClient plazoletaClient;

    private final PasswordEncoder passwordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort, IUserEntityMapper userEntityMapper,IPlazoletaClient plazoletaClient,PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
        this.userEntityMapper = userEntityMapper;
        this.plazoletaClient = plazoletaClient;
        this.passwordEncoder = passwordEncoder;
    }
    /*
    @Override
    public UserEntity saveUserOwner(User user) {

        if (!validateAge(user.getDateBirth())) {
            throw new AgeNotAllowedForCreationException();
        }

        if (user.getNumberDocument().length() > 20){
            throw new DNIIsSoBigException();
        }




        user.setRole(rolePersistencePort.getRol(OWNER_ROLE_ID));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userPersistencePort.saveUserOwner(user);
    }

    @Override
    public UserEntity saveUserCustomer(User user) {

        if (!validateAge(user.getDateBirth())) {
            throw new AgeNotAllowedForCreationException();
        }

        if (user.getNumberDocument().length() > 20){
            throw new DNIIsSoBigException();
        }

        if (!validatePhone(user)){
            throw new PhoneLenghtException();
        }


        user.setRole(rolePersistencePort.getRol(CUSTOMER_ROLE_ID));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userPersistencePort.saveUserCustomer(user);
    }
    */
    @Override
    public User getUserByDocument(String numberDocument) {
        return userPersistencePort.getUserByDocument(numberDocument);
    }

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<AdminResponseDto> adminResponseDtos = new ArrayList<>();

        List<UserEntity> userEntities = userPersistencePort.getAllUserAdmin();
        List<MemberEntity> memberEntities = new ArrayList<>();
        for (int i = 0; i < userEntities.size(); i++){
            memberEntities.add(userPersistencePort.getMemberById(userEntities.get(i).getNumberDocument()));
            adminResponseDtos.add(new AdminResponseDto(userEntities.get(i).getId()+"",
                    userEntities.get(i).getNumberDocument(),
                    userEntities.get(i).getName(),
                    userEntities.get(i).getDateBirth().format(formatter),
                    userEntities.get(i).getPhone(),
                    userEntities.get(i).getEmail(),
                    memberEntities.get(i).getCodeEmployee(),
                    memberEntities.get(i).getSalary()+"",
                    memberEntities.get(i).getDateContract().format(formatter),
                    memberEntities.get(i).getIdMultiplex()+""));
        }

        return adminResponseDtos;
    }

    @Override
    public User saveClient(User user) {
        if (!validatePhone(user)){
            throw new PhoneLenghtException();
        }
        return userPersistencePort.saveClient(user);
    }

    @Override
    public MessageCodeResponseDto isExist(String numDocument) {
        return userPersistencePort.isExist(numDocument);
    }

    @Override
    public ClienteCreateResponseDto saveAdmin(UserAdminRequestDto userAdminRequestDto) {
        User userPhone= new User();
        userPhone.setPhone(userAdminRequestDto.getPhone());
        if (!validatePhone(userPhone)){
            throw new PhoneLenghtException();
        }
        userAdminRequestDto.setPassword(passwordEncoder.encode(userAdminRequestDto.getPassword()));
        return userPersistencePort.saveAdmin(userAdminRequestDto);
    }

    public boolean validatePhone(User user) {
        String[] phoneComponents = user.getPhone().split(" ");
        user.setPhone("");

        int lenghtPhone = 0;
        for (int i = 0; i  < phoneComponents.length; i++){
            lenghtPhone = lenghtPhone + phoneComponents[i].length();
            user.setPhone(user.getPhone()+phoneComponents[i]);
        }

        return lenghtPhone <= 13;
    }

    public boolean validateAge(LocalDate dateBirth) {
        LocalDate dateNow = LocalDate.now();
        long age =  dateBirth.until(dateNow, ChronoUnit.YEARS);

        return age >= 18l ;
    }
    public Map<String, String> getHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", token);
        return  headers;
    }
}
