package br.com.bjbraz.pojo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Coordenada {
	
	private double latitude;
	private double longitude;

	private DecimalFormat format;
	  
	  /**
	   * Constructor for this class
	   *
	   * @param latitude a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   */
	  public Coordenada(double latitude, double longitude) {
	  
	    if(CoordinateManager.isValidLatitude(latitude) == true && CoordinateManager.isValidLongitude(longitude) == true) {
	      this.latitude = latitude;
	      this.longitude = longitude;
	    } else {
	      throw new IllegalArgumentException("The parameters did not pass validation as defined by the CoordinateManager class");
	    }
	    
	    this.format = new DecimalFormat("##.#######");
		DecimalFormatSymbols da= DecimalFormatSymbols.getInstance();
		da.setPerMill('.');
		da.setDecimalSeparator('.');
		format.setDecimalFormatSymbols(da);
	    this.format.setDecimalFormatSymbols(da);
	  }
	  
	  /*
	   * get and set methods
	   */
	  public double getLatitude() {
	    return latitude;
	  }
	  
	  public double getLongitude() {
	    return longitude;
	  }
	  
	  public void setLatitude(float latitude) {
	    if(CoordinateManager.isValidLatitude(latitude) == true) {
	      this.latitude = latitude;
	    } else {
	      throw new IllegalArgumentException("The parameter did not pass validation as defined by the CoordinateManager class");
	    }
	  }
	  
	  public void setLongitude(float longitude) {
	    if(CoordinateManager.isValidLongitude(longitude) == true) {  
	      this.longitude = longitude;
	    } else {
	      throw new IllegalArgumentException("The parameter did not pass validation as defined by the CoordinateManager class");
	    }
	  }
	  
	  public String getLatitudeAsString() {
		return format.format(latitude);
	  }
	  
	  public String getLongitudeAsString() {
		return format.format(longitude);
	  }
	  
	  public String toString() {
	    return format.format(latitude) + ", " + format.format(longitude);
	  }
	  
	  /*
	   * methods required for ordering in collections
	   * http://java.sun.com/docs/books/tutorial/collections/interfaces/order.html
	   */

	  /**
	   * A method to determine if one event is the same as another
	   *
	   * @param o the object to compare this one to
	   *
	   * @return  true if they are equal, false if they are not
	   */
	  public boolean equals(Object o) {
	    // check to make sure the object is an event
	    if ((o instanceof Coordenada) == false) {
	      // o is not an event object
	       return false;
	    }
	    
	    // compare these two events
	    Coordenada c = (Coordenada)o;
	    
	    // build items for comparison
	    String me  = this.getLatitudeAsString() + this.getLongitudeAsString();
	    String you = c.getLatitudeAsString() + c.getLongitudeAsString();
	    
	    return me.equals(you);
	    
	  } // end equals method
	  
	  /**
	   * Overide the default hashcode method
	   * 
	   * @return a hashcode for this object
	   */
	  public int hashCode() {
	  
	    String me = this.getLatitudeAsString() + this.getLongitudeAsString();
	    return 31*me.hashCode();
	  }
	    
	    /**
	     * The compareTo method compares the receiving object with the specified object and returns a 
	     * negative integer, 0, or a positive integer depending on whether the receiving object is 
	     * less than, equal to, or greater than the specified object.
	     *
	     * @param c the event to compare this one to
	     *
	     * @return  an integer indicating comparison result
	     */    
	  public int compareTo(Coordenada c) {
	  
	    String me  = this.getLatitudeAsString() + this.getLongitudeAsString();
	    String you = c.getLatitudeAsString() + c.getLongitudeAsString();
	    
	    Double meDbl  = Double.valueOf(me);
	    Double youDbl = Double.valueOf(you);
	    
	    if(meDbl == youDbl) {
	      return 0;
	    } else {
	      Double tmp = Math.floor(meDbl - youDbl);
	      return tmp.intValue();
	    }
	    
	  } // end compareTo method
	}
	class CoordinateManager {

	  // declare public constants
	  
	  /**
	   * The minimum allowed latitude
	   */
	  public static float MIN_LATITUDE = Float.valueOf("-90.0000");
	  
	  /**
	   * The maximum allowed latitude
	   */
	  public static float MAX_LATITUDE = Float.valueOf("90.0000");
	  
	  /**
	   * The minimum allowed longitude
	   */
	  public static float MIN_LONGITUDE = Float.valueOf("-180.0000");
	  
	  /**
	   * The maximum allowed longitude 
	   */
	  public static float MAX_LONGITUDE = Float.valueOf("180.0000");
	  
	  /**
	   * The diameter of the Earth used in calculations
	   */
	  public static float EARTH_DIAMETER = Float.valueOf("12756.274");

	  /**
	   * A method to validate a latitude value
	   *
	   * @param latitude the latitude to check is valid
	   *
	   * @return         true if, and only if, the latitude is within the MIN and MAX latitude
	   */
	  public static boolean isValidLatitude(double latitude) {
	    if(latitude >= MIN_LATITUDE && latitude <= MAX_LATITUDE) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	  
	  /**
	   * A method to validate a longitude value
	   *
	   * @param longitude the longitude to check is valid
	   *
	   * @return          true if, and only if, the longitude is between the MIN and MAX longitude
	   */
	  public static boolean isValidLongitude(double longitude) {
	    if(longitude >= MIN_LONGITUDE && longitude <= MAX_LONGITUDE) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	  
	  /**
	   * A private method to calculate the latitude constant
	   *
	   * @return a double representing the latitude constant
	   */
	  public static double latitudeConstant() {
	    return EARTH_DIAMETER * (Math.PI / Float.valueOf("360"));
	    //return EARTH_DIAMETER * (Float.valueOf("3.14") / Float.valueOf("360"));
	  }
	  
	  /**
	   * A private method to caluclate the longitude constant
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   *
	   * @return a double representing the longitude constant
	   */
	  public static double longitudeConstant(float latitude) {
	  
	    //return Math.abs( Math.cos(Math.abs(latitude)));
	    return EARTH_DIAMETER * Math.PI * Math.abs(Math.cos(Math.abs(latitude))) / Float.valueOf("360");
	  
	  }
	  
	  /**
	   * A method to add distance in a northerly direction to a coordinate
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   * @param distance  the distance to add in metres
	   *
	   * @return          the new coordinate
	   */
	  public static Coordenada addDistanceNorth(double latitude, double longitude, int distance) {
	  
	    // check on the parameters
	    if(isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
	      throw new IllegalArgumentException("All parameters are required and must be valid");
	    }
	    
	    // convert the distance from metres to kilometers
	    double kilometers = distance / new Float(1000);  
	    
	    // calculate the new latitude
	    double newLat = latitude + (kilometers / latitudeConstant());
	    
	    return new Coordenada(newLat, longitude);
	  
	  }
	  
	  /**
	   * A method to add distance in a southerly direction to a coordinate
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   * @param distance  the distance to add in metres
	   *
	   * @return          the new coordinate
	   */
	  public static Coordenada addDistanceSouth(float latitude, float longitude, int distance) {
	  
	    // check on the parameters
	    if(isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
	      throw new IllegalArgumentException("All parameters are required and must be valid");
	    }
	    
	    // convert the distance from metres to kilometers
	    float kilometers = distance / new Float(1000);
	    
	    // calculate the new latitude
	    double newLat = latitude - (kilometers / latitudeConstant());
	    
	    return new Coordenada(new Float(newLat).floatValue(), longitude);
	  
	  }
	  
	  /**
	   * A method to add distance in an easterly direction to a coordinate
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   * @param distance  the distance to add in metres
	   *
	   * @return          the new coordinate
	   */
	  public static Coordenada addDistanceEast(float latitude, float longitude, int distance) {
	  
	    // check on the parameters
	    if(isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
	      throw new IllegalArgumentException("All parameters are required and must be valid");
	    }
	    
	    // convert the distance from metres to kilometers
	    float kilometers = distance / 1000;  
	    
	    // calculate the new longitude
	    double newLng = longitude + (distance / longitudeConstant(latitude));
	    
	    return new Coordenada(latitude, new Float(newLng).floatValue());  
	  }
	  
	  /**
	   * A method to add distance in an westerly direction to a coordinate
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   * @param distance  the distance to add in metres
	   *
	   * @return          the new coordinate
	   */
	  public static Coordenada addDistanceWest(float latitude, float longitude, int distance) {
	  
	    // check on the parameters
	    if(isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
	      throw new IllegalArgumentException("All parameters are required and must be valid");
	    }
	    
	    // convert the distance from metres to kilometers
	    float kilometers = distance / 1000;  
	    
	    // calculate the new longitude
	    double newLng = longitude - (distance / longitudeConstant(latitude));
	    
	    return new Coordenada(latitude, new Float(newLng).floatValue());  
	  }
	  
	  /**
	   * A method to build four coordinates representing a bounding box given a start coordinate and a distance
	   *
	   * @param latitude  a latitude coordinate in decimal notation
	   * @param longitude a longitude coordinate in decimal notation
	   * @param distance  the distance to add in metres
	   *
	   * @return          a hashMap representing the bounding box (NE,SE,SW,NW)
	   */
	  public static java.util.HashMap<String, Coordenada> getBoundingBox(float latitude, float longitude, int distance) {
	  
	    // check on the parameters
	    if(isValidLatitude(latitude) == false || isValidLongitude(longitude) == false || distance <= 0) {
	      throw new IllegalArgumentException("All parameters are required and must be valid");
	    }
	    
	    // convert the distance from metres to kilometers
	    float kilometers = distance / 1000;  
	    
	    // declare helper variables
	    java.util.HashMap<String, Coordenada> boundingBox = new java.util.HashMap<String, Coordenada>();
	    
	    // calculate the coordinates
	    Coordenada north = addDistanceNorth(latitude, longitude, distance);
	    Coordenada south = addDistanceSouth(latitude, longitude, distance);
	    Coordenada east  = addDistanceEast(latitude, longitude, distance);
	    Coordenada west  = addDistanceWest(latitude, longitude, distance);
	    
	    // build the bounding box object
	    boundingBox.put("NE", new Coordenada(north.getLatitude(), east.getLongitude()));
	    boundingBox.put("SE", new Coordenada(south.getLatitude(), east.getLongitude()));
	    boundingBox.put("SW", new Coordenada(south.getLatitude(), west.getLongitude()));
	    boundingBox.put("NW", new Coordenada(north.getLatitude(), west.getLongitude()));
	    
	    // return the bounding box object
	    return boundingBox;  
	  }
	}

