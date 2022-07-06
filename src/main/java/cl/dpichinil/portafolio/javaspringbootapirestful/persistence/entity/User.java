package cl.dpichinil.portafolio.javaspringbootapirestful.persistence.entity;

import cl.dpichinil.portafolio.javaspringbootapirestful.dto.PhoneDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @Column(name = "username_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username_id")

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Phone> phones;



}
