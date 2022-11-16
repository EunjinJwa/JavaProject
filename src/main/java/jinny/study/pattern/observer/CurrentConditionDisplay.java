package jinny.study.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Observer 객체
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    Observable observable;      // Observable : Subject 객체
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {    // Observable : Subject 객체
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degress and " + humidity + "% humidity");
    }

}
