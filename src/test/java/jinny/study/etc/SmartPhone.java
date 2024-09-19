package jinny.study.etc;

public interface SmartPhone {

    static SmartPhone getSamsungPhone() {
        return new SamsungPhone();
    }

    static SmartPhone getApplePhone() {
        return new ApplePhone();
    }
}
