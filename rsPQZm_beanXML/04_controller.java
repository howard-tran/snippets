@RestController()
@RequestMapping(value = "/weather_v3")
@ImportResource("classpath:beans/beans.xml")
public class WeatherControllerV3 {
    @Autowired
    private WeatherServiceV3 weatherServiceV3;

    @GetMapping("/get")
    public Object getWeatherTime() {
        return this.weatherServiceV3.getWeatherTimerService();
    }
}