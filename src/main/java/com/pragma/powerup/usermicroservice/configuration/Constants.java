package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long DIRECTOR_ROLE_ID = 1L;
    public static final Long ADMIN_ROLE_ID = 2L;
    public static final Long EMPLOYEE_ROLE_ID = 3L;
    public static final Long CLIENT_ROLE_ID = 4L;

    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PLATE_UPDATED_MESSAGE = "The points of user is succesfull update";
    public static final String RAITING_SERIVE_UPDATED_MESSAGE = "The qualification of service update successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credential";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String NO_FORMAT_DATE_MESSAGE = "Bad Request, the format of date is invalid";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the DNI number provided";
    public static final String MAIL_ALREADY_EXISTS_MESSAGE = "A user with that mail already exists";
    public static final String USER_NOT_FOUND_MESSAGE = "No user found with the id provided";
    public static final String CLIENT_NOT_FOUND_MESSAGE = "The user with the id provided is no client";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String AGE_NOT_ALLOWED_MESSAGE = "The age of user is no allowed";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
    public static final String DNI_SIZE_BIG_MESSAGE = "The size of DNI is so big";
    public static final String PHONE_LENGHT_MESSAGE = "The lenght of Phone is over 13";
    public static final String EMPLOYEE_HAS_WORK_MESSAGE = "The worker who wants to register already has a job.";
    public static final String PROBLEM_NIT_RESTAURANT_MESSAGE = "A problem has occurred with the restaurant nit provided in the request.";
    public static final String CLIENT_CANNOT_UPDATE_RAITING_MESSAGE = "The client cannot update qualification because already updated";
    public static final String ROLES = "roles";
    public static final String IDUSER = "idUser";

}
