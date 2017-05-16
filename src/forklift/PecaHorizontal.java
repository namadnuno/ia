/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

import agent.Action;
import java.util.List;

/**
 *
 * @author Rúben Gonçalves
 */
public class PecaHorizontal extends Peca {
    
    public PecaHorizontal(Posicao posicaoInicio, Posicao posicaoFim, int digito) {
        super(posicaoInicio, posicaoFim, digito);
        actions.add(new ActionRight());
        actions.add(new ActionLeft());
    }
    
}
