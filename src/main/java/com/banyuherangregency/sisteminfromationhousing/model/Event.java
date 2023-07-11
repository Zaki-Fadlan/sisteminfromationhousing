package com.banyuherangregency.sisteminfromationhousing.model;

import com.banyuherangregency.sisteminfromationhousing.model.finance.EventPeriod;
import com.banyuherangregency.sisteminfromationhousing.model.news.Finance;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "event")
@Where(clause = "deleted_date is null")
public class Event extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "event_name")
    private String eventName;

    @ManyToOne(targetEntity = Institution.class)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @JsonIgnore
    @OneToMany(mappedBy = "events")
    private List<EventPeriod> eventPeriods;
    
    @JsonIgnore
    @OneToMany(mappedBy = "events")
    private List<Finance> finances;
}
