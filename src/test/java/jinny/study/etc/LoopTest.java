package jinny.study.etc;

import org.junit.jupiter.api.Test;

public class LoopTest {

    @Test
    public void loopTest() {
        int i = 0;
        while (i < 100) {
            i++;
            if (i % 2 == 0) {
                continue;
            }

            for (int k = 0; k < 10; k++) {
                if (i * k >= 50) {
                    break;
                }
                System.out.println("k :" + k);
            }
            System.out.println(i);
        }
    }


}
