package com.pizzashop.restclient;

import com.pizzashop.restclient.models.Ingredient;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RestclientApplication {

    public static void main(String[] args) {
        final String uri = "http://localhost:8080/api/v1/ingredients/1";
        /*
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.

        Ingredient[] list = restTemplate.getForObject(uri, Ingredient[].class);

        if (list != null) {
            for (Ingredient e : list) {
                System.out.println("Ingredient: " + e.getName() + " - " + e.getId());
            }
        }
        */

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<Ingredient> response = restTemplate.exchange(uri, //
                HttpMethod.GET, entity, Ingredient.class);

        Ingredient result = response.getBody();

        System.out.println(result.getName());

    }
}
