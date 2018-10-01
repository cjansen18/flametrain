package com.redsparksystems.flametrain.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "responderSet")
@Builder
@Entity
public class TrainingEvent {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String className;
    private LocalDateTime classStartDate, classEndDate;
    private int totalClassHours;

    //The entity that specifies the @JoinTable is the owning side of the relationship
    // and the entity that specifies the mappedBy attribute is the inverse side.
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "trainingevent_responder",
            joinColumns = { @JoinColumn(name = "trainingevent_id") },
            inverseJoinColumns = { @JoinColumn(name = "responder_id") })
    private Set<Responder> responderSet=new HashSet<>();

}
