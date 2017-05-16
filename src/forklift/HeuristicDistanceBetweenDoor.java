package forklift;

import agent.Heuristic;

public class HeuristicDistanceBetweenDoor extends Heuristic<ForkliftProblem, ForkliftState>{
    
    @Override
    public double compute(ForkliftState state){
        //DONE       
        return state.computeDistanceBetweenDoor();
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}