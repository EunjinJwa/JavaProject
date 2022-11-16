package jinny.study.pattern.observer;

public class WeatherStationMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurments(80, 65, 30.4f);
        weatherData.setMeasurments(70, 60, 32.4f);

    }
}
