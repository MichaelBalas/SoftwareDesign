/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Map Abstract object
 */

/**
 * @brief An abstract object that represents the map of obstacles, destinations and safe zones
 */
public class Map
{
   protected static Obstacles obstacles;

   protected static Destinations destinations;

   protected static SafeZone safeZone;

  /**
   * @brief Initializes the Map abstract object.
   * @param o Obstacles to be initialized
   * @param d Destinations to be intialized
   * @param sz Safe zone to be initialized
   */
   public static void init(Obstacles o, Destinations d, SafeZone sz)
   {
     obstacles = o;
     destinations = d;
     safeZone = sz;
   }

  /**
   * @brief Gets the obstacles.
   */
   public static Obstacles get_obstacles()
   {
     return obstacles;
   }

  /**
   * @brief Gets the destinations.
   */
   public static Destinations get_destinations()
   {
     return destinations;
   }

  /**
   * @brief Gets the safe zones.
   */
   public static SafeZone get_safeZone()
   {
     return safeZone;
   }
}
