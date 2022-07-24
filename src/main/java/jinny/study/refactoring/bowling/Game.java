package jinny.study.refactoring.bowling;

public class Game {
    private int itsCurrentFrame = 0;
    private boolean firstThrowInFrame = true;
    private Score itsScore = new Score();

    public int score() {
        return scoreForFrame(itsCurrentFrame);
    }

    public void add(int pins) {
        itsScore.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (lastBallInFrame(pins)) {
            advanceFrame();
        } else {
            firstThrowInFrame = false;
        }
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(11, itsCurrentFrame + 1);
    }

    private boolean lastBallInFrame(int pins) {
        return strike(pins) || !firstThrowInFrame;
    }

    private boolean strike(int pins) {
        return (firstThrowInFrame && pins == 10);
    }

    private int scoreForFrame(int theFrame) {
        return itsScore.scoreForFrame(theFrame);
    }

}
