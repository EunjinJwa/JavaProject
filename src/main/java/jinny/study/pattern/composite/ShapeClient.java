package jinny.study.pattern.composite;

public class ShapeClient {
    public static void main(String[] args) {

        /**
         * Circle과 Square 를 둘 다 그리고싶다!
         */

        /** 일반적인 기존 방법 */
        Shape circle = new Circle();
        circle.draw();
        Shape square = new Square();
        square.draw();

        /** Composite 패턴 사용 */
        CompositeShape shape = new CompositeShape();
        shape.add(new Circle());
        shape.add(new Square());
        shape.draw();

    }
}
