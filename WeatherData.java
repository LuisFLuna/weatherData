public class WeatherData implements Subject{
   
   ArrayList<Observer> observers;
   float humidity;
   float pressure;
   float temperature;

   public WeatherData() {
        observers = new ArrayList<Observer>;
   }

   public registerObserver(Observer o){
       observers.add(o);
   }

   public removeObserver(Observer o){
       int index = observers.indexOf(o);
       if(index >= 0)
            observers.remove(o);
   }

   public notifyObservers(){
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
   }

   public measurementChanged(){
       notifyObservers();
   }

   public void setMeasurements(float temperature, float humidity, float pressure){
       this.temperature = temperature;
       this. humidity = humidity;
       this.pressure = pressure;
       measurementChanged();
   }

   public float getHumidity(){
       return humidity;
   }

   public float getPressure(){
       return pressure;
   }

   public float getTemperature(){
       return temperature;
   }

}