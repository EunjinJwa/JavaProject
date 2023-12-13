package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileTest {

    @Test
    public void fileExistTest() {

        File file = new File("/Users/kassy/20230719_1");
        System.out.println(file.exists());

        System.out.println(file.mkdir());

        System.out.println(file.list().length);

        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
    }


}
