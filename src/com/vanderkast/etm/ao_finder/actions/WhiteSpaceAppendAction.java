package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

public class WhiteSpaceAppendAction extends CharAction {
    boolean withEndOfLine;

    protected WhiteSpaceAppendAction(InternalState state) {
        super(state);
        withEndOfLine = false;
    }

    public WhiteSpaceAppendAction(InternalState state, boolean withEndOfLine) {
        super(state);
        this.withEndOfLine = withEndOfLine;
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            while (isPointWhitespace(cursor.getPoint()))
                cursor.moveForward();
        } catch (CursorException e) {
            throwActionException(e);
        }
    }

    private boolean isPointWhitespace(Character point) {
        return pattern().contains(point.toString());
    }

    private String pattern() {
        if (withEndOfLine)
            return " \t\n";
        else
            return " \t";
    }

    @Override
    public ActionType type() {
        return null;
    }
}
