package com.example.jpa1105;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DramaServiceImpl implements DramaService {

    @Autowired
    private DramaRepository dramaRepository;
    @Autowired
    private DirectorRepository directorRepository;
    @Override
    public List<DramaDTO> findAll() {
       return dramaRepository.findAll().stream()
               .map(Utils::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public DramaDTO findById(long idx) {
        return dramaRepository.findById(idx)
                .map(Utils::toDTO)
                .orElse(null);
    }

    @Override
    public void save(DramaDTO dramaDTO) {
        Drama drama =  Utils.toEntity(dramaDTO);
        dramaRepository.save(drama);
    }

    @Override
    public void deleteById(long idx) {
        dramaRepository.deleteById(idx);
    }

    @Override
    public List<DramaDTO> search(String title) {
        return dramaRepository.findByTitleContaining(title).stream()
                .map(Utils::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DramaDTO> searchByGenre(String genre) {
        return dramaRepository.findByGenreContaining(genre).stream()
                .map(Utils::toDTO)
                .collect(Collectors.toList());
    }
    public List<String> getUniqueGenres() {
        return dramaRepository.findDistinctGenres();
    }

    @Override
    public DirectorDTO findByDirectorId(String directorId) {
        return directorRepository.findByDirectorId(directorId)
                .map(Utils::toDTO)
                .orElse(null);
    }

}