package jinny.study.designpattern.domain;

import jinny.study.designpattern.impl.FlyNoWay;
import jinny.study.designpattern.impl.Squeak;

public class RubberDuck extends Duck {
    @Override
    public void display() {
        System.out.println("저는 러버덕(고무오리) 입니다. ");
    }

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }
}
