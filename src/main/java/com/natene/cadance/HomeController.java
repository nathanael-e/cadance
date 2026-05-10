package com.natene.cadance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    @GetMapping("/")
    ResponseEntity<String> home() {
        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body("<!DOCTYPE html><html><body><p>Hello World</p></body></html>");
    }
}
