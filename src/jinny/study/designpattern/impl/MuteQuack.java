package jinny.study.designpattern.impl;

import jinny.study.designpattern.service.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("-- (소리낼 수 없음) --");
    }
}
