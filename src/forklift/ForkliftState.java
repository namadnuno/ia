package forklift;

import agent.Action;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;

public class ForkliftState extends State implements Cloneable {

    
    public static final int SIZE = 6;
    private int[][] matrix;
    private int forkliftRow;  //linhacarrinho
    private int forkliftColumm; //colunacarrinho

    public ForkliftState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 1) {
                    forkliftRow = i;
                    forkliftColumm = j;
                }
            }
        }
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        firePuzzleChanged(null);
    }
//
    public boolean canMoveUp() {
        return false;
    }

    public boolean canMoveRight() {
        return (forkliftColumm != matrix.length - 1) && (matrix[forkliftRow + 1][forkliftColumm] != 0);
    }

    public boolean canMoveDown() {
        return false;
    }

    public boolean canMoveLeft() {
        return forkliftColumm != 0 && (matrix[forkliftRow - 1][forkliftColumm] != 0);
    } 

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp() {
        matrix[forkliftRow][forkliftColumm] = matrix[--forkliftRow][forkliftColumm];
        matrix[forkliftRow][forkliftColumm] = 1;
    }

    public void moveRight() {
        matrix[forkliftRow][forkliftColumm] = matrix[forkliftRow][++forkliftColumm];
        matrix[forkliftRow][forkliftColumm] = 1;
    }

    public void moveDown() {
        matrix[forkliftRow][forkliftColumm] = matrix[++forkliftRow][forkliftColumm];
        matrix[forkliftRow][forkliftColumm] = 1;
    }

    public void moveLeft() {
        matrix[forkliftRow][forkliftColumm] = matrix[forkliftRow][--forkliftColumm];
        matrix[forkliftRow][forkliftColumm] = 1;
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
      return forkliftColumm;
    }
}
