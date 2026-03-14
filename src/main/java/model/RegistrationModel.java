

package model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegistrationModel {
    private String email;
    private String password;
    private String name;
    public RegistrationModel(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}