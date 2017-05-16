/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

import agent.Heuristic;

/**
 *
 * @author Rúben Gonçalves
 */
public class HeuristicObjectsBetweenDoor extends Heuristic<ForkliftProblem, ForkliftState>{

    @Override
    public double compute(ForkliftState state) {
        return state.computeObjectsBetweenDoor();
    }

    @Override
    public String toString() {
        return "Number of objects between door";
    }
    
    
    
}
