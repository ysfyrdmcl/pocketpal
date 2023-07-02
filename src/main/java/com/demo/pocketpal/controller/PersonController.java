package com.demo.pocketpal.controller;
import com.demo.pocketpal.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Person")
public class PersonController {
    private final PersonService personService;


}
