//package com.moulik.journalApp.service;
//
//import com.moulik.journalApp.apiresponse.WeatherApi;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Component
//public class WebclientExternalApi {
//        private static final String apikey = "91dc01c82ca67818cb38d47a717f0e0f";
//        private static final String API ="http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
//
//    private  WebClient webClient;
//
//    // Correct constructor declaration
//    public void  ExternalApiService(WebClient.Builder webClientBuilder) {
//        // Initialize the WebClient instance using the builder
//        this.webClient = webClientBuilder.build();
//
//    }
//
//
//
//    // For GET request using WebClient
//        public Mono<WeatherApi> getWeather2(String city) {
//            // Construct the final API URL
//            String finalapi = API.replace("API_KEY", apikey).replace("CITY", city);
//
//            // Send a GET request and return the response body
//            return webClient.get()
//                    .uri(finalapi)
//                    .retrieve()
//                    .bodyToMono(WeatherApi.class);
//        }
//
//        // For POST request (even though the API doesn't support it, here's how you'd do it)
//        public Mono<WeatherApi> postWeather(String city) {
//            // Construct the final API URL
//            String finalapi = API.replace("API_KEY", apikey).replace("CITY", city);
//
//            // Define the body to be sent in the POST request
//            String reqbody = "{\n" +
//                    "\"username\":\"Hatu\",\n" +
//                    "\"password\":\"Hatu\"\n" +
//                    "}";
//
//            // Send a POST request with the body and return the response
//            return webClient.post()
//                    .uri(finalapi)
//                    .bodyValue(reqbody) // Injecting the request body
//                    .retrieve()
//                    .bodyToMono(WeatherApi.class);
//        }
//    }
