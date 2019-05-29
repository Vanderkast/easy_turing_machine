package com.vanderkast.etm.ao_finder;

public class InternalState extends com.vanderkast.etm.lib.InternalState {
    private boolean stringAdded;
    private boolean nameAdded;
    private boolean equalSignAdded;
    private boolean constantAdded;
    private boolean semicolonAdded;

    @Override
    public void clear() {
        super.clear();
        resetFlags();
    }

    private void resetFlags(){
        stringAdded = false;
        nameAdded = false;
        equalSignAdded = false;
        constantAdded = false;
        semicolonAdded = false;
    }

    public boolean isStringAdded() {
        return stringAdded;
    }

    public void setStringAdded(boolean stringAdded) {
        this.stringAdded = stringAdded;
    }

    public boolean isNameAdded() {
        return nameAdded;
    }

    public void setNameAdded(boolean nameAdded) {
        this.nameAdded = nameAdded;
    }

    public boolean isEqualSignAdded() {
        return equalSignAdded;
    }

    public void setEqualSignAdded(boolean equalSignAdded) {
        this.equalSignAdded = equalSignAdded;
    }

    public boolean isConstantAdded() {
        return constantAdded;
    }

    public void setConstantAdded(boolean constantAdded) {
        this.constantAdded = constantAdded;
    }

    public boolean isSemicolonAdded() {
        return semicolonAdded;
    }

    public void setSemicolonAdded(boolean semicolonAdded) {
        this.semicolonAdded = semicolonAdded;
    }
}
