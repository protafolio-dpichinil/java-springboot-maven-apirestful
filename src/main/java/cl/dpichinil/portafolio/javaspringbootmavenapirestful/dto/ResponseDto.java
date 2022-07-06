package cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private int code;
    private Object data;
    private String message;

    public ResponseDto(int code) {
        this.code = code;
    }

    public ResponseDto(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseDto(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
