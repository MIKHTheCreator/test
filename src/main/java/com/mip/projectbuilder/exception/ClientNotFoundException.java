package com.mip.projectbuilder.exception;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {

    private final UUID id;
    private static final String ERROR_CODE = "404001";

    public ClientNotFoundException(UUID id) {
        this.id = id;
    }

    public static String getErrorCode() {
        return ERROR_CODE;
    }

    public UUID getId() {
        return id;
    }
}
