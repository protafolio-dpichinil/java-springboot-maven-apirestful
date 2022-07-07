package cl.dpichinil.portafolio.javaspringbootmavenapirestful;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.util.TokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories("cl.dpichinil.portafolio")
@EntityScan("cl.dpichinil.portafolio")
@ComponentScan(basePackages = "cl.dpichinil.portafolio")
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JavaSpringbootMavenApirestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringbootMavenApirestfulApplication.class, args);
    }

}
