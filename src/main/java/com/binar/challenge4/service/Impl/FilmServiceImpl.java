package com.binar.challenge4.service.Impl;

import com.binar.challenge4.entity.FilmEntity;
import com.binar.challenge4.repository.FilmRepository;
import com.binar.challenge4.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;


    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    @Override
    public List<FilmEntity> findallfilm() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<FilmEntity> findById(Long user_id) {
        return filmRepository.findById(user_id);
    }

    @Override
    public FilmEntity savefilm(FilmEntity filmEntity) {
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity updateFilm(Long id, FilmEntity filmEntity) {
        FilmEntity FilmEntityFINDID=filmRepository.findById(id).get();
        FilmEntityFINDID.setFilm_title(filmEntity.getFilm_title());
        FilmEntityFINDID.setStatus(filmEntity.getStatus());
        FilmEntityFINDID.setDurasi(filmEntity.getDurasi());
        return filmRepository.save(FilmEntityFINDID);
    }

    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "Film Berhasil Di Hapus";
    }
}
