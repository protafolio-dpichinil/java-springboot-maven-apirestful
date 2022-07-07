package cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.repository;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone,Integer> {
}
