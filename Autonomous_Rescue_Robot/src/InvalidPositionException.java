/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Invalid position exception
 */

/**
 * @brief An exception for an invalid position.
 */
public class InvalidPositionException extends RuntimeException
{
   public InvalidPositionException()
   {
     super();
   }
   public InvalidPositionException(String reason)
   {
     super(reason);
   }
   public InvalidPositionException(int i, int last)
   {
     super("Invalid position " + i + ".  Position should be between 0 and " + last + "inclusive.");
   }
}
