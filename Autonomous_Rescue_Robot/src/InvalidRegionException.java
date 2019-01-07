/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Invalid region exception
 */

/**
 * @brief An exception for an invalid region.
 */
public class InvalidRegionException extends RuntimeException
{
   public InvalidRegionException()
   {
     super();
   }
   public InvalidRegionException(String reason)
   {
     super(reason);
   }
}
