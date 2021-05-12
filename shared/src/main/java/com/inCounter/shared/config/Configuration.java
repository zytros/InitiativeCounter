package com.inCounter.shared.config;

public class Configuration {

    private int port;
    private  String display;
    private  String userEnd;
    private  String error;
    private  String posResponse;
    private  String noData;
    private String host;
    private String serverShutdown;
    private String password;
    private String getId;
    private String newSession;
    private String setName;
    private String setInitiative;
    private String changeHP;

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetInitiative() {
        return setInitiative;
    }

    public void setSetInitiative(String setInitiative) {
        this.setInitiative = setInitiative;
    }

    public String getChangeHP() {
        return changeHP;
    }

    public void setChangeHP(String changeHP) {
        this.changeHP = changeHP;
    }

    public String getNewSession() {
        return newSession;
    }

    public void setNewSession(String newSession) {
        this.newSession = newSession;
    }

    public String getGetId() {
        return getId;
    }

    public void setGetId(String getId) {
        this.getId = getId;
    }

    public String getServerShutdown() {
        return serverShutdown;
    }

    public void setServerShutdown(String serverShutdown) {
        this.serverShutdown = serverShutdown;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

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
