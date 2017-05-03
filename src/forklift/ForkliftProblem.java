package forklift;

import agent.Problem;
import agent.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForkliftProblem extends Problem<ForkliftState> {

    private ForkliftState goalState; //desnecessário
    
    public ForkliftProblem(ForkliftState initialState){
        super(initialState, new ArrayList<Action>());
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        
    }
    
    @Override
    public List<ForkliftState> executeActions(ForkliftState state){
        //throw new UnsupportedOperationException("Not supported yet.");
        List<ForkliftState> successors = new LinkedList<ForkliftState>();
        
        for(Action a: actions){
            if (a.isValid(state)){
                ForkliftState successor = (ForkliftState) state.clone();
                successor.executeAction(a);
                successors.add(successor);
            }
        }
        return successors;
    }
    
    @Override
    public boolean isGoal(ForkliftState state){
        return state.getForkliftColumm() == state.getNumColumns()-1;
    }
    
    @Override
    public double computePathCost(List<Action> path){
        return path.size();
    }
}
