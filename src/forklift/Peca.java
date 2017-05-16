/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

import agent.Action;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rúben Gonçalves
 */
public abstract class Peca {
    private List <Posicao> posicoes;
    private int digito;
    protected List <ActionPeca> actions;
    
    public Peca(Posicao posicaoInicio, Posicao posicaoFim, int digito) {
        posicoes = new ArrayList<Posicao>();
        this.digito = digito;
        actions = new ArrayList<ActionPeca>();
    }

    public int getDigito() {
        return digito;
    }

    public List<Posicao> getPosicoes() {
        return posicoes;
    }
    
    public List<ActionPeca> getActions() {
        return actions;
    }
    
    
    
}
