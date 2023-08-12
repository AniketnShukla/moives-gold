package dev.shukla.movies;

import lombok.*;
import org.bson.types.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

// We have an all args constructor and a no args contrictor but since Ids are auto generated we cannot
//  pass an ID to this class. So what we will do we will generate a custom constructor that takes only the body.
public class Review {
    @Id
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }
}
