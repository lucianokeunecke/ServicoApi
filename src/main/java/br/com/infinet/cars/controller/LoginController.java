package br.com.infinet.cars.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
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
    Counter loginSucesso;
    Counter loginErro;
    Timer timer;
    public LoginController(MeterRegistry meterRegistry) {
        loginSucesso = Counter.builder("auth_login_sucesso").register(meterRegistry);
        loginErro = Counter.builder("auth_login_error").register(meterRegistry);
        timer = Timer.builder("database_timer").register(meterRegistry);
    }

    @GetMapping
    public HttpEntity<Integer> login(){
        SplittableRandom random = new SplittableRandom();
        int i = random.nextInt(1000);
        if(i > 750){

            if(i > 850){
                System.out.println("Sleeping");
                timer.record(()-> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            loginErro.increment();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(i);
        }
        loginSucesso.increment();
        return ResponseEntity.ok().body(i);

    }
}
