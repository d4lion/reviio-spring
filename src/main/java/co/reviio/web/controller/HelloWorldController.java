package co.reviio.web.controller;

import co.reviio.domain.service.ReviioAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private final ReviioAiService reviioAiService;

    public HelloWorldController(ReviioAiService reviioAiService) {
        this.reviioAiService = reviioAiService;
    }


    @GetMapping("/hello")
    public String helloWorld() {
        return this.reviioAiService.generateGreeting();
    }
}
