package com.example.jpa1105;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "drama")
@ToString
@Getter
@Builder
@NoArgsConstructor()
@AllArgsConstructor
public class Drama {

    @Id
    @Column(name ="idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(name ="title")
    private String title;

    @Column(name ="broadcast")
    private String broadcast;

    @Column(name ="time")
    private String time;

    @Column(name ="genre")
    private String genre;

    @Column(name ="actor")
    private String actor;

    @Column(name ="image")
    private String image;

    @Column(name ="video")
    private String video;

    @Column(name ="overview")
    private String overview;

    @Column(name = "director_id", insertable = false, updatable = false)
    private String directorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Director director;
}