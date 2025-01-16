package com.example.jpa1105;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long>     {
    Optional<Director> findByDirectorId(String directorId);
}
