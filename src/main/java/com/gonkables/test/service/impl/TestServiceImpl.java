package com.gonkables.test.service.impl;

import com.gonkables.test.exception.ConflictException;
import com.gonkables.test.exception.NotFoundException;
import com.gonkables.test.service.TestService;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String holaMundo(){
        return "Hola mundo";
    }

    @Override
    public String conflictException(){
        throw new ConflictException("Conflict Exception");
    }

    @Override
    public String notFoundException(){
        throw new NotFoundException("Not Found Exception");
    }

    @Override
    public String nullPointerException(){
        throw new NullPointerException("Null Pointer Exception");
    }

    @Override
    public String exception() throws Exception {
        throw new Exception("Exception");
    }
}
