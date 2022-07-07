package cl.dpichinil.portafolio.javaspringbootmavenapirestful.config.security;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.dto.ResponseDto;
import cl.dpichinil.portafolio.javaspringbootmavenapirestful.util.Parse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {
        ResponseDto dto = new ResponseDto("Acceso no autorizado a la api");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, Parse.ObjectToJson(dto) );
    }
}
