package com.gonkables.test.service;

public interface TestService {

    String holaMundo();

    String conflictException();

    String notFoundException();

    String nullPointerException();

    String exception() throws Exception;
}
