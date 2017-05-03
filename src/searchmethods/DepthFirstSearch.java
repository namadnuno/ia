package searchmethods;

import agent.Problem;
import agent.Solution;
import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class DepthFirstSearch extends GraphSearch<NodeLinkedList> {

    public DepthFirstSearch() {
        frontier = new NodeLinkedList();
    }

    //Graph Search without explored list
    @Override
    protected Solution graphSearch(Problem problem) {
        frontier.clear();
        
        frontier.add(new Node (problem.getInitialState()));
        while (!frontier.isEmpty() && !stopped){
            Node n = frontier.poll();
            if(problem.isGoal(n.getState())){
                return new Solution(problem, n);
            }
           
            List<State> successors = problem.executeActions(n.getState());
            addSuccessorsToFrontier(successors, n);
            computeStatistics(successors.size());
        }       
        return null;
    }

    
    //pela direita
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        //TODO
        
        for (State s: successors){
            if(!frontier.containsState(s)){
                Node node = new Node(s,parent);
                if (!node.isCycle()){ 
                    frontier.addFirst(node);
                }
            }
        }
            
    }
    
    /*
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        //pela esquerda
        
        for (int i = successors.size() -1 ; i >= 0; i--){
            State s = successors.get(i);
            if(!frontier.containsState(s)){
                Node node = new Node(s,parent);
                if (!node.isCycle()){ 
                    frontier.addFirst(node);
                }
            }
        }
            
    }*/

    @Override
    public String toString() {
        return "Depth first search";
    }
}
