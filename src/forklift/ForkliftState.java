package forklift;

import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ForkliftState extends State implements Cloneable {

    
    public static final int SIZE = 6;
    private int[][] matrix;
    
    public int forkliftRow;
    public int forkliftColumm;
    
    private LinkedList<Peca> pecas;
    
    public ForkliftState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];

        /*for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 1) {
                    forkliftRow = i;
                    forkliftColumm = j;
                }
            }
        }*/
        
        LinkedList<Posicao> posicoesExploradas = new LinkedList();
        pecas = new LinkedList();
        int digito;
       
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                
                this.matrix[i][j] = matrix[i][j];
                
                boolean explorado = false;
                
                for(Posicao p :posicoesExploradas) {
                    if(p.getLinha() == i && p.getColuna() == j) {
                        explorado = true;
                        break;
                    }
                }
                
                digito = this.matrix[i][j];

                if (explorado) 
                    continue;
                
                LinkedList<Posicao> posicoes = new LinkedList<Posicao>();
                
                int tamanho = 0;
                switch(digito) {
                    
                    case 1:
                    case 2: 
                    case 3:
                        tamanho = 1;
                        break;
                    case 4:
                    case 5:
                        tamanho = 2;
                        break;
                    case 6: 
                    case 7:
                        tamanho = 3;
                        break;
                    case 8: 
                    case 9: 
                        tamanho = 4;
                        break;
                    default:
                        break;
                
                }
                
                
                if(digito != 0 && digito != 10) {
                    for (int k = 0; k < tamanho; k++) {
                        if (digito % 2 == 0 || digito == 1) {
                            posicoesExploradas.add(new Posicao(i, j + k));
                           
                        } else {
                            posicoesExploradas.add(new Posicao(i + k, j));
                          
                        }
                    }
                    //System.out.println("digito: " + digito);
                    //System.out.println("Tamanho das posicoes: " + posicoes.size());
                    if(digito % 2 == 0  || digito == 1) {
                        pecas.add(new PecaHorizontal(digito, new Posicao(i, j)));    //se for par ou 1 adicionar peça horizontal
                       // System.out.println("hor");
                    }else {
                        pecas.add(new PecaVertical(digito, new Posicao(i, j)));      // caso seja impar e diferente de 1 adiiona peça vertical
                       // System.out.println("ver");
                    }
                    
                }
            }
        }
       
    }

    @Override
    public void executeAction(Action action, Peca p) {
        action.execute(this, p);
        firePuzzleChanged(null);
    }

    public boolean canMoveUp(Peca p) {
        if(p.getPosicaoInicio().getLinha() != 0) {
            if(matrix[p.getPosicaoInicio().getLinha() - 1][p.getPosicaoInicio().getColuna()] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveRight(Peca p) {
        if ((p.getPosicaoFim().getColuna()) != matrix.length - 1) {
            if (matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoFim().getColuna() + 1] == 10 && p.getDigito() == 1) {
                return true;
            }
            if (matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoFim().getColuna() + 1] == 0) {
                return true;
            }
            
        }
        return  false;
    }

    public boolean canMoveDown(Peca p) {
        if ((p.getPosicaoFim().getLinha()) != matrix.length -1) {
            if (matrix[p.getPosicaoFim().getLinha() + 1][p.getPosicaoInicio().getColuna()] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canMoveLeft(Peca p) {
        if (p.getPosicaoInicio().getColuna() != 0) {
            if (matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoInicio().getColuna() - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp(Peca p) {
        matrix[p.getPosicaoInicio().getLinha() - 1][p.getPosicaoInicio().getColuna()] = p.getDigito();
        matrix[p.getPosicaoFim().getLinha()][p.getPosicaoFim().getColuna()] = 0;
        
        p.getPosicaoInicio().setLinha(p.getPosicaoInicio().getLinha() - 1);
    }

    
    public void moveRight(Peca p) {
        matrix[p.getPosicaoFim().getLinha()][p.getPosicaoFim().getColuna() + 1] = p.getDigito();
        matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoInicio().getColuna()] = 0;
        
        p.getPosicaoInicio().setColuna(p.getPosicaoInicio().getColuna() + 1);
    }

    public void moveDown(Peca p) {
        matrix[p.getPosicaoFim().getLinha() + 1][p.getPosicaoFim().getColuna()] = p.getDigito();
        matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoInicio().getColuna()] = 0;
        
        p.getPosicaoInicio().setLinha(p.getPosicaoInicio().getLinha() + 1);
    }

    public void moveLeft(Peca p) {
        matrix[p.getPosicaoInicio().getLinha()][p.getPosicaoInicio().getColuna() - 1] = p.getDigito();
        matrix[p.getPosicaoFim().getLinha()][p.getPosicaoFim().getColuna()] = 0;
        
        p.getPosicaoInicio().setColuna(p.getPosicaoInicio().getColuna() - 1);
    }

    public int getNumLines() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }

    public int getTileValue(int line, int column) {
        if (!isValidPosition(line, column)) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        return matrix[line][column];
    }

    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < matrix.length && column >= 0 && column < matrix[0].length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ForkliftState)) {
            return false;
        }

        ForkliftState o = (ForkliftState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public Object clone() {
        return new ForkliftState(matrix);
    }
    //Listeners
    private transient ArrayList<ForkliftListener> listeners = new ArrayList<ForkliftListener>(3);

    public synchronized void removeListener(ForkliftListener l) {
        if (listeners != null && listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public synchronized void addListener(ForkliftListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void firePuzzleChanged(ForkliftEvent pe) {
        for (ForkliftListener listener : listeners) {
            listener.puzzleChanged(null);
        }
    }

    public int getForkliftColumm() {
      return getForklift().getPosicaoInicio().getColuna();
    }

    public int computeObjectsBetweenDoor() {
        // percorrer linha carrinho se tile entre 2 e 9 (caixas) então incrementa h
      return  1;
    }

    public int computeDistanceBetweenDoor() {
        return (matrix.length-1)-getForklift().getPosicaoInicio().getColuna();
    }

    public Iterable<Peca> getPecas() {
        return pecas;
    }

    public Peca getForklift() {
        for(Peca p: pecas) {
            if (p.getDigito() == 1)
                return p;
        }
        return null;
    }
}
