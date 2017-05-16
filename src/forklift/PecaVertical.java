/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

/**
 *
 * @author Rúben Gonçalves
 */
public class PecaVertical extends Peca{
    
    public PecaVertical(Posicao posicaoInicio, Posicao posicaoFim, int digito) {
        super(posicaoInicio, posicaoFim, digito);
        actions.add(new ActionUp());
        actions.add(new ActionDown());
    }
    
}
