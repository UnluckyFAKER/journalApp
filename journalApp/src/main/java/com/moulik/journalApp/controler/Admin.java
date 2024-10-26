package com.moulik.journalApp.controler;

import com.moulik.journalApp.Appcache.AppCache;
import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.UserRepoImpl;
import com.moulik.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    UserService userService;
    @Autowired
    AppCache appCache;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @GetMapping("/all-users")
    public ResponseEntity<?> getAll() {
        List<User> all = userService.getAll();
        if (all != null & !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/new-admin")
    public ResponseEntity<User> signup(@RequestBody User ggez) {
        try {
            userService.saveentradmin(ggez);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // runtime change occur
    @GetMapping("/clear-cache")
    public void clearCache() {
         appCache.inin();

    }

}
