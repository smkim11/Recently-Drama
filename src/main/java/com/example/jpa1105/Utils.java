package com.example.jpa1105;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    // Drama -> DramaDTO 변환
    public static DramaDTO toDTO(Drama entity) {
        return DramaDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .broadcast(entity.getBroadcast())
                .time(entity.getTime())
                .actor(entity.getActor())
                .genre(entity.getGenre())
                .image(entity.getImage())
                .video(entity.getVideo())
                .overview(entity.getOverview())
                .director(toDTO(entity.getDirector())) // Director -> DirectorDTO 변환
                .build();
    }

    // DramaDTO -> Drama 변환
    public static Drama toEntity(DramaDTO dto) {
        return Drama.builder()
                .idx(dto.getIdx())
                .title(dto.getTitle())
                .broadcast(dto.getBroadcast())
                .time(dto.getTime())
                .actor(dto.getActor())
                .genre(dto.getGenre())
                .image(dto.getImage())
                .video(dto.getVideo())
                .overview(dto.getOverview())
                .director(toEntity(dto.getDirector())) // DirectorDTO -> Director 변환
                .build();
    }

    // Director -> DirectorDTO 변환
    public static DirectorDTO toDTO(Director entity) {
        if (entity == null) return null;
        return DirectorDTO.builder()
                .directorId(entity.getDirectorId())
                .name(entity.getName())
                .birth(entity.getBirth())
                .nationality(entity.getNationality())
                .photo(entity.getPhoto())
                .work(entity.getWork())
                .build();
    }

    // DirectorDTO -> Director 변환
    public static Director toEntity(DirectorDTO dto) {
        if (dto == null) return null;
        return Director.builder()
                .directorId(dto.getDirectorId())
                .name(dto.getName())
                .birth(dto.getBirth())
                .nationality(dto.getNationality())
                .photo(dto.getPhoto())
                .work(dto.getWork())
                .build();
    }
}

