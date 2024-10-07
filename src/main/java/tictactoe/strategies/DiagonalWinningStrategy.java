package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    private Map<Character, Integer> leftDiaCounts = new HashMap<>();
    private Map<Character, Integer> rightDiaCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {


        /*
    board
        | | | | -> arrayList , 0+2 = 2
        | | | | -> arrayList , 1+1 = 2
        | | | | -> arrayList , 2+0 = 2
     */

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        // for the left diagonal
        if(row==col){
            if(!leftDiaCounts.containsKey(symbol)){
                leftDiaCounts.put(symbol, 0);
            }
            leftDiaCounts.put(symbol, leftDiaCounts.get(symbol)+1);
        }

        if(row==col) {
            if (leftDiaCounts.get(symbol).equals(board.getDimension())) {
                return true;
            }
        }

        // for the right diagonal
        if(row+col == board.getDimension()-1){
            if(!rightDiaCounts.containsKey(symbol)){
                rightDiaCounts.put(symbol, 0);
            }
            rightDiaCounts.put(symbol, rightDiaCounts.get(symbol)+1);
        }

        if(row+col==board.getDimension()-1) {
            if (rightDiaCounts.get(symbol).equals(board.getDimension())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

        char symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        // was last move part of left diagonal
        if(row==col){
            leftDiaCounts.put(symbol, leftDiaCounts.get(symbol)-1);
        }

        // was last move part of right diagonal
        if(row+col==board.getDimension()-1){
            rightDiaCounts.put(symbol, rightDiaCounts.get(symbol)-1);
        }
    }


}
