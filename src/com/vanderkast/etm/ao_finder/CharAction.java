package com.vanderkast.etm.ao_finder;

import com.vanderkast.etm.lib.action.Action;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.cursor.CursorException;

public abstract class CharAction extends Action<Character> {
    protected CharAction(InternalState state) {
        super(state);
    }

    protected void throwActionException(CursorException e) throws ActionException {
        String error;
        switch (e.getType()) {
            case CAN_NOT_MOVE:
                error = "Cursor can not move";
                break;
            case CAN_NOT_READ:
                error = "Cursor can not read point";
                break;
            case NO_POINT:
                error = "Cursor has no point";
                break;
            default:
                error = "Unexpected exception\n" + e.getMessage();
        }
        throw new ActionException(error, ActionException.Type.END_OF_INPUT);
    }
}
