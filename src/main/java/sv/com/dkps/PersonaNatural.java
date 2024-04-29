package sv.com.dkps;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "persona")
public class PersonaNatural {

    @Id
    private Long id;
    private String nombreCompleto;

    @OneToOne
    @MapsId
    private Persona persona;


}
