package tictactoe.app;

import tictactoe.controllers.GameController;
import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.models.*;
import tictactoe.strategies.ColWinningStrategy;
import tictactoe.strategies.DiagonalWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {

        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = new ArrayList<>();

        players.add(new Player('X', "Keerthi", 1, PlayerType.HUMAN));
        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);
        game.print();
    }
}
