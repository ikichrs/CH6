package com.binar.challenge4.controller;

import com.binar.challenge4.entity.FilmEntity;
import com.binar.challenge4.repository.FilmRepository;
import com.binar.challenge4.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name="Film")
@RestController
@RequestMapping("/film")
public class FilmController {

        @Autowired
        FilmService filmService;

    @Operation(summary="Menambahkan Film")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil ditambahkan.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
        @PostMapping("/post")
        @ResponseStatus(HttpStatus.CREATED)
        public FilmEntity create(@RequestBody FilmEntity film){
            return filmService.savefilm(film);
        }

    @Operation(summary="Menampilkan Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film Berhasil Ditampilkan.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
        @GetMapping("/get")
        public List<FilmEntity> getall(){
            return filmService.findallfilm();
        }

    @Operation(summary="Mengupdate Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil diupdate.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
        @PutMapping("/update/{id}")
        public FilmEntity update(@PathVariable Long id, @RequestBody FilmEntity film){
            return filmService.updateFilm(id,film);
        }

    @Operation(summary="Menghapus Film")
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Film berhasil dihapus.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "400", description = "Eror dari sisi Browser .",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))}),
            @ApiResponse(responseCode = "500", description = "Eror dari sisi Server.",
                    content = {@Content(mediaType="application/json",
                            schema = @Schema(implementation = Response.class))})})
        @DeleteMapping("/delete/{id}")
        public String delete(@PathVariable Long id){
            return filmService.deleteFilm(id);
        }



    }












