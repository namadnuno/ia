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
    private Posicao posicaoInicial;
    private int digito;
    protected List <ActionPeca> actions;
    private int tamanho;
    
    public Peca(int digito, int tamanho, Posicao posicaoInicial) {
        this.digito = digito;
        this.tamanho = tamanho;
        this.posicaoInicial = posicaoInicial;
        actions = new ArrayList<ActionPeca>();
    }

    public int getDigito() {
        return digito;
    }
    
    public List<ActionPeca> getActions() {
        return actions;
    }

    public  Posicao getPosicaoInicio() {
        return posicaoInicial;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    
}
