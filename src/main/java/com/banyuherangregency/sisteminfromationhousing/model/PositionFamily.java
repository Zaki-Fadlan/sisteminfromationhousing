package com.banyuherangregency.sisteminfromationhousing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "position_family")
public class PositionFamily implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "position_name")
    private String position_name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "position_family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PopulationData> populationData;
}
