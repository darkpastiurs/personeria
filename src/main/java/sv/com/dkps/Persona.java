package sv.com.dkps;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonaNatural personaNatural;

    public void setPersonaNatural(PersonaNatural personaNatural) {
        if (Objects.isNull(personaNatural)) {
            if (Objects.nonNull(this.personaNatural)) {
                this.personaNatural.setPersona(null);
            }
        } else {
            personaNatural.setPersona(this);
        }
        this.personaNatural = personaNatural;
    }

}
