package jinny.study.tdd;

public class Game {

    GameNumGen gameNumGen;

    public Game (GameNumGen gameNumGen) {
        this.gameNumGen = gameNumGen;
    }

    public void init (GameLevel gameLevel) {
        gameNumGen.generate(gameLevel);
    }
}
