package jinny.study.refactoring;

import jinny.study.pattern.ActiveObjectEngine;
import jinny.study.pattern.Command;

public class SleepCommand implements Command {

    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    public SleepCommand (int milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        sleepTime = milliseconds;
        engine = e;
        this.wakeupCommand = wakeupCommand;
    }

    @Override
    public void execute () {
        long currentTime = System.currentTimeMillis();
        System.out.println(currentTime);
        if (!started) {
            System.out.println(1);
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        } else if ((currentTime - startTime) < sleepTime) {
            System.out.println(2);
            engine.addCommand(this);
        } else {
            System.out.println(3);
            engine.addCommand(wakeupCommand);
        }
    }
}
