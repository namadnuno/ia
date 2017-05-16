package forklift;

import agent.Action;

public class ActionDown extends ActionPeca {
    
    public ActionDown(){
        super(1);
    }

    public void execute(ForkliftState state, Peca p){
        state.moveDown(p);
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state, Peca p){
        return state.canMoveDown(p);
    }

    @Override
    public String toString() {
        return "ActionDown";
    }

}