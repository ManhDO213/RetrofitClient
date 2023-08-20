package com.example.client_mob403;

import androidx.annotation.NonNull;

public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" +
                "success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data.toString() + '\'' +
                '}';
    }
}
