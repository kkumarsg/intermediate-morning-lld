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
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws DuplicateSymbolException, PlayersCountDimensionMismatchException, MoreThanOneBotException {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        // we should be passing this scanner for the player, or you can use single instance of this.

        int dimension = 3;
        List<Player> players = new ArrayList<>();

        players.add(new Player('X', "Keerthi", 1, PlayerType.HUMAN));
        players.add(new Player('0', "Shreyasi", 2, PlayerType.HUMAN));
//        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = new ArrayList<>();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){

            /*
             1. print the board
             2. anybody wants to undo the movement
             3. x's turn, ask him to make move
             */

            gameController.printGame(game);

            System.out.println("Does anybody wants to undo? (y/n)");
            String undoAnswer = scanner.next();

            if(undoAnswer.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        // The game status is not in progress, that means it can be success -> winner or draw
        if(GameState.SUCCESS.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+", Has won the game "+game.getWinner().getSymbol());
            game.print();
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("It's a draw ");
        }

    }
}
