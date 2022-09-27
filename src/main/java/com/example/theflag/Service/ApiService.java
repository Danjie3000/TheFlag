package com.example.theflag.Service;

import com.example.theflag.Model.Flag;
import com.example.theflag.Model.FlagRequest;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    final String API = "https://gruppecicd.azurewebsites.net/findFlag"; // find ud af, hvilket IP + port
    RestTemplate restTemplate = new RestTemplate();
    public Flag requestFlag(FlagRequest req) {
        System.out.println("sending request...");
        JsonNode jsonNode = restTemplate.postForObject(API, req, JsonNode.class);
        System.out.println("received ansver " + jsonNode.get("message"));
        Flag flag = new Flag();
        flag.setMessage(jsonNode.get("message").toString());
        return flag;
    }
}
