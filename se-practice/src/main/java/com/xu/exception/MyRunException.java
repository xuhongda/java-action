package com.xu.exception;

/**
 * @author xuhongda on 2020/11/27
 * com.xu.exception
 * java-action
 */
public class MyRunException extends RuntimeException {




    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MyRunException(String message) {
        super(message);
    }


}
