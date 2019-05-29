package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

public class EqualSignAction extends CharAction {
    public EqualSignAction(InternalState state) {
        super(state);
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            Character point = cursor.getPoint();
            if (point.equals('=')) {
                state.append(point);
                new WhiteSpaceAppendAction((InternalState) state, true).handle(cursor);
            } else {
                state.clear();
            }
        } catch (CursorException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActionType type() {
        return ActionType.COMMON;
    }
}
