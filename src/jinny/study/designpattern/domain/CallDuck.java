package jinny.study.designpattern.domain;

import jinny.study.designpattern.impl.Quack;
import jinny.study.designpattern.service.QuackBehavior;

public class CallDuck {

    public QuackBehavior quackBehavior;

    public CallDuck() {
        quackBehavior = new Quack();
    }
}
