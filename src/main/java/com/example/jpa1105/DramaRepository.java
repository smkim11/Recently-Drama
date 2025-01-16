package com.example.jpa1105;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Arrays;
import java.util.List;

public interface DramaRepository extends JpaRepository<Drama, Long> {
    List<Drama> findByTitleContaining(String title);
    @Query("SELECT d FROM Drama d JOIN FETCH d.director")
    List<Drama> findWithDirector();
    List<Drama> findByGenreContaining(String genre);
    @Query("SELECT DISTINCT d.genre FROM Drama d")
    List<String> findDistinctGenres();
}
