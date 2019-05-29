package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

import java.util.regex.Pattern;

public class RegexMatchingAppendAction extends CharAction {
    String pattern;

    public RegexMatchingAppendAction(InternalState state, String regex) {
        super(state);
        pattern = Pattern.compile(regex).toString();
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            handlePointer(cursor.getPoint());
        } catch (CursorException e) {
            throwActionException(e);
        }
    }

    private void handlePointer(Character point) {
        if (pattern.contains(point.toString())) {
            state.append(point);
        } else {
            state.clear();
        }
    }

    @Override
    public ActionType type() {
        return ActionType.COMMON;
    }
}
