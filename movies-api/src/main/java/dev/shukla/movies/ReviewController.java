package dev.shukla.movies;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    //inside this controller we will have only one post method
    // how are we going to get all these review associated with the move
    // Review form will be inside a movies Details page or in the page where you are viewing a single movie
    // So we can make the requests to the movies and point instead of creating a new review
    // Now when it comes ot creating endpoints like this, it really depends on the developers preferences
    // You may choose to organize your API differently from what is being done here
    // In real life, may be done differenlt, but as we are learning this is fine
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // What we are saying to the framework here is that whatever we get as the request body would like to convert it to a map
        // Map of key string and value string named payload
        // What will happen is that this endpoint will receive JSON data from the ujser and then convert it to a map
        // Where the keys are a string and the values are string
        // From this map we'll be able to access the review body which is a string and ImdbId which is another string
        // And then through the service layer, we can create a new review on the database, update the movie to be associated with that review
        // And then return the review,
        // Ofcourse there's a repository, that works as an intermediary layer between the service class and the databsae
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);

    }
}
