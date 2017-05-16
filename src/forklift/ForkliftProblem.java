package forklift;

import agent.Problem;
import agent.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForkliftProblem extends Problem<ForkliftState> {
    
    public ForkliftProblem(ForkliftState initialState){
        super(initialState, new ArrayList<Action>());
    }
    
    @Override
    public List<ForkliftState> executeActions(ForkliftState state){
        //throw new UnsupportedOperationException("Not supported yet.");
        List<ForkliftState> successors = new LinkedList<ForkliftState>();
        
        //percorrer peças
        
        Peca forklift = state.getForklift();
        
        if(forklift == null) {
            return null;
        }
        
        boolean flag = true;
        
        do {
            ActionPeca a = new ActionRight();
            a.setPeca(forklift);
            if (a.isValid(state, forklift)) {
                ForkliftState successor = (ForkliftState) state.clone();
                successor.executeAction(a, forklift);
                successor.setPeca(forklift);
                successors.add(successor);
            } else {
                flag = false;
            }
        } while(flag == true);
        
        for(Peca p: state.getPecas()) {
            for(ActionPeca a: p.getActions()){
                if (a.isValid(state, p)) {
                    ForkliftState successor = (ForkliftState) state.clone();
                    successor.executeAction(a, p);
                    System.out.println(successor.toString());
                    a.setPeca(p);
                    successors.add(successor);
                }
            }
        }
        
        return successors;
    } 
    
    @Override
    public boolean isGoal(ForkliftState state){
        System.out.println("estou:" + state.getForkliftColumm());
        return state.getForkliftColumm() == state.getNumColumns()-1;
    }
    
    @Override
    public double computePathCost(List<Action> path){
        return path.size();
    }
}
