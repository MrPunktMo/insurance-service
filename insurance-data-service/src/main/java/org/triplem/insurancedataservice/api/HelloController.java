package org.triplem.insurancedataservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/public")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("I'm reachable!");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> getAdminContent() {
        System.out.println("hello, it's me...");
        return ResponseEntity.ok("Only for admins");
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUserContent() {
        return ResponseEntity.ok("Everybody can get this if authenticated");
    }

}
