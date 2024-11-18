public class WeatherServiceV3 {

    public Map<String, String> getWeatherTimerService() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("weather", String.valueOf(this.getWeatherTime().getLdt2()));
        return map;
    }

    public IWeatherTime getWeatherTime() {
        return null;
    }
}