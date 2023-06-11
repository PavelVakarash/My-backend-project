package com.example.servingwebcontent.genre;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private static final ModelMapper modelMapper = new ModelMapper();

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public int createGenre(NewGenreDTO newGenreDTO){
        Genre genre = modelMapper.map(newGenreDTO, Genre.class);
        return genreRepository.save(genre).getId();
        // TODO: save to database
    }
    public GenreDTO getGenre(int id){
        Genre genre = genreRepository.findById(id).get();
        GenreDTO result = modelMapper.map(genre, GenreDTO.class);
        return result;
    }

    public List<GenreDTO> getGenresByName (String name){
        List<Genre> genres = genreRepository.findByName(name);
        return modelMapper.map(genres, new TypeToken<List<GenreDTO>>(){}.getType());
    }
}
