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
@Table(name = "population_position")
@Where(clause = "deleted_date is null")
public class PopulationPosition extends AbstractDate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "position_name")
    private String postion_name;

    @JsonIgnore
    @OneToMany(mappedBy = "population_position")
    private List<PopulationData> populationData;

    @ManyToOne(targetEntity = Institution.class)
    private Institution institution;
}
