package cl.dpichinil.portafolio.javaspringbootmavenapirestful.util;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.config.MessageProperties;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Parse {
    public static String generateMessageProperties(MessageProperties messageProperties, int code, String module) {
        String response = "";
        switch (module){
            case "insertUser":
                response = messageProperties.getInsertUser().get(code);
                break;
            default:
                break;
        }
        return response;
    }
}
