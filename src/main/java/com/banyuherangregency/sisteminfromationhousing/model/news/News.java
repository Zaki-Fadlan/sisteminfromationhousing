package com.banyuherangregency.sisteminfromationhousing.model.news;

import com.banyuherangregency.sisteminfromationhousing.model.AbstractDate;
import com.banyuherangregency.sisteminfromationhousing.model.PopulationData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "news")
@Where(clause = "deleted_date is null")
public class News extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "start_broadcast")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd HH:mm")
    private Date start_broadcast;

    @Column(name = "end_broadcast")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd HH:mm")
    private Date end_broadcast;

    @Column(name = "news_header")
    private String news_header;

    @Column(name = "news_body")
    private String news_body;

    @JsonIgnore
    @ManyToOne(targetEntity = PopulationData.class)
    @JoinColumn(name = "writer_id")
    private PopulationData writer;

//    Bagaimana jika saya ingin poto?
}

