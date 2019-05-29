package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.lib.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

public class StartAction extends CharAction {
    public StartAction(InternalState state) {
        super(state);
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            if (cursor.getPoint().equals('c')) {
                state.append('c');
            }
            cursor.moveForward();
        } catch (CursorException e) {
            throwActionException(e);
        }
    }

    @Override
    public ActionType type() {
        return ActionType.COMMON;
    }
}
