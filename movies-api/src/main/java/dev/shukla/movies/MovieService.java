package dev.shukla.movies;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

//Service does not extend anything
//Inside this class we write database access methods
@Service

public class MovieService {
//    inside the service class we need a reference of the repository
//    If you know java you may know that you have to first initialize this bit of code,(MovieRepository) either using a constructor or just use Autowired,
//    @Autowired lets the framework know that we want the framework to instantiate this class for us (te class below the annotation MovieRepository)
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        //this findalll method is described inside MongoRepository class
        return movieRepository.findAll();
    }

//    public Optional<Movie> getSingleMovie(ObjectId id){
//        return movieRepository.findById(id);
//    }

    public Optional<Movie> singleMovie(String imdbId){ return movieRepository.findMovieByImdbId(imdbId); }
}
