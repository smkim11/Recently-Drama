package com.example.jpa1105;
import lombok.*;

@Builder
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {
    private String directorId;
    private String name;
    private String birth;
    private String nationality;
    private String photo;
    private String work;
}
