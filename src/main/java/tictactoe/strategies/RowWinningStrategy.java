package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{


    // we need 3 maps for each row
    // o -> map (X - 2), (0, 3)
    private final Map<Integer, HashMap<Character, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol();

        // first entry in the row
        if(!counts.containsKey(row)){
            counts.put(row, new HashMap<>());
        }

        Map<Character, Integer> rowMap = counts.get(row);

        // is this symbol already exists in this row or not
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol, rowMap.get(symbol)+1);

        if(rowMap.get(symbol).equals(board.getDimension())){
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        char symbol = lastMove.getPlayer().getSymbol();

        HashMap<Character, Integer> rowMap = counts.get(row);
        rowMap.put(symbol, rowMap.get(symbol)-1);
    }
}
