package com.example.servingwebcontent.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    static final ArrayList<ArtistDTO> ARTIST_DTOS = new ArrayList<ArtistDTO>() {{
        add(new ArtistDTO("Nazareth", "Rock"));
        add(new ArtistDTO("Led Zeppelin", "Rock"));
        add(new ArtistDTO("Louis Armstrong", "Jazz"));
        add(new ArtistDTO("Frank Sinatra", "Jazz"));
        add(new ArtistDTO("System of a Down", "Metal"));
        add(new ArtistDTO("Metallica", "Metal"));
        add(new ArtistDTO("DiDuLya", "Instrumental"));
        add(new ArtistDTO("Pink Floyd", "Instrumental"));
        add(new ArtistDTO("RadioHead", "Electronic"));
        add(new ArtistDTO("Depeche Mode", "Electronic"));
        add(new ArtistDTO("Enigma", "New Age"));
        add(new ArtistDTO("Enya", "New Age"));
    }};

    public List<ArtistDTO> getArtists(String genreFilter)
    {
        Iterable<Artist> allArtists = artistRepository.findAll();
        List<ArtistDTO> result = new ArrayList<ArtistDTO>();
        for (Artist artist : allArtists)
        {
            ArtistDTO artistDTO = new ArtistDTO(artist.getName(), artist.getGenre());
            result.add(artistDTO);
        }
        return result;
    }

    public ArtistDTO getArtist(int id)
    {
        Optional<Artist> artistOptional = artistRepository.findById(id);
        Artist artist = artistOptional.get();
        ArtistDTO artistDTO = new ArtistDTO(artist.getName(),artist.getGenre());
        return artistDTO;
    }

    public void deleteArtist(int id)
    {
        artistRepository.deleteById(id);
        // TODO: remove it from the database
    }

    public void updateArtist(int id, ArtistDTO artistDTO)
    {
        Artist artist = artistRepository.findById(id).get();
        artist.setName(artistDTO.getName());
        artist.setGenre(artistDTO.getGenre());
        artistRepository.save(artist);
        // TODO: update artistDTO in the database

    }

    public void createArtist(ArtistDTO artistDTO)
    {
        String name = artistDTO.getName();
        String genre = artistDTO.getGenre();

        Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);
        // TODO: save to database
        artistRepository.save(artist);
    }
}
