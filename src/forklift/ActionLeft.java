package forklift;

import agent.Action;

public class ActionLeft extends ActionPeca{
    
    public ActionLeft(){
        super(1);
    }

    public void execute(ForkliftState state, Peca p){
        state.moveLeft(p);
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state, Peca p){
        return state.canMoveLeft(p);
    }
    
    @Override
    public String toString() {
        return "ActionLeft";
    }
    
}
