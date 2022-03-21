package br.com.infinet.cars.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.SplittableRandom;

@RestController
@RequestMapping("/auth")
public class LoginController {


    @GetMapping
    public HttpEntity<Integer> login(){
        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 750){

            if(i > 850){
                System.out.println("Sleeping");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(i);
        }

        return ResponseEntity.ok().body(i);

    }
}
