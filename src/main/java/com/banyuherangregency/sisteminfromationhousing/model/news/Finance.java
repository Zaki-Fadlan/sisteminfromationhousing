package com.banyuherangregency.sisteminfromationhousing.model.news;

import com.banyuherangregency.sisteminfromationhousing.model.AbstractDate;
import com.banyuherangregency.sisteminfromationhousing.model.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "finance")
@Where(clause = "deleted_date is null")
public class Finance extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @JsonIgnore
    @ManyToOne(targetEntity = Event.class)
    @JoinColumn(name = "event_id")
    private Event events;

    @Column(name = "nominal")
    private BigDecimal nominal;

    @Column(name = "description")
    private String description;
}
