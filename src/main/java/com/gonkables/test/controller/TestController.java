package com.gonkables.test.controller;

import com.gonkables.test.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hola")
    public ResponseEntity<?> holaMundo(){
        return new ResponseEntity<>(testService.holaMundo(), HttpStatus.OK);
    }

    @GetMapping("/conflict")
    public ResponseEntity<?> conflictException(){
        return new ResponseEntity<>(testService.conflictException(), HttpStatus.OK);
    }

    @GetMapping("/notfound")
    public ResponseEntity<?> notFoundException(){
        return new ResponseEntity<>(testService.notFoundException(), HttpStatus.OK);
    }

    @GetMapping("/nullpointer")
    public ResponseEntity<?> nullPointer(){
        return new ResponseEntity<>(testService.nullPointerException(), HttpStatus.OK);
    }

    @GetMapping("/exception")
    public ResponseEntity<?> exception() throws Exception {
        return new ResponseEntity<>(testService.exception(), HttpStatus.OK);
    }

}
