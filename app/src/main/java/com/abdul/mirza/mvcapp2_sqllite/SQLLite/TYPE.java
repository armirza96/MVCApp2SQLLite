package com.abdul.mirza.mvcapp2_sqllite.SQLLite;

public enum TYPE {
    CLOSED("closed"),
    CREATED("created"),
    OPENED("opened"),
    DELETED("deleted");

    private final String action;

    public String getAction() {
        return this.action;
    }

    private TYPE(String action) {
        this.action = action;
    }
}
