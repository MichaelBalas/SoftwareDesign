/**
 * Author: Michael Balas
 * Revised: Jan 2, 2018
 * 
 * Description: Invalid Point Exception
 */

/**
 * @brief An exception for an invalid point.
 */
public class InvalidPointException extends RuntimeException
{
   public InvalidPointException()
   {
     super();
   }
   public InvalidPointException(String reason)
   {
     super(reason);
   }
}
