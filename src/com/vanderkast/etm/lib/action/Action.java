package com.vanderkast.etm.lib.action;

import com.vanderkast.etm.lib.cursor.Cursor;
import com.vanderkast.etm.lib.InternalState;

public abstract class Action<T> {
    protected InternalState state;

    protected Action(InternalState state){
        this.state = state;
    }

    public abstract void handle(Cursor<T> cursor) throws ActionException;

    public abstract ActionType type();
}
