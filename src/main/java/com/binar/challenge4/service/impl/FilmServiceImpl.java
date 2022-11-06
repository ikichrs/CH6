package com.binar.challenge4.service.impl;

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
    public Optional<FilmEntity> findById(Long userid) {
        return filmRepository.findById(userid);
    }

    @Override
    public FilmEntity savefilm(FilmEntity filmEntity) {
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity updateFilm(Long id, FilmEntity filmEntity) {
        FilmEntity filmEntityFINDID=filmRepository.findById(id).get();
        filmEntityFINDID.setFilmtitle(filmEntity.getFilmtitle());
        filmEntityFINDID.setStatus(filmEntity.getStatus());
        filmEntityFINDID.setDurasi(filmEntity.getDurasi());
        return filmRepository.save(filmEntityFINDID);
    }

    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "Film Berhasil Di Hapus";
    }
}
