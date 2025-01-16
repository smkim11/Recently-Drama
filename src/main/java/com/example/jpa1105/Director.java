package com.example.jpa1105;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity @Table(name = "director")
@ToString
@Getter
@Builder
@NoArgsConstructor()
@AllArgsConstructor
public class Director {
    @Id
    @Column(name="director_id")
    private String directorId;
    @Column(name="name")
    private String name;
    @Column(name="birth")
    private String birth;
    @Column(name="nationality")
    private String nationality;
    @Column(name="photo")
    private String photo;
    @Column(name="work")
    private String work;


}
