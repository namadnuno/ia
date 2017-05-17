/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forklift;

import java.util.List;

/**
 *
 * @author Rúben Gonçalves
 */
public class PecaVertical extends Peca{
    
    public PecaVertical(int digito, int tamanho, Posicao posicao) {
        super(digito, tamanho, posicao);
        actions.add(new ActionUp());
        actions.add(new ActionDown());
    }
    
}
