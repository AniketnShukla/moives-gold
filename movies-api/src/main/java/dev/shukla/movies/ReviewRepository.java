package dev.shukla.movies;

import org.bson.types.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
