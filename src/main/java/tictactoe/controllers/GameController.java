package tictactoe.controllers;

import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.models.Game;
import tictactoe.models.Player;
import tictactoe.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    /*
        How will the client interactions start ?
        1. start/create the game -> enter all the details required
        2. makeMove() -> User to enter the location
        3. displayBoard()
        4. checkStatus() -> check if someone has won or not.

        5. undo()
        6. getWinner() -> Diaply the name if someone has won.
     */

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(strategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void printGame(Game game){
        game.print();
    }

    public void undo(Game game) {
        game.undo();
    }
}
