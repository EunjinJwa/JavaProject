package jinny.study.designpattern.impl;

import jinny.study.designpattern.service.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑삑 !! ");
    }
}
