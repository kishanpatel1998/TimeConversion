package com.example12.demo1.Controllers;


import com.example12.demo1.Exceptions.TimeConversionException;
import com.example12.demo1.Service.TimeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeConversionController {
    @Autowired
    private TimeConversionService timeConversionService;
    @GetMapping("/convertTime")
    public ResponseEntity<String> convertTime(@RequestParam String time) {
        try {
            String result = timeConversionService.convertToWords(time);
            return ResponseEntity.ok(result);
        } catch (TimeConversionException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
