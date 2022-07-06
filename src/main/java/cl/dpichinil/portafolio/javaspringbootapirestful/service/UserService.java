package cl.dpichinil.portafolio.javaspringbootapirestful.service;

import cl.dpichinil.portafolio.javaspringbootapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootapirestful.dto.UserDto;

public interface UserService {
    public ResponseDto insertUser(UserDto dto);
}
