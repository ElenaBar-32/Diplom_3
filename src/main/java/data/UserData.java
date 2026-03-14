package data;

import com.github.javafaker.Faker;

public class UserData {
    public static final String BASE_URI ="https://qa-scooter.praktikum-services.ru/";
    static Faker user = new Faker();

    public static final String NAME = user.name().firstName();
    public static final String EMAIL = user.internet().emailAddress();
    public static final String PASSWORD = user.regexify("[0-9]{8}");
    public static final String INVALID_PASSWORD = user.regexify("[0-9]{5}");
    public static final String CREATE_USER = "/api/auth/register";
    public static final String DELETE_USER = "/api/auth/user";
}
