package jinny.study.designpattern.impl;

import jinny.study.designpattern.service.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날고있습니다.!!! ");
    }
}
