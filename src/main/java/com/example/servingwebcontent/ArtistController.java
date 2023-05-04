package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Artist {
    private String name;
    private String genre;

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}

@Controller
public class ArtistController {

    static final ArrayList<Artist> artists = new ArrayList<Artist>() {{
            add(new Artist("Nazareth", "Rock"));
            add(new Artist("Led Zeppelin", "Rock"));
            add(new Artist("Louis Armstrong", "Jazz"));
            add(new Artist("Frank Sinatra", "Jazz"));
            add(new Artist("System of a Down", "Metal"));
            add(new Artist("Metallica", "Metal"));
            add(new Artist("DiDuLya", "Instrumental"));
            add(new Artist("Pink Floyd", "Instrumental"));
            add(new Artist("RadioHead", "Electronic"));
            add(new Artist("Depeche Mode", "Electronic"));
            add(new Artist("Enigma", "New Age"));
            add(new Artist("Enya", "New Age"));
    }};

    @RequestMapping(value = "/artists", method = RequestMethod.GET)

    public String listArtistsChange(@RequestParam(name = "genre", required = false, defaultValue = "all") String genre, Model model) {
            List<Artist> result = artists;

            if (!genre.equals("all")) {
                result = artists.stream().filter(a -> a.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
            }

            model.addAttribute("artists", result);
            return "artistsview";
    }
}

// http://localhost:8080/artists?genre=Rock

