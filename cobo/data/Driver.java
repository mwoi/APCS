/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name",
             "station/station_id", "station/state",
             "station/latitude", "station/longitude", "weather", "temp_f", "wind_degrees");
      System.out.println("Total stations: " + allstns.size());

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }
      Scanner sc2 = new Scanner(System.in);
      System.out.println("Enter a station ID: ");
      String StatId = sc.next();
      WeatherStation ws2 = null;
      for (WeatherStation ws : allstns) {
         if (ws.getID().equals(StatId)) {
            ws2 = ws;
         }
      }
      System.out.println("Info  for " + state);
      System.out.println("Latitude: " + ws2.getLatitude());
      System.out.println("Longitude: " + ws2.getLongitude());
      System.out.println("Weather: " + ws2.getWeather());
      System.out.println("Temperature (F): " + ws2.getTemp_f());
      System.out.println("Wind: " + ws2.getWind());

   }
}
