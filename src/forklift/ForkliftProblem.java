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
        
        for(Peca p: state.getPecas()) {
            for(ActionPeca a: p.getActions()){
                if (a.isValid(state, p)) {
                    ForkliftState successor = (ForkliftState) state.clone();
                    successor.executeAction(a, p);
                    a.setPeca(p);
                    successors.add(successor);
//                    System.out.println(successor);
                }
            }
        }
        
//        Peca forklift = state.getForklift();
//        
//        if(forklift == null) {
//            return null;
//        }
//        
//        boolean flag = true;
//        
//        do {
//            ActionPeca a = new ActionRight();
//            a.setPeca(forklift);
//            if (a.isValid(state, forklift)) {
//                ForkliftState successor = (ForkliftState) state.clone();
//                successor.executeAction(a, forklift);
//                successors.add(successor);
//                //System.out.println(successor.toString());
//            } else {
//                flag = false;
//            }
//        } while(flag == true);
//        
//        for(Peca p: state.getPecas()) {
//            for(ActionPeca a: p.getActions()){
//                if (a.isValid(state, p)) {
//                    ForkliftState successor = (ForkliftState) state.clone();
//                    successor.executeAction(a, p);
//                    a.setPeca(p);
//                    successors.add(successor);
//                }
//            }
//        }
        
        return successors;
    } 
    
    @Override
    public boolean isGoal(ForkliftState state){
        if (state.getForkliftColumm() == state.getNumColumns()-1){
            System.out.println(state);
        }
        return state.getForkliftColumm() == state.getNumColumns()-1;
    }
    
    @Override
    public double computePathCost(List<Action> path){
        return path.size();
    }
}
