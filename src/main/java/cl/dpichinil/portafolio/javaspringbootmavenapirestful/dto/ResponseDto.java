package cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDto {
    private final String message;
}
