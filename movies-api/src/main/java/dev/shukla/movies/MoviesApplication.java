 package dev.shukla.movies;

//springapplication contains a method called run which runs the spring application
//annotations in java are used to let the compiler know what a class does
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

 @SpringBootApplication

@RestController
//@CrossOrigin(origins = "*")
//An annotation which lets the framework know that this class is a Rest API Controller and just another class
public class MoviesApplication {


	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

@GetMapping("/root")
// Lets the framework know that this method is a get endpoint
	public String apiRoot() {
		return "heelliljah";
	}


}
