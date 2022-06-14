package jinny.study.refactoring.domain;

import java.util.HashMap;

public class Play {

    public HashMap<String, PlayForm> play;

    public Play() {
        if (this.play == null) play = new HashMap<>();
        this.play.put("hamlet", new PlayForm("Hamlet", PlayType.tragedy));
        this.play.put("as-like", new PlayForm("As You Like It", PlayType.comedy));
        this.play.put("othello", new PlayForm("Othello", PlayType.tragedy));
    }
}

