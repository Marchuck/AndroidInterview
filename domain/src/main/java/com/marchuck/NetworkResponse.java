package com.marchuck;

public class NetworkResponse {

    private final String response;

    public NetworkResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public boolean isSuccessful(){
        return response!=null;
    }

    @Override public String toString() {
        return "NetworkResponse{" +
                "response='" + response + '\'' +
                '}';
    }
}
