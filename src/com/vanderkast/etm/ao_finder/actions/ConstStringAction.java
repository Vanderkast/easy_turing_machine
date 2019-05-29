package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;

public class ConstStringAction extends CharAction {
    protected ConstStringAction(InternalState state) {
        super(state);
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {

    }

    @Override
    public ActionType type() {
        return null;
    }
}
