package cl.dpichinil.portafolio.javaspringbootapirestful.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private List<PhoneDto> phones;
}