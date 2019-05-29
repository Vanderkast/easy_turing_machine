package com.vanderkast.etm.lib.action;

public class ActionException extends Exception {
    private Type type;

    public ActionException(String message, Type type) {
        super(message);
        this.type = type;
    }

    public enum Type {
        END_OF_INPUT,
    }

    Type getType() {
        return type;
    }
}
