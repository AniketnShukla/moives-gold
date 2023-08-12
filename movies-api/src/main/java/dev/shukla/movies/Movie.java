package dev.shukla.movies;

import lombok.*;
import org.bson.types.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "movies")
@Data
@AllArgsConstructor
public class Movie {
    @Id
    private ObjectId id;;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
}
