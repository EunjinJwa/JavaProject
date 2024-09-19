package jinny.study.etc;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    @Test
    void getSamsungPhone() {
        SmartPhone applePhone = SmartPhone.getApplePhone();
    }

}
