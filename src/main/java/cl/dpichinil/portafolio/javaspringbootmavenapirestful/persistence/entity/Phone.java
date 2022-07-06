package cl.dpichinil.portafolio.javaspringbootmavenapirestful.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "\"phone\"")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    @Column(name = "number_id", length = 7, nullable = false)
    private String number;

    @Column(name = "city_code", length = 2, nullable = false)
    private String cityCode;

    @Column(name = "country_code", length = 2, nullable = false)
    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
