/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Comparator object for comparing Points
 * 
 */

import java.util.Comparator;

public class PointComparator implements Comparator<PointT>
{
   public int compare(PointT p1, PointT p2)
   {
     PointT origin = new PointT(0.0, 0.0);
     if (p1.dist(origin) < p2.dist(origin))
     {
       return -1;
     }
     if (p1.dist(origin) == p2.dist(origin))
     {
       return 0;
     }
     return 1;
   }
}
