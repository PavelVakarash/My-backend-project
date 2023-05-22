package com.example.servingwebcontent.artist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

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

    public List<ArtistDTO> getArtists(String genreFilter) {
        List<ArtistDTO> result = ARTIST_DTOS;

        if (!genreFilter.equals("all")) {
            result = ARTIST_DTOS.stream().filter(e -> e.getGenre().equals(genreFilter)).collect(Collectors.toList());
        }
        return result;
    }

    public ArtistDTO getArtist(int id)
    {
        ArtistDTO artistDTO = ARTIST_DTOS.get(id);
        return artistDTO;
    }

    public ArtistDTO deleteArtist(int id)
    {
        ArtistDTO artistDTO = ARTIST_DTOS.get(id);
        // TODO: remove it from the database
        return artistDTO;
    }

    public ArtistDTO updateArtist(int id, ArtistDTO artistDTO)
    {
        ArtistDTO origArtistDTO = ARTIST_DTOS.get(id);
        // TODO: update artistDTO in the database
        return artistDTO;
    }

    public ArtistDTO createArtist(ArtistDTO artistDTO)
    {
        // TODO save to database
        return artistDTO;
    }
}
