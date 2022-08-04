package jinny.study.refactoring;

import jinny.study.pattern.ActiveObjectEngine;
import jinny.study.pattern.Command;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSleepCommand {

    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception {
        Command wakeup = new Command() {
            @Override
            public void execute () {
                commandExecuted = true;
            }
        };

        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommand(c);

        long start = System.currentTimeMillis();
         e.run();
        long stop = System.currentTimeMillis();

        long sleepTime = (stop - start);

        Assertions.assertThat(sleepTime).isGreaterThan(900);
        Assertions.assertThat(sleepTime).isLessThan(1100);
        Assertions.assertThat(commandExecuted).isTrue();
    }

}
