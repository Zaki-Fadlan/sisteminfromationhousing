package com.banyuherangregency.sisteminfromationhousing.model;

import com.banyuherangregency.sisteminfromationhousing.model.complaint.Complaint;
import com.banyuherangregency.sisteminfromationhousing.model.news.News;
import com.banyuherangregency.sisteminfromationhousing.model.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "population_data")
@Where(clause = "deleted_date is null")
public class PopulationData extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;

    @Column(name = "kk_number")
    private String kk_number;

    @Column(name = "nik", unique = true)
    private String nik;

    @Column(name = "phone_number")
    private String phone_number;

    @ManyToOne(targetEntity = BlockAddress.class)
    @JoinColumn(name = "block_address_id")
    private BlockAddress block_address;

    @ManyToOne(targetEntity = PositionFamily.class)
    @JoinColumn(name = "position_family_id") // Add join column name
    private PositionFamily position_family; // Rename to position_family

    @ManyToOne(targetEntity = PopulationStatus.class)
    @JoinColumn(name = "population_status_id")
    private PopulationStatus population_status;

    @ManyToOne(targetEntity = PopulationPosition.class)
    @JoinColumn(name = "population_position_id")
    private PopulationPosition population_position;

    @Column(name = "job")
    private String job;

    @JsonIgnore
    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<News> writer_id;

    @JsonIgnore
    @OneToMany(mappedBy = "complainant")
    private List<Complaint> complaint;
    @JsonIgnore
    @OneToMany(mappedBy = "populationData")
    private List<Users> users;
}
