package forklift;

import agent.Action;

public class ActionRight extends ActionPeca{
    
    
    public ActionRight(){
        super(1);
    }

    public void execute(ForkliftState state, Peca p){
        state.moveRight(p);
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state, Peca p){
        return state.canMoveRight(p);
    }
    
    @Override
    public String toString() {
        return "ActionRight";
    }
}