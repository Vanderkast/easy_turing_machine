package com.vanderkast.etm.ao_finder;

import com.vanderkast.etm.ao_finder.actions.*;
import com.vanderkast.etm.lib.action.Action;

public class ActionFactory {
    InternalState state;

    public ActionFactory(InternalState state) {
        this.state = state;
    }

    public Action get() {
        if (!state.isStringAdded())
            return new StringAppendAction(state);
        if(!state.isNameAdded())
            return new VarNameAction(state);
        if(!state.isEqualSignAdded())
            return new EqualSignAction(state);
        if(!state.isConstantAdded())
    }
}
// String name = "hello" ;