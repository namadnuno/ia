package forklift;

import agent.Heuristic;

public class HeuristicTileDistance extends Heuristic<ForkliftProblem, ForkliftState>{

    public double compute(ForkliftState state){
        //TODO        
        return 0;
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}