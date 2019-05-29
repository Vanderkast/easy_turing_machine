package com.vanderkast.etm.ao_finder;

import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

import java.io.DataInputStream;
import java.io.IOException;

public class CharStreamCursor implements Cursor<Character> {
    private final String END_OF_INPUT_STREAM = "End of data input stream found";
    private final String NULL_POINT = "Point is null";

    private DataInputStream is;

    private Character nextPoint;
    private Character point;

    CharStreamCursor(DataInputStream is){
        this.is = is;
    }

    @Override
    public void moveForward() throws CursorException {
        checkStreamAvailable();
        updatePointer();
        readNextPoint();
    }

    private void checkStreamAvailable() throws CursorException {
        try {
            isStreamAvailable();
        } catch (IOException e) {
            throw new CursorException(e.getMessage(), CursorException.Type.CAN_NOT_READ);
        }
    }

    private void isStreamAvailable() throws CursorException, IOException {
        if(is.available() == 0)
            throw new CursorException(END_OF_INPUT_STREAM, CursorException.Type.CAN_NOT_MOVE);
    }

    private void updatePointer() {
        point = nextPoint;
    }

    private void readNextPoint() throws CursorException {
        try {
            nextPoint = is.readChar();
        } catch (IOException e) {
            throw new CursorException(e.getMessage(), CursorException.Type.CAN_NOT_READ);
        }
    }

    @Override
    public Character getPoint() throws CursorException {
        checkPoint();
        return this.point;
    }

    private void checkPoint() throws CursorException {
        if (this.point == null)
            throw new CursorException(NULL_POINT, CursorException.Type.NO_POINT);
    }
}
