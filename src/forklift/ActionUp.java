package forklift;

import agent.Action;

public class ActionUp extends Action<ForkliftState>{

    public ActionUp(){
        super(1);
    }

    
    public void execute(ForkliftState state){
        state.moveUp();
        state.setAction(this);
    }

    public boolean isValid(ForkliftState state){
        return state.canMoveUp();
    }
}