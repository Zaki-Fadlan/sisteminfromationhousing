package com.banyuherangregency.sisteminfromationhousing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "institution")
@Where(clause = "deleted_date is null")
public class Institution extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "institution_name")
    private String institution_name;

    @JsonIgnore
    @OneToMany(mappedBy = "institution")
    private List<PopulationPosition> populationPositions;

    @JsonIgnore
    @OneToMany(mappedBy = "institution")
    private List<Event> events;
}

