/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

import agent.Action;

/**
 *
 * @author Nuno Alexandre
 */
public abstract class ActionPeca extends Action<ForkliftState> {
    
    Peca peca;

    public ActionPeca(int cost) {
        super(cost);
    }

    public Peca getPeca() {
        return this.peca; 
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
