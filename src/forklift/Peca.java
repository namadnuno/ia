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
    protected Posicao posicaoInicial;
    private int digito;
    protected List <ActionPeca> actions;
    protected int tamanho;
    
    public Peca(int digito, Posicao posicaoInicial) {
        this.digito = digito;
        this.posicaoInicial = posicaoInicial;
        actions = new ArrayList<ActionPeca>();
        
        switch(digito) {

            case 1:
            case 2: 
            case 3:
                this.tamanho = 1;
                break;
            case 4:
            case 5:
                this.tamanho = 2;
                break;
            case 6: 
            case 7:
                this.tamanho = 3;
                break;
            case 8: 
            case 9: 
                this.tamanho = 4;
                break;
            default:
                break;

        }
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
    public abstract Posicao getPosicaoFim();

    public int getTamanho() {
        return tamanho;
    }
    
    
}
