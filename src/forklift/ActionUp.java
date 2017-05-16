package forklift;

import agent.Action;

public class ActionUp extends ActionPeca{

    
    public ActionUp(){
        super(1);
    }

    public void execute(ForkliftState state, Peca p){
        state.moveUp(p);
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state, Peca p){
        return state.canMoveUp(p);
    }
    
    @Override
    public String toString() {
        return "ActionUp";
    }    
}