package com.vanderkast.etm.ao_finder;

import com.vanderkast.etm.ao_finder.actions.CharEqualAndAppendAction;
import com.vanderkast.etm.ao_finder.actions.StartAction;
import com.vanderkast.etm.lib.action.Action;

public class ActionFactory extends com.vanderkast.etm.lib.action.ActionFactory {
    @Override
    public Action get() {
        if(state.get().isEmpty())
            return new StartAction(state);
        if(lastOfState().equals('c'))
            return new CharEqualAndAppendAction(state,'h');
        if(lastOfState().equals('h'))
            return new CharEqualAndAppendAction(state,'a');
        if(lastOfState().equals('a'))
            return new CharEqualAndAppendAction(state,'r');
        if(lastOfState().equals('a'))
            return new CharEqualAndAppendAction(state,'r');
        return null;
    }

    Character lastOfState(){
        return state.get().get(state.get().size());
    }
}
