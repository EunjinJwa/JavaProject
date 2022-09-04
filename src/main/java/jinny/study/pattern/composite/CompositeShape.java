package jinny.study.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {

    List<Shape> shapes = new ArrayList<Shape>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
