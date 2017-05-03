package forklift;

import agent.Action;

public class ActionDown extends Action<ForkliftState>{

    public ActionDown(){
        super(1);
    }

    public void execute(ForkliftState state){
        state.moveDown();
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state){
        return state.canMoveDown();
    }
}