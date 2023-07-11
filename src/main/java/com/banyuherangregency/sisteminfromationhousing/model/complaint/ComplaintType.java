package com.banyuherangregency.sisteminfromationhousing.model.complaint;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "complaint_type")
public class ComplaintType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type_name")
    private String type_name;

    @OneToMany(mappedBy = "complaint_type")
    private List<Complaint> complaints;
}
