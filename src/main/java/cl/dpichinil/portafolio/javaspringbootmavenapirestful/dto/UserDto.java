package cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String createdDate;
    private String modifiedDate;
    private String lastLogin;
    private String token;
    private boolean active;
    private List<PhoneDto> phones;
}