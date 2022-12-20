package jinny.study.pattern.templatecallback;

public interface LineCallback<T> {
    T doSometingWithLine(String line, T value);
}
