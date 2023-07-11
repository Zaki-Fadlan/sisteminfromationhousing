package com.banyuherangregency.sisteminfromationhousing.model.complaint;

import com.banyuherangregency.sisteminfromationhousing.model.AbstractDate;
import com.banyuherangregency.sisteminfromationhousing.model.PopulationData;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "complaint")
@Where(clause = "deleted_date is null")
public class Complaint extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "incident_time")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd HH:mm")
    private Date incident_time;

    @Column(name = "description")
    private String description;

    @ManyToOne(targetEntity = ComplaintType.class)
    @JoinColumn(name = "complaint_type")
    private ComplaintType complaint_type;

    @ManyToOne(targetEntity = PopulationData.class)
    @JoinColumn(name = "complainant_id")
    private PopulationData complainant;
}
