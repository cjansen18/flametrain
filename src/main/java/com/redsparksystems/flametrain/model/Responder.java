package com.redsparksystems.flametrain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode(exclude = "trainingEvents")
@Entity
public class Responder {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String firstName, lastName;
    private LocalDate birthDate;

//The entity that specifies the @JoinTable is the owning side of the relationship
// and the entity that specifies the mappedBy attribute is the inverse side.
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "responderSet")
    private Set<TrainingEvent> trainingEvents = new HashSet<>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Responder)) return false;
//        Responder responder = (Responder) o;
//        return Objects.equals(firstName, responder.firstName) &&
//                Objects.equals(lastName, responder.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(firstName, lastName);
//    }
}


