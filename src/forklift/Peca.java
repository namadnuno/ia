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
    private Posicao posicaoInicio;
    private Posicao posicaoFim; //ideia para lista de acções
    private int digito;
    protected List <ActionPeca> actions;
    
    public Peca(Posicao posicaoInicio, Posicao posicaoFim, int digito) {
        this.posicaoInicio = posicaoInicio;
        this.posicaoFim = posicaoFim;
        this.digito = digito;
        actions = new ArrayList<ActionPeca>();
    }

    public int getDigito() {
        return digito;
    }

    public Posicao getPosicaoFim() {
        return posicaoFim;
    }

    public Posicao getPosicaoInicio() {
        return posicaoInicio;
    }

    public void setPosicaoFim(Posicao posicaoFim) {
        this.posicaoFim = posicaoFim;
    }

    public void setPosicaoInicio(Posicao posicaoInicio) {
        this.posicaoInicio = posicaoInicio;
    }

    public int horizontalDistance() {
        return this.posicaoFim.getColuna() - this.posicaoInicio.getColuna();
    }
    
    public int verticalDistance() {
        return this.posicaoFim.getLinha() - this.posicaoInicio.getLinha();
    }
    
    public List<ActionPeca> getActions() {
        return actions;
    }
    
    
    
}
