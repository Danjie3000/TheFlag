package com.example.theflag.Controller;

import com.example.theflag.Model.Flag;
import com.example.theflag.Model.FlagRequest;
import com.example.theflag.Service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private ApiService apiService;

    public HomeController(ApiService apiService){
        this.apiService = apiService;
    }

    @GetMapping("/virkerDen")
    public ResponseEntity<String> virkerDen(){
        return new ResponseEntity<>("Ja, den gør", HttpStatus.OK);
    }

    @PostMapping("/findFlag")
    public ResponseEntity<Flag> findFlag(@RequestBody FlagRequest flagRequest){
        System.out.println("findFlag called");
        flagRequest.setRequest(" P3 " + flagRequest.getRequest());
        Flag flag = apiService.requestFlag(flagRequest);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }
}
