package cl.dpichinil.portafolio.javaspringbootapirestful.persistence.repository;

import cl.dpichinil.portafolio.javaspringbootapirestful.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
