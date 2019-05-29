package com.vanderkast.etm.lib.cursor;

public class CursorException extends Exception{
    private Type type;

    public CursorException(String message, Type type) {
        super(message);
        this.type = type;
    }

    public Type getType(){
        return  type;
    }

    public enum Type {
        CAN_NOT_MOVE,
        CAN_NOT_READ,
        NO_POINT,
    }
}
