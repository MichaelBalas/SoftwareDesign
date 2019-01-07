/**
 * Author: Michael Balas
 * Revised: Jan 2, 2018
 *
 * Description: Full sequence exception
 */

/**
 * @brief An exception for a full sequence.
 */
public class FullSequenceException extends RuntimeException
{
   public FullSequenceException()
   {
     super();
   }
   public FullSequenceException(String reason)
   {
     super(reason);
   }
   public FullSequenceException(int full)
   {
     super("The sequence has reached its full size of " + full);
   }
}
