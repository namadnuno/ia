package agent;

import forklift.Peca;


public abstract class Action <S extends State>{
    
    private double cost;
    
    public Action(double cost){
        this.cost = cost;
    }

    public abstract void execute(S State, Peca p);

    public abstract boolean isValid(S State, Peca p);

    public double getCost(){
        return cost;
    }
}