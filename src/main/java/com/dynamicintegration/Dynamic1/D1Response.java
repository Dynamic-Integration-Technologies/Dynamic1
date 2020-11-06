package com.dynamicintegration.Dynamic1;

public class D1Response {
    private String response;
    private Boolean success;

    public D1Response(Boolean success, String response){
        this.response = response;
        this.success = success;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
