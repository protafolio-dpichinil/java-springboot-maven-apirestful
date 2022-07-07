package cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private int id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private String createdDate;
    private String modifiedDate;
    private String lastLogin;
    private String token;
    private boolean active;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PhoneDto> phones;
}