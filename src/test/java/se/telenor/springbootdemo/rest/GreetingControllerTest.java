package se.telenor.springbootdemo.rest;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingControllerTest {
    private static final String URL = "http://localhost:5000/greeting";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void shouldReturnHiUserId1234() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("id", 1234)
                .queryParam("account", "business");
        String response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class).getBody();

        assertNotNull(response);
        assertEquals("Hi, userId 1234", response);
    }

    @Test
    public void shouldReturnWelcome() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("type", "big")
                .queryParam("account", "business");
        String response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class).getBody();

        assertNotNull(response);
        assertEquals("Welcome, business user!", response);
    }

    @Test
    public void shouldHandelNullParameter() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL);
        String response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class).getBody();

        assertNotNull(response);

    }
}
