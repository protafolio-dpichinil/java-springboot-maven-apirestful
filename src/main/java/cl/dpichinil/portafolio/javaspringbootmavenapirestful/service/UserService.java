package cl.dpichinil.portafolio.javaspringbootmavenapirestful.service;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.UserDto;

public interface UserService {
    public UserDto insertUser(UserDto dto);

    public UserDto getUserById(int id);
}
