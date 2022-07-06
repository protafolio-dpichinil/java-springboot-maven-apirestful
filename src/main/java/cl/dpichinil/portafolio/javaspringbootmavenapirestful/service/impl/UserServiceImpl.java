package cl.dpichinil.portafolio.javaspringbootmavenapirestful.service.impl;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.config.CustomException;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.UserDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.mapper.UserMapper;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity.User;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.repository.UserRepository;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.service.UserService;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.util.ValidatorFields;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseDto insertUser(UserDto dto) {
        ResponseDto response = null;
        ValidatorFields.validateUserDto(dto);
        int count = userRepository.getByEmail(dto.getEmail());
        if(count > 0) throw new CustomException(1003, HttpStatus.INTERNAL_SERVER_ERROR, "insertUser");
        User e = UserMapper.parseUserDtoToUser(dto);
        e.setActive(true);
        e = userRepository.save(e);
        dto = UserMapper.parseUserToUserDto(e);
        response = new ResponseDto(0, dto);
        return response;
    }

}
