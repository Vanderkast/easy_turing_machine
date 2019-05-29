package com.vanderkast.etm.ao_finder.actions;

import com.vanderkast.etm.ao_finder.CharAction;
import com.vanderkast.etm.ao_finder.InternalState;
import com.vanderkast.etm.lib.action.ActionException;
import com.vanderkast.etm.lib.action.ActionType;
import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.cursor.CursorException;

import java.util.regex.Pattern;

public class VarNameAction extends CharAction {
    private boolean varNameStartCorrect;

    public VarNameAction(InternalState state) {
        super(state);
    }

    @Override
    public void handle(Cursor<Character> cursor) throws ActionException {
        try {
            handlePointAsVarNameStart(cursor.getPoint());
            handleCursorToFillVarName(cursor);
            new WhiteSpaceAppendAction((InternalState) state, true).handle(cursor);
        } catch (CursorException e) {
            e.printStackTrace();
        }
    }

    private void handlePointAsVarNameStart(Character point) {
        varNameStartCorrect = Pattern.compile("[a-zA-Z$_]").toString().contains(point.toString());
        if (varNameStartCorrect) {
            state.append(point);
        } else {
            state.clear();
        }
    }

    private void handleCursorToFillVarName(Cursor<Character> cursor) throws CursorException {
        Character point = cursor.getPoint();
        while (Pattern.compile("[a-zA-Z0-9$_]").toString().contains(point.toString())) {
            state.append(point);
            cursor.moveForward();
        }
    }

    @Override
    public ActionType type() {
        return null;
    }
}
