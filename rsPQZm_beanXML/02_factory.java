public class WeatherTimeFactory {
    public IWeatherTime getWeatherTime() {
        return new WeatherTimeV3();
    }
}