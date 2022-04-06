/*
 Represents information about a NWS weather station
*/

public class WeatherStation {
   private String name;
   private String id;
   private String state;
   private double lat;
   private double lng;
   private double wind;
   private double temp_f;


   WeatherStation(String name, String id, String state, double lat, double lng, double wind, double temp) {
      this.name = name;
      this.id = id;
      this.lat = lat;
      this.lng = lng;
      this.state = state;
      this.lat = lat;
      this.lng = lng;
      this.wind = wind;
      this.temp_f = temp_f;
   }

   /* Produce the id of this station */
   public String getId() {
      return id;
   }

   /* Produce the name of this station */
   public String getName() {
      return name;
   }

   public double getLatitude() {
      return lat;
   }

   public double getLongitude() {
      return lng;
   }

   public double getWind() {
      return wind;
   }

   public double getTemp_f() {
      return temp_f;
   }
   public double getTemp_c() {
      return ((temp_f - 32)*(5/9));
   }

   /* Determine if this weather station is located in the given state */
   public boolean isLocatedInState(String st) {
      return this.state.equals(st);
   }



}
