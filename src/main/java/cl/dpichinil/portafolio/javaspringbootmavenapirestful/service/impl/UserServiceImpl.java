package cl.dpichinil.portafolio.javaspringbootmavenapirestful.service.impl;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.config.CustomException;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.PhoneDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.UserDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.mapper.PhoneMapper;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.mapper.UserMapper;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity.Phone;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity.User;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.repository.PhoneRepository;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.repository.UserRepository;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.service.UserService;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.util.TokenUtil;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.util.ValidatorFields;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;

    @Override
    @Transactional
    public UserDto insertUser(UserDto dto) {
        ValidatorFields.validateUserDto(dto);

        int count = userRepository.getByEmail(dto.getEmail());
        if(count > 0) throw new CustomException(1003, HttpStatus.INTERNAL_SERVER_ERROR, "insertUser");
        String token = TokenUtil.generateToken(dto.getEmail());
        dto.setToken(token);

        User user = UserMapper.parseUserDtoToUser(dto);
        user.setActive(true);
        user = userRepository.save(user);

        List<Phone> listPhone = new ArrayList<>();
        for (PhoneDto phoneDto: dto.getPhones()) {
            Phone phone = PhoneMapper.phoneDtoToPhone(phoneDto);
            phone.setUser(user);
            phone = phoneRepository.save(phone);
            listPhone.add(phone);
        }
        user.setListPhone(listPhone);

        dto = UserMapper.parseUserToUserDto(user);
        dto.setEmail(null);
        dto.setPassword(null);
        dto.setPhones(null);
        dto.setName(null);
        return dto;
    }

    @Override
    public UserDto getUserById(int id) {
        UserDto dto = null;
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()){
            dto = UserMapper.parseUserToUserDto( u.get()  );
        }
        return dto;
    }

}
