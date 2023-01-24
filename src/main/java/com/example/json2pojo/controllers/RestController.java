package com.example.json2pojo.controllers;

import com.example.json2pojo.beans.A;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestController {

    @GetMapping(path = "/test")
    public void getJson() {

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url, String.class);

        Gson gson = new Gson();
        A a = gson.fromJson(response, A.class);

        System.out.println("USER ID : "+a.getUserId());

    }
}
