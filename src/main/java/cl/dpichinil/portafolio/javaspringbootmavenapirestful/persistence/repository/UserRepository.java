package cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.repository;

import cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT COUNT(u) FROM User u WHERE u.email=?1")
    public Integer getByEmail(String email);
}
