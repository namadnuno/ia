package forklift;

import agent.Action;

public class ActionLeft extends Action<ForkliftState>{

    public ActionLeft(){
        super(1);
    }

    public void execute(ForkliftState state){
        state.moveLeft();
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state){
        return state.canMoveLeft();
    }
}
