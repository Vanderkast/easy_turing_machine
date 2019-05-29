package com.vanderkast.etm.lib.cursor;

public interface Cursor<T> {
    void moveForward() throws CursorException;

    T getPoint() throws CursorException;
}
