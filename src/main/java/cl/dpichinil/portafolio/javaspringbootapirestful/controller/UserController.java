package cl.dpichinil.portafolio.javaspringbootapirestful.controller;

import cl.dpichinil.portafolio.javaspringbootapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootapirestful.dto.UserDto;
import cl.dpichinil.portafolio.javaspringbootapirestful.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> insert(@RequestBody UserDto dto){
        ResponseEntity<ResponseDto> response = null;
        ResponseDto responseDto = userService.insertUser(dto);
        response = new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        return response;
    }
}
