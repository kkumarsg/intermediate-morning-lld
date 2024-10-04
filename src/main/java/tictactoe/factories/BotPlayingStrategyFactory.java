package tictactoe.factories;

import tictactoe.models.Bot;
import tictactoe.models.BotDifficultyLevel;
import tictactoe.strategies.BotPlayingStrategy;
import tictactoe.strategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForLevel(BotDifficultyLevel level){
        // write the logic for all botstrategies
        return new EasyBotPlayingStrategy();
    }
}
