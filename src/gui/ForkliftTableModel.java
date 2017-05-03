package gui;

import forklift.ForkliftEvent;
import forklift.ForkliftState;
import javax.swing.table.AbstractTableModel;
import forklift.ForkliftListener;

public class ForkliftTableModel extends AbstractTableModel implements ForkliftListener{

    private ForkliftState puzzle;

    public ForkliftTableModel(ForkliftState puzzle) {
        if(puzzle == null){
            throw new NullPointerException("Puzzle cannot be null");
        }
        this.puzzle = puzzle;
        this.puzzle.addListener(this);
    }

    public int getColumnCount() {
        return puzzle.getNumLines();
    }

    public int getRowCount() {
        return puzzle.getNumColumns();
    }

    public Object getValueAt(int row, int col) {
        return new Integer(puzzle.getTileValue(row, col));
    }

    public void puzzleChanged(ForkliftEvent pe){
        fireTableDataChanged();
        try{
            Thread.sleep(500);
        }catch(InterruptedException ignore){
        }
    }

    public void setPuzzle(ForkliftState puzzle){
        if(puzzle == null){
          throw new NullPointerException("Puzzle cannot be null");
        }
        this.puzzle.removeListener(this);
        this.puzzle = puzzle;
        puzzle.addListener(this);
        fireTableDataChanged();
    }
}
