package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

public class StringAppendAction extends CharAction {
    public StringAppendAction(InternalState state) {
        super(state);
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            boolean stillOk = true;

            for (char validator : ("String".toCharArray())) {
                Character point = cursor.getPoint();
                stillOk = point.equals(validator);
                cursor.moveForward();

                if(stillOk){
                    state.append(point);
                } else {
                    state.clear();
                    return;
                }
            }

            if(stillOk)
                ((InternalState) state).setNameAdded(true);

             new WhiteSpaceAppendAction(((InternalState) state), true).handle(cursor);
        } catch (CursorException e) {
            throwActionException(e);
        }
    }

    @Override
    public ActionType type() {
        return ActionType.COMMON;
    }
}
