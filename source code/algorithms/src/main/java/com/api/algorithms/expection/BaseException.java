package com.api.algorithms.expection;

public class BaseException extends Exception {

    private static final long serialVersionUID = 5478254234123123123L;

    public BaseException() {
        super("Error general");
    }

    public BaseException(String message) {
        super(message);
    }

}
