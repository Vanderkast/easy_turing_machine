package com.vanderkast.etm.lib.action;

import com.vanderkast.etm.lib.InternalState;

public abstract class ActionFactory {
    protected InternalState state;

    ActionFactory set(InternalState state){
        this.state = state;
        return this;
    }

    public abstract Action get();
}
