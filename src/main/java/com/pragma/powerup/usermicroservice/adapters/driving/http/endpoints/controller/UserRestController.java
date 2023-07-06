package com.pragma.powerup.usermicroservice.adapters.driving.http.endpoints.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserEmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AdminResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.AuthUserResponse;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class UserRestController {

    private final IUserHandler userHandler;

    @Operation(summary = "Show all admins multiplex in system")
    @GetMapping("/all/admins")
    public ResponseEntity<List<AdminResponseDto>> getAllAdmins() {
        return ResponseEntity.ok(userHandler.getAllAdmins());
    }
/*
    @Operation(summary = "Add a new userOwner",
            responses = {
                    @ApiResponse(responseCode = "201", description = "UserOwner created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "UserOwner already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for user creation",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/createUserOwner")
    public ResponseEntity<Map<String, String>> saveUserOwner(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveUserOwner(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USER_OWNER_CREATED_MESSAGE));
    }
*/
    @Operation(summary = "Get a user for conect MicroserviceMultiplex",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User returned",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthUserResponse.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})

    @GetMapping("/getUser/{numberDocument}")
    public ResponseEntity<AuthUserResponse> getUser(@PathVariable String numberDocument) {
        return ResponseEntity.ok(userHandler.getUsuario(numberDocument));
    }
/*

    @PostMapping("/createUserCustomer")
    public ResponseEntity<Map<String, String>> saveUserCustomer(@Valid @RequestBody UserRequestDto userRequestDto) {
        userHandler.saveUserCustomer(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USER_EMPLOYEE_CREATED_MESSAGE));
    }

*/
}
