/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Path Calculation abstract object
 */

public class PathCalculation
{
   private static final double ADMISS_ERR = 1e-10; //to account for the loss of accuracy with real numbers

  /**
   * @brief Calculates the total distance of a path
   * @param p The path that needs to be computed
   */
   public static double totalDistance(PathT p)
   {
     int i;
     double totalD=0.0;

     for(i = 0; i < (p.size()-1); i++)
     {
       totalD = totalD + p.getval(i).dist(p.getval(i+1));
     }

     return totalD;
   }

  /**
   * @brief Calculates the total number of turns in a path
   * @param p The path that needs to be computed
   */
   public static int totalTurns(PathT p)
   {
     int i;
     int count=0;
     double theta;

     for(i = 0; i < (p.size()-2); i++)
     {
       theta = Math.abs(angle(p.getval(i), p.getval(i+1), p.getval(i+2)));
       if (theta > ADMISS_ERR) //allow small numbers to be assumed zero
       {
         count++;
       }
     }

     return count;
   }

  /**
   * @brief Calculates the estimated time of a path
   * @param p The path that needs to be computed
   */
   public static double estimatedTime(PathT p)
   {
     int i;
     double theta;
     double estTime=0.0;

     /* add linear time */
     for(i = 0; i < (p.size()-1); i++)
     {
       estTime = estTime + p.getval(i).dist(p.getval(i+1))/Constants.VELOCITY_LINEAR;
     }

     /* add angular time */
     for(i = 0; i < (p.size()-2); i++)
     {
       theta = Math.abs(angle(p.getval(i), p.getval(i+1), p.getval(i+2)));
       estTime = estTime + theta/Constants.VELOCITY_ANGULAR;
     }

     return estTime;
   }

  /**
   * @brief Calculates the angle between three points
   * @param p1 First point
   * @param p2 Second point
   * @param p3 Third point
   */
   private static double angle(PointT p1, PointT p2, PointT p3)
   {
     double dotprod;
     double magnitude;
     double cosine;

     dotprod = (p2.xcrd() - p1.xcrd())*(p3.xcrd() - p2.xcrd()) + (p2.ycrd() - p1.ycrd())*(p3.ycrd() - p2.ycrd());
     magnitude = p1.dist(p2)*p2.dist(p3); 
     if ((dotprod == 0.0) && (magnitude == 0.0)) //points are coincident
     {
       cosine = 1.0;
     }
     else
     {
       cosine = dotprod/magnitude;
     }

     /* The following code avoids potential errors for values just out of the admissible range of acos() */
     if ((cosine > 1) && ((cosine-1) <= ADMISS_ERR)) //a little above 1, call it 1
     {
       cosine = 1;
     }
     if ((cosine < -1) && ((-1-cosine) <= ADMISS_ERR)) //a little below 1, call it 1
     {
       cosine = -1;
     }

     return Math.acos(cosine);
   }
}
