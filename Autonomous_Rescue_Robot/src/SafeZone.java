/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: SafeZone module
 */

/**
 * @brief An ADT that represents safe zones
 */
public class SafeZone extends GenericList<RegionT>
{
   public final static int MAX_SIZE = 1;

  /**
   * @brief Adds a region into a safe zone
   * @param i The position in which the region is to be inserted
   * @param p The region that is to be inserted
   */
   public void add(int i, RegionT p)
   {
     //check exception for MAX_SIZE
     if (s.size() == MAX_SIZE)
     {
       throw new FullSequenceException("Cannot add to list.  List is full.");
     }
     
     try
     {
       s.add(i, p);
     }
     catch (IndexOutOfBoundsException e)
     {
       throw new InvalidPositionException("Position " + i + " does not exist in the list");
     } 
   }

}
