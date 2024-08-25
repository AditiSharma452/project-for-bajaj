package com.aditiforbajajfinserv.bfhl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getOperationCode() {
        Map<String, Integer> response = new HashMap<>();
        response.put("operation_code", 1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> handlePostRequest(@RequestBody Map<String, List<String>> request) {
        List<String> data = request.get("data");

        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestLowercaseAlphabet = new ArrayList<>();

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]")) {
                    highestLowercaseAlphabet.add(item);
                }
            }
        }

        // Find the highest lowercase alphabet
        String highestAlphabet = highestLowercaseAlphabet.stream()
                .max(Comparator.naturalOrder())
                .orElse("");

        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("user_id", "aditi_sharma_01012000");
        response.put("email", "aditi@example.com");
        response.put("roll_number", "21BCB0141");
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_lowercase_alphabet", Arrays.asList(highestAlphabet));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}