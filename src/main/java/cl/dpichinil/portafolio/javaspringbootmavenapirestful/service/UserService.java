package cl.dpichinil.portafolio.javaspringbootmavenapirestful.service;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.UserDto;

public interface UserService {
    public ResponseDto insertUser(UserDto dto);
}
