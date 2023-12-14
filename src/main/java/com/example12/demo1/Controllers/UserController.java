package com.example12.demo1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class UserController {
    @GetMapping("/checkTime")
    public String checkTime() {
        LocalTime currentTime = LocalTime.now();
        LocalTime midday = LocalTime.NOON;
        LocalTime midnight = LocalTime.MIDNIGHT;

        if (currentTime.equals(midday)) {
            return "It's Midday";
        } else if (currentTime.equals(midnight)) {
            return "It's Midnight";
        } else {
            return "It's neither Midday nor Midnight";
        }
    }
}
