package com.example.mucal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShowSchedule {

    @Id
    @Column(name="show_schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;


    // @Join~~
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Show show;

    @Column
    private int preCheck;

    @Column
//    @DateTimeFormat(pattern = "yyyy-mm-ddTHH:mm")
    private String date;

    @ElementCollection
    private List<String> site;

    @ElementCollection
    @Column(length=1000)
    private List<String> image;

    @Builder
    public ShowSchedule(Show show, int preCheck, String date, List<String> site, List<String> image){
        this.show=show;
        this.preCheck=preCheck;
        this.date=date;
        this.site=site;
        this.image=image;
    }
}
