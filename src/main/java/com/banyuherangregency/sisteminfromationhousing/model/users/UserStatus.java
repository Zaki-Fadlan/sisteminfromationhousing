package com.banyuherangregency.sisteminfromationhousing.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user_status")
public class UserStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status_name")
    private String statusName;

    @JsonIgnore
    @OneToMany(mappedBy = "userStatus")
    private List<Users> users;

}
