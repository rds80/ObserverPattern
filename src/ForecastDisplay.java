public  class ForecastDisplay implements IObserver, IDisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;
    private float temp;
    private float humidity;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        }
        else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        }
        else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.lastPressure = currentPressure;
        this.currentPressure = pressure;
        this.temp = temp;
        this.humidity = humidity;

        display();
    }
}