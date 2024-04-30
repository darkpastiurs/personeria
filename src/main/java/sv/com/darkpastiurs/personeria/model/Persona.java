package sv.com.darkpastiurs.personeria.model;

import java.util.Objects;

import jakarta.persistence.*;
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
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonaJuridica personaJuridica;

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

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        if (Objects.isNull(personaJuridica)) {
            if (Objects.nonNull(this.personaJuridica)) {
                this.personaJuridica.setPersona(null);
            }
        } else {
            personaJuridica.setPersona(this);
        }
        this.personaJuridica = personaJuridica;
    }

}
