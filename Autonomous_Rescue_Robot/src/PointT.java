/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Point ADT class
 */

import static java.lang.Math.*;

/**
 * @brief An ADT that represents a point
 */
public class PointT
{
   protected double xc;
   protected double yc;

  /**
   * @brief Initializes a point object.
   * @param x Coordinate on the x-axis
   * @param y Coordinate on the y-axis
   */
   public PointT(double x, double y)
   {
     if ((x < 0) || (x > Constants.MAX_X) || (y<0) || (y > Constants.MAX_Y))
     {
       throw new InvalidPointException("Point is outside the valid region");
     }
     xc = x;
     yc = y;
   }

  /**
   * @brief Gets the x-coordinate
   */
   public double xcrd()
   {
     return xc;
   }

  /**
   * @brief Gets the y-coordinate
   */
   public double ycrd()
   {
     return yc;
   }

  /**
   * @brief Computes the distance between two points
   * @param p Specified point
   */
   public double dist(PointT p)
   {
     double dx;
     double dy;

     dx = this.xc - p.xc;
     dy = this.yc - p.yc;

     return sqrt(pow(dx,2.0) + pow(dy,2.0));
   }
}
