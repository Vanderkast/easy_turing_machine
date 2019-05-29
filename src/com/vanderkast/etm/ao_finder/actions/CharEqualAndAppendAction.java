package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

public class CharEqualAndAppendAction extends CharAction {
    Character point;

    public CharEqualAndAppendAction(InternalState state, Character point) {
        super(state);
        this.point = point;
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            if(cursor.getPoint().equals(point)){
                state.append(point);
            } else
                state.clear();
            cursor.moveForward();
        } catch (CursorException e) {
            throwActionException(e);
        }
    }

    @Override
    public ActionType type() {
        return null;
    }
}
