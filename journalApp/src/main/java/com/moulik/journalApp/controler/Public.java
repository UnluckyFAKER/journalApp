package com.moulik.journalApp.controler;

import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.UserRepoImpl;
import com.moulik.journalApp.service.EmailService;
import com.moulik.journalApp.service.UserDetailsServiceImpl;
import com.moulik.journalApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Slf4j
public class Public {
    @Autowired
    EmailService emailService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepoImpl ur;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User ggez) {
        try {
            userService.saveentryUser(ggez);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    @GetMapping("/test")
    public void test() {

        emailService.sendMail("doratv2252@gmail.com","Self","Hi KAmon aches ");
        }
    }




