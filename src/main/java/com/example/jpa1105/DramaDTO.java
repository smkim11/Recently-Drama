package com.example.jpa1105;

import lombok.*;

import java.util.List;

@Builder
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DramaDTO {
    private long idx;
    private String title;
    private String broadcast;
    private String time;
    private String genre;
    private String actor;
    private String image;
    private String video;
    private String overview;
    private DirectorDTO director;

    }

