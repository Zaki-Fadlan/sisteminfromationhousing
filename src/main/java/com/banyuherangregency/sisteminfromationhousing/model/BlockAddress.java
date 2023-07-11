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
@Table(name = "block_address")
@Where(clause = "deleted_date is null")
public class BlockAddress extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "block_name")
    private String block_name;

    @JsonIgnore
    @OneToMany(mappedBy = "block_address")
    private List<PopulationData> populationData;

    @ManyToOne(targetEntity = BlockStatus.class)
    @JoinColumn(name = "block_status_id")
    private BlockStatus block_status;
    
}
