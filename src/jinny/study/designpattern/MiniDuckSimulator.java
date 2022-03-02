package jinny.study.designpattern;

import jinny.study.designpattern.domain.CallDuck;
import jinny.study.designpattern.domain.Duck;
import jinny.study.designpattern.domain.MallardDuck;
import jinny.study.designpattern.domain.RubberDuck;
import jinny.study.designpattern.impl.MuteQuack;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();

        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.setQuackBehavior(new MuteQuack());
        rubberDuck.performQuack();


        CallDuck callDuck = new CallDuck();
        callDuck.quackBehavior.quack();

    }

}
