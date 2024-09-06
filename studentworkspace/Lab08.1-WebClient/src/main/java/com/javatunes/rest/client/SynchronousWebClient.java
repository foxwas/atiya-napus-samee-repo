/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;
import com.javatunes.domain.MusicItemCollectionWrapper;


@SpringBootApplication
public class SynchronousWebClient implements CommandLineRunner {

	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	
	// Includes URI Template variable for an item id
	private final static String ID_URI = "/{id}";

	public static void main(String[] args) {
		SpringApplication.run(SynchronousWebClient.class, args);
	}

	  @Override
	  public void run(String... arg0) throws Exception {

		// Create instance of WebClient (we'll reuse it)
		WebClient webClient = WebClient.create(BASE_URI);
		
		MusicItem found = null;
		

		String deleteId = "5";
		// Get item that we're going to delete
		found = webClient
				
				.get()								// Configure a get request
				.uri(ID_URI, deleteId)				// Add URI Template
				.accept(MediaType.APPLICATION_JSON)	// Specify JSON
				.retrieve()		// Move on to declaring response processing
				.bodyToMono(MusicItem.class)		// Convert to our response type
				.block();							// And block so it's done synchronously
		System.out.println("found item for delete is " + found);

		// Delete the item
		ResponseEntity<Void> response = webClient
			.delete()				// Configure delete request
			.uri(ID_URI, deleteId)	// Add URI Template
			.retrieve()				// Move on to declaring response processing
			.toBodilessEntity()		// Convert to entity with no body
			.block();				// And block so it's done synchronously
		
		System.out.println("Response from delete is: " + response.getStatusCode());
		
		
		// Now let's see if our item was deleted - we'll output all the items here.
		MusicItemCollectionWrapper foundAll = null;
		
		// Get a stream of MusicItem using WebClient.get() and BASE_URI to see if deleted item is there
		// Comes in as a MusicItemCollectionWrapper, 
		
		foundAll = webClient
				.get() 			// Configure a get
				.retrieve()		// Move on to declaring response processing
				.bodyToMono(MusicItemCollectionWrapper.class)  // Convert to our response type
				.block();		// And block so it's done synchronously 
		System.out.println(" *** Deleted item shouldn't appear in below list ***");
		foundAll.getItems().stream().forEach(item -> System.out.println(item));
		System.out.println(" *** \n\n");

		

		// Testing PUT for update.
		
	String putId = "6";

		// First get the item to update by id
		found = webClient  
				.get() 				// Configure a get request
				.uri(ID_URI, putId) // Add URI Template with appropriate value
				.accept(MediaType.APPLICATION_JSON) // Specify JSON
				.retrieve()			// Move on to declaring response processing
				.bodyToMono(MusicItem.class) // Convert to our response type
				.block();			// And block so it's done synchronously
		System.out.println("found item for PUT is " + found);
		
		// Create a new MusicItem instance with a different title but id and all other properties the same
		MusicItem updatedItem = new MusicItem(found.id(), " *** changed this *** ", found.artist(), found.releaseDate(), found.price(), found.musicCategory());

		// Execute the put call
		ResponseEntity<MusicItem> putResponse  = 
		webClient.put()
		.uri(ID_URI, putId) 				// Add URI Template with appropriate value
		.accept(MediaType.APPLICATION_JSON) // Specify JSON
		.bodyValue(updatedItem)				// Add in the MusicItem to the body
		.retrieve()							// Move on to declaring response processing
		.toEntity(MusicItem.class)			// Get the ResponseEntity
		.block();							// And block so it's done synchronously
		System.out.println();
		System.out.println(" *** Status code and modified item appear below ***");
		System.out.println(putResponse.getStatusCode());
		System.out.println(putResponse.getBody());
		System.out.println(" *** \n\n");
	


		// Testing POST for create.

		MusicItem newItem = new MusicItem(null, "FoxTitle", "FoxRocks!", LocalDate.now(), new BigDecimal("1000.00"), MusicCategory.ROCK);

		ResponseEntity<MusicItem> postResponse = webClient
				.post()				// Configure a post
				.bodyValue(newItem) // add in the body value for post
				.retrieve()			// Move on to declaring response processing
				.toEntity(MusicItem.class) // Get the ResponseEntity
				.block();			// And block so it's done synchronously
		System.out.println();
		System.out.println("Post status code is: " + postResponse.getStatusCode());
		System.out.println("Location returned from post is: " + postResponse.getHeaders().getFirst("Location"));
		System.out.println(postResponse.getBody());
		System.out.println(" *** \n\n");
			

		// Here's an alternate POST version that uses exchangeToMono which takes a lamdba expression
		 // The syntax is ugly, but can be convenient once you're used to it.
	/*	
		MusicItem newItem1 = new MusicItem(null, "MyTitle", "Me!", LocalDate.now(), new BigDecimal("12.95"), MusicCategory.ALTERNATIVE);

		MusicItem returnedItem = WebClient.create(BASE_URI).post()
				.bodyValue(newItem1) // add in the body value for post
				.exchangeToMono(postResponse -> { // Access the ClientResponse, and then return the incoming object
					System.out.println(postResponse.getClass().descriptorString());
				System.out.println("Post status code is: " + postResponse.statusCode());
				System.out.println("Location returned from post is: " + postResponse.headers().header("Location"));
				return postResponse.bodyToMono(MusicItem.class);
			}).block();
		System.out.println("Returned item after post is: " + returnedItem);
*/
	}
}
