package com.banyuherangregency.sisteminfromationhousing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "block_status")
public class BlockStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "status_name")
    private String status_name;

    @JsonIgnore
    @OneToMany(mappedBy = "block_status")
    private List<BlockAddress> blockAddress;
}
