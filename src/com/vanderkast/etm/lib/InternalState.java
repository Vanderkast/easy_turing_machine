package com.vanderkast.etm.lib;

import java.util.ArrayList;
        import java.util.List;

public class InternalState {
    private List<Character> state = new ArrayList<>();

    public void append(Character ch) {
        state.add(ch);
    }

    public void pop() {
        state.remove(state.size() - 1);
    }

    public void clear() {
        state.clear();
    }

    public List<Character> get() {
        return new ArrayList<>(state);
    }
}
