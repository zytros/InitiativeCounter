package com.inCounter.config;

public class Configuration {

    private int port;
    private  String display;
    private  String userEnd;
    private  String error;
    private  String posResponse;
    private  String noData;

    public String getNoData() {
        return noData;
    }

    public void setNoData(String noData) {
        this.noData = noData;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getUserEnd() {
        return userEnd;
    }

    public void setUserEnd(String userEnd) {
        this.userEnd = userEnd;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPosResponse() {
        return posResponse;
    }

    public void setPosResponse(String posResponse) {
        this.posResponse = posResponse;
    }
}
