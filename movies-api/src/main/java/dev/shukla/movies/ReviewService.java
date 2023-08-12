package dev.shukla.movies;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.*;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String imdbId) {
        //now that we have a review object we have to insert into the database
        //to insert into the database we need a reference to out ReviewRepository, and it needs to be Autowired
        Review review = reviewRepository.insert(new Review(reviewBody));
        //Review taken care of
        //Now we have to associate with this one of the movies
        //FOr that, first, we'll need a template
        // we know repositories as one of the ways to talk to the database
        // The other way is using a template, times when a repository doesn't cut it
        // when you have an operation so complex that it cannot bbe implemented within a repository
        // or even if you can implement it within a repository, it will be not suitable
        // So then we need a template, we can use this template to form a new dynamic query and
        // do the  job inside the database without using the repository
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
        // we need to mention which class we want to update
        // what we're doing is using the template to perform an update call on movie class
        // Because I hope that you'll remember that each movie our collection contains an empty array of review Ids.
        // So we need to update this array and push a new review Id into this
        // So we say movie.class then we perform matching, which movie are we updating
        // We are updating a movie where the ImdbId of the movie in the database matches the ImdbId that we have received from the user
        // Then we apply this update, To do so we call apply then we create a new update definition
        // Which does the job of making the change inside the database
        // So we say update.push("reviewIds") <- We want to update the reviewIds in Movie, and the value of the movie will be revealed
        // So the review just created will be pushed inside the review  Ids array
        // Finally we will have to specify .first() to make sure that we are getting a single movie and we are updating that
        // Lastly, we return the review, we just created
    }
}
