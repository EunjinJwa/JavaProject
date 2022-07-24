package jinny.study.refactoring.bowling;

public class Score {

    private int ball;
    private int[] itsThrows = new int[21];
    private int itsCurrentThorw = 0;
    public void addThrow(int pins) {
        itsThrows[itsCurrentThorw++] = pins;
    }

    public int scoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            if (strike()) {
                score += 10 + nextTwoBallsForStrike();
                ball++;
            } else if (spare()) {
                score += 10 + nextBallForSpare();
                ball += 2;
            } else {
                score += twoBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private int nextTwoBallsForStrike() {
        return itsThrows[ball + 1] + itsThrows[ball + 2];
    }

    private int nextBallForSpare() {
        return itsThrows[ball + 2];
    }

    private int twoBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private boolean strike() {
        return itsThrows[ball] == 10;
    }

    private boolean spare() {
        return itsThrows[ball] + itsThrows[ball + 1] == 10;
    }

}
