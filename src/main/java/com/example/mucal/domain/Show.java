package com.example.mucal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Show {

    @Id
    @Column(name="show_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column
    private String title;

    @Column
    private String category;

// 양방향 해야할 경우 *.*
    // show 가 연관관계의 주인
//    @OneToMany(mappedBy = "show", cascade ={CascadeType.REMOVE})
//    @JsonBackReference
//    private List<ShowSchedule> showSchedules=new ArrayList<>(); // add 시 nullPointException 방지

    // 연관관계 편의 메소드
//    public void addShowSchedule(ShowSchedule showSchedule){
//        showSchedules.add(showSchedule);
//        showSchedule.setShow(this);
//    }

    @Builder
    public Show(String title, String category){
        this.title=title;
        this.category=category;
    }

    @Override
    public String toString(){
        return "#"+id+" 타이틀: "+title;
    }
}
