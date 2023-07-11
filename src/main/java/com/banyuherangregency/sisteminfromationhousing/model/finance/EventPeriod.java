package com.banyuherangregency.sisteminfromationhousing.model.finance;

import com.banyuherangregency.sisteminfromationhousing.model.AbstractDate;
import com.banyuherangregency.sisteminfromationhousing.model.Event;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "event_period")
@Where(clause = "deleted_date is null")
public class EventPeriod extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "start_period")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date startPeriod;

    @Column(name = "end_period")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date endPeriod;

    @Column(name = "nominal")
    private BigDecimal nominal;
    
    @Column(name = "period_name")
    private String periodName;

    @ManyToOne(targetEntity = Event.class)
    @JoinColumn(name = "event_id")
    private Event events;


}
