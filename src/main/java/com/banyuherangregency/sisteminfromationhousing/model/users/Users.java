package com.banyuherangregency.sisteminfromationhousing.model.users;

import com.banyuherangregency.sisteminfromationhousing.model.AbstractDate;
import com.banyuherangregency.sisteminfromationhousing.model.PopulationData;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@Where(clause = "deleted_date is null")
public class Users extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", unique = true)
    private String username;

    @ManyToOne(targetEntity = PopulationData.class)
    @JoinColumn(name = "users_id")
    private PopulationData populationData;

    @ManyToOne(targetEntity = UserStatus.class)
    @JoinColumn(name = "status_id")
    private UserStatus userStatus;
}
