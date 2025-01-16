package com.example.jpa1105;

import java.util.List;

public interface DramaService {
    List<DramaDTO> findAll();
    DramaDTO findById(long idx);
    void save(DramaDTO drama);
    void deleteById(long idx);
    List<DramaDTO> search(String title);
    DirectorDTO findByDirectorId(String directorId);
    List<DramaDTO> searchByGenre(String genre);
    List<String> getUniqueGenres();
}