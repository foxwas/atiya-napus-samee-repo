	/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.rest.client;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;
import com.javatunes.domain.MusicItemCollectionWrapper;

@SpringBootApplication
public class RestTemplateClient implements CommandLineRunner {


	private final static String BASE_URI = "http://localhost:8080/javatunes/rest/items";
	private final static String ID_URI = BASE_URI + "/{id}";

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateClient.class, args);
	}

	  @Override
	  public void run(String... arg0) throws Exception {
		RestTemplate rt = new RestTemplate();
		
		rt.getMessageConverters().add(new MappingJackson2XmlHttpMessageConverter());
	
		String getId = "3";
		String deleteId = "5";
		String putId = "6";
		
		// Uncomment to run a GET.
		doGetItem(rt, getId);

		// Uncomment to run a DELETE
		doDeleteItem(rt, deleteId);
		
		// Uncomment to run a PUT
		 doPutItem(rt, putId);
		
		// Uncomment to run a POST
		doPostItem(rt);	

	}
	  
	  private MusicItem doGetItem(RestTemplate rt, String id) {
		  MusicItem found = rt.getForObject(ID_URI, MusicItem.class,id);
		  System.out.println();
		  System.out.println("Found item - " + id + " : " + found);
		  System.out.println();
		  return found;
	  }
	  
	  private void doDeleteItem(RestTemplate rt, String id) {
		  System.out.println("\n *** About to delete item with id = " + id);
		  MusicItem found = doGetItem(rt, id);
		  if (found != null) { 
			  rt.delete(ID_URI,id);
			  System.out.println(" *** Deleted item shouldn't appear in below list ***");
			  doGetAllItems(rt);
		  }
		  else {
			  System.out.format(" *** Item with id %s not found for delete ***", id);
		  }
	  }
	  
	  private void doGetAllItems(RestTemplate rt) {
		  MusicItemCollectionWrapper allItems = rt.getForObject(BASE_URI, MusicItemCollectionWrapper.class);
			System.out.println();
			allItems.getItems().stream().forEach(item -> System.out.println(item));
			System.out.println();		  
	  }
	  
	  private void doPutItem(RestTemplate rt, String id) {

			MusicItem found = rt.getForObject(ID_URI, MusicItem.class,id);
			System.out.println();
			System.out.println("Found item - " + id + " : " + found);
			System.out.println();
			
			MusicItem updatedItem = new MusicItem(found.id(), " *** changed this *** ", found.artist(), found.releaseDate(), found.price(), found.musicCategory());
			// DONE: Add call to PUT, using the putId variable above, and the found object		
			rt.put(ID_URI, updatedItem, id);

			found = rt.getForObject(ID_URI, MusicItem.class,id);
			System.out.println();
			System.out.println("Found item after put - " + id + " : " + found);
			System.out.println();
	  }

	  private void doPostItem(RestTemplate rt) {
			// Testing POST for create.
			MusicItem newItem = new MusicItem(null, "FoxTitle", "Fox", LocalDate.now(), new BigDecimal("12.95"), MusicCategory.ROCK);
			
			// Call to POST (for object), using the newItem object as the request object
			MusicItem createdItem = rt.postForObject(BASE_URI, newItem, MusicItem.class);
			System.out.println();
			System.out.println("Created new item: " + createdItem);
			System.out.println();
			
			// Call to POST (for location), using the newItem object as the request object
			URI createdURI = rt.postForLocation(BASE_URI, newItem);
			System.out.println();
			System.out.println("Created another new item (with different id) at location: " + createdURI);
			System.out.println();

			MusicItemCollectionWrapper allItems = rt.getForObject(BASE_URI, MusicItemCollectionWrapper.class);
			System.out.println();
			System.out.println("All Objects found after POST: ");
			for (MusicItem cur: allItems.getItems()) {
				System.out.println(cur);
			}
			System.out.println();
	  }
}
