package com.pizzashop.restclient;

import com.pizzashop.restclient.models.Ingredient;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@SpringBootApplication
public class RestclientApplication {

    public static int timeInterval;

    public static void main(String[] args) {

        GetIngredient();
        Random rand = new Random();

        timeInterval = rand.nextInt(10000) + 10000;

        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println(timeInterval);
                AddIngredient();
                timeInterval = rand.nextInt(10000) + 10000;
            }
        };
        Timer timer = new Timer("Timer");

        long delay  = 1000L;
        long period = 10000;
        timer.scheduleAtFixedRate(repeatedTask, delay,  timeInterval);
    }

    public static void AddIngredient(){
        final String postUri = "http://localhost:8080/api/v1/ingredients";

        Ingredient newIngredient = new Ingredient("Cinnamon");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", String.valueOf(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Ingredient> requestBody = new HttpEntity<>(newIngredient, headers);
        Ingredient postedIngredient = restTemplate.postForObject(postUri, requestBody, Ingredient.class);

        if (postedIngredient != null && postedIngredient.getName() != null) {
            System.out.println("ID: " + postedIngredient.getId());
            System.out.println("Name: " + postedIngredient.getName());
        } else {
            System.out.println("Something error!");
        }
    }

    public static void GetIngredient(){
        final String uri = "http://localhost:8080/api/v1/ingredients";

        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        headers.add("Accept", String.valueOf(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String results = restTemplate.getForObject(uri,String.class);

        ResponseEntity<PagedResources<Ingredient>> pagedResourcesResponseIngredients = restTemplate.exchange(uri, HttpMethod.GET,
                null, new ParameterizedTypeReference<PagedResources<Ingredient>>() {});

        PagedResources<Ingredient> pagedResources = pagedResourcesResponseIngredients.getBody();
        Collection<Ingredient> ingredientsCollection = pagedResources.getContent();

        for(Ingredient i : ingredientsCollection){
            System.out.println(i.getId());
            System.out.println(i.getName());
            System.out.println("");
        }
    }
}
