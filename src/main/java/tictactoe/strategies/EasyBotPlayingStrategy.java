package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    /*
    board
       eachRow ,List<Cell> ->     | C || C || X |
       eachRow ,List<Cell> ->     | C || X || - |
       eachRow ,List<Cell> ->     | X || - || - |

                                   cel cel cel
     */

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Bot is making the move ");
        for(List<Cell> eachRow: board.getBoard()){
            for(Cell cell: eachRow){
                if (CellState.EMPTY.equals(cell.getCellState())) {
                    return cell;
                }
            }
        }

        // Board is already full, throw an exception maybe.
        return null;
    }
}
