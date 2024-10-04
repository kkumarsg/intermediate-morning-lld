package tictactoe.models;

import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.MoreThanOneBotException;
import tictactoe.exceptions.PlayersCountDimensionMismatchException;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void print() {
        board.printBoard();
    }

    public static class GameBuilder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private GameBuilder(){
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build() throws MoreThanOneBotException, PlayersCountDimensionMismatchException, DuplicateSymbolException {
            validateBotCount();
            validateDimensionAndPlayersCount();
            validateUniqueSymbolForPlayers();
            return new Game(dimension, players, winningStrategies);
        }

        private void validateUniqueSymbolForPlayers() throws DuplicateSymbolException {
            Set<Character> symbolsSet = new HashSet<>();
            for(Player player: players){
                if (symbolsSet.contains(player.getSymbol())) {
                    throw new DuplicateSymbolException();
                }
                symbolsSet.add(player.getSymbol());
            }
        }

        private void validateDimensionAndPlayersCount() throws PlayersCountDimensionMismatchException {
            if (players!=null && players.size()!=dimension-1) {
                throw new PlayersCountDimensionMismatchException();
            }
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;

            for(Player player: players){
//                if (player.getPlayer!=null &&
//                player.getPlayerType().equals(PlayerType.BOT)) {
                if (PlayerType.BOT.equals(player.getPlayerType())) {
                    botCount++;
                }
            }

            if (botCount > 1) {
                throw new MoreThanOneBotException();
            }
        }


    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
