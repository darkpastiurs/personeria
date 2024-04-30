package sv.com.darkpastiurs.personeria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "persona")
public class PersonaNatural {

    @Id
    private Long id;
    @Column
    private String nombreCompleto;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Persona persona;


}
