package forklift;

import agent.Action;

public class ActionRight extends Action<ForkliftState>{

    public ActionRight(){
        super(1);
    }

    public void execute(ForkliftState state){
        state.moveRight();
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state){
        return state.canMoveRight();
    }
}