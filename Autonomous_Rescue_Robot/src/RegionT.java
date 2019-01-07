/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Region ADT class
 */

/**
 * @brief An ADT that represents a region on the map
 */
public class RegionT
{
   protected PointT lower_left;
   protected double width;
   protected double height;

  /**
   * @brief Initializes a region object.
   * @param p The lower left point
   * @param w The width from the point
   * @param h The height from the point
   */
   public RegionT(PointT p, double w, double h)
   {
     if ((w <= 0) || (h <= 0) || ((p.xcrd() + w) >= Constants.MAX_X) || ((p.ycrd() + h) >= Constants.MAX_Y))
     {
       throw new InvalidRegionException("Invalid input to RegionT constructor.  Region extends outside the valid area");
     }
     lower_left = p;
     width = w;
     height = h;
   }

  /**
   * @brief Checks whether a point is in the region
   * @param p The specified point
   */
   public boolean pointInRegion(PointT p)
   {
     /* Temporary variables to make the code easier to read */
     boolean pinR; //the value to return
     double llx = lower_left.xcrd();
     double lly = lower_left.ycrd();
     double llxw = llx + width;
     double llyh = lly + height;
     double px = p.xcrd();
     double py = p.ycrd();

     if (px < llx)
     {
       if (py < lly)
       { 
         pinR = p.dist(new PointT(llx, lly)) <= Constants.TOLERANCE;
       }
       else if ((py >= lly) && (py <= llyh))
       {
         pinR = (llx - px) <= Constants.TOLERANCE;
       }
       else //py > llyh
       {
         pinR = p.dist(new PointT(llx, llyh)) <= Constants.TOLERANCE;         
       }
     }
     else if ((px >= llx) && (px <= llxw))
     {
       if (py < lly)
       { 
         pinR = (lly - py) <= Constants.TOLERANCE;
       }
       else if ((py >= lly) && (py <= llyh))
       {
         pinR = true;
       }
       else //py > llyh
       {
         pinR = (py - lly) <= Constants.TOLERANCE;
       }
     }
     else //px > llxw
     {
       if (py < lly)
       { 
         pinR = p.dist(new PointT(llxw, lly)) <= Constants.TOLERANCE;
       }
       else if ((py >= lly) && (py <= llyh))
       {
         pinR = (px - llxw) <= Constants.TOLERANCE;
       }
       else //py > llyh
       {
         pinR = p.dist(new PointT(llxw, llyh)) <= Constants.TOLERANCE;         
       }
     }

     return pinR;
   }
}
