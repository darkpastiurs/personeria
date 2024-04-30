package sv.com.darkpastiurs.personeria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "persona")
public class PersonaJuridica {

    @Id
    private Long id;
    @Column
    private String nombreSociedad;
    @Column
    private String nombreComercial;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Persona persona;
}
