package com.example.theflag.Controller;

import com.example.theflag.Model.Flag;
import com.example.theflag.Model.FlagRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController { // Mathias.

    @PostMapping("/findFlag")
    public ResponseEntity<Flag> findFlag(@RequestBody FlagRequest flagRequest){
        Flag flag = new Flag();
        System.out.println("received request " + flagRequest.getRequest());
        flag.setMessage("Flag is here! ##### " + flagRequest.getRequest() );
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

}
