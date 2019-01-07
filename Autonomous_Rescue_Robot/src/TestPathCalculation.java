/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Testing path calculation
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestPathCalculation
{

   private static final double ADMISS_ERR = 1e-6;
   private PathT p;

   private static double xmax = Constants.MAX_X;
   private static double ymax = Constants.MAX_Y;

   private static final PointT centre = new PointT(xmax/2.0, ymax/2.0); //point at centre
   private static final PointT ll = new PointT(0.0, 0.0); //lower left of area
   private static final PointT lr = new PointT(0.0, ymax); //lower right of area
   private static final PointT ur = new PointT(xmax, ymax); //upper right of area
   private static final PointT ul = new PointT(xmax, 0.0); //upper left of area
   private static final PointT quad1 = new PointT(xmax/3.0, ymax/10.0); //point in quadrant 1
   private static final PointT quad2 = new PointT(2.0*xmax/3.0, ymax/6.0); //point in quadrant 2
   private static final PointT quad3 = new PointT(9.0*xmax/10.0, 4.0*ymax/5.0); //point in quadrant 3
   private static final PointT quad4 = new PointT(xmax/4.0, 5.0*ymax/6.0); //point in quadrant 4

   /***************************************************************/

   @Test
   public void testTotalDistance_ZeroPointPath()
   {
     PathT p = ZeroPointPath();
     assertEquals(0.0, PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_ZeroPointPath()
   {
     PathT p = ZeroPointPath();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_ZeroPointPath()
   {
     PathT p = ZeroPointPath();
     assertEquals(0, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_OnePointPath()
   {
     PathT p = OnePointPath();
     assertEquals(0.0, PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_OnePointPath()
   {
     PathT p = OnePointPath();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_OnePointPath()
   {
     PathT p = OnePointPath();
     assertEquals(0.0, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_TwoPointPath()
   {
     PathT p = TwoPointPath();
     assertEquals(p.getval(0).dist(p.getval(1)), PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_TwoPointPath()
   {
     PathT p = TwoPointPath();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_TwoPointPath()
   {
     PathT p = TwoPointPath();
     assertEquals(p.getval(0).dist(p.getval(1))/Constants.VELOCITY_LINEAR, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_TwoCoincidentPointPath()
   {
     PathT p = TwoCoincidentPointPath();
     assertEquals(0.0, PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_TwoCoincidentPointPath()
   {
     PathT p = TwoCoincidentPointPath();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_TwoCoincidentPointPath()
   {
     PathT p = TwoCoincidentPointPath();
     assertEquals(0.0, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_ThreeCoincidentPointPath()
   {
     PathT p = ThreeCoincidentPointPath();
     assertEquals(0.0, PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_ThreeCoincidentPointPath()
   {
     PathT p = ThreeCoincidentPointPath();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_ThreeCoincidentPointPath()
   {
     PathT p = ThreeCoincidentPointPath();
     assertEquals(0.0, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_ThreePointPathNoTurns()
   {
     PathT p = ThreePointPathNoTurns();
     assertEquals(Math.sqrt(xmax*xmax + ymax*ymax), PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_ThreePointPathNoTurns()
   {
     PathT p = ThreePointPathNoTurns();
     assertEquals(0, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_ThreePointPathNoTurns()
   {
     PathT p = ThreePointPathNoTurns();
     assertEquals(Math.sqrt(xmax*xmax + ymax*ymax)/Constants.VELOCITY_LINEAR, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_ThreePointPathOneTurn()
   {
     PathT p = ThreePointPathOneTurn();
     assertEquals(2.0*Math.sqrt(xmax*xmax + ymax*ymax), PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_ThreePointPathOneTurn()
   {
     PathT p = ThreePointPathOneTurn();
     assertEquals(1, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_ThreePointPathOneTurn()
   {
     PathT p = ThreePointPathOneTurn();
     assertEquals(2.0*Math.sqrt(xmax*xmax + ymax*ymax)/Constants.VELOCITY_LINEAR + Math.PI/Constants.VELOCITY_ANGULAR, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalDistance_FivePointPath()
   {
     PathT p = FivePointPath();
     assertEquals(2.0*(xmax+ymax), PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_FivePointPath()
   {
     PathT p = FivePointPath();
     assertEquals(3, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_FivePointPath()
   {
     PathT p = FivePointPath();
     assertEquals(2.0*(xmax+ymax)/Constants.VELOCITY_LINEAR + (3*Math.PI/2)/Constants.VELOCITY_ANGULAR, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   @Test
   public void testTotalTurns_ComplexPath()
   {
     PathT p = ComplexPath();
     assertEquals(8, PathCalculation.totalTurns(p));
   }


   /***************************************************************/
   @Test
   public void testTotalDistance_FullPath()
   {
     PathT p = FullPath();
     assertEquals(24*(2.0*(xmax+ymax))+xmax+2*ymax, PathCalculation.totalDistance(p), ADMISS_ERR);
   }

   @Test
   public void testTotalTurns_FullPath()
   {
     PathT p = FullPath();
     assertEquals(98, PathCalculation.totalTurns(p));
   }

   @Test
   public void testTotalEstTime_FullPath()
   {
     PathT p = FullPath();
     assertEquals((24*(2.0*(xmax+ymax))+xmax+2*ymax)/Constants.VELOCITY_LINEAR + (98*Math.PI/2)/Constants.VELOCITY_ANGULAR, PathCalculation.estimatedTime(p), ADMISS_ERR);
   }

   /***************************************************************/

   /* Functions to build different shaped paths */

   /***************************************************************/

   private PathT ZeroPointPath()
   {
     PathT p = new PathT();
     return p;
   }

   private PathT OnePointPath()
   {
     PathT p = new PathT();
     p.add(0, centre);
     return p;
   }

   private PathT TwoPointPath()
   {
     PathT p = new PathT();
     p.add(0, centre);
     p.add(1, quad3);
     return p;
   }

   private PathT TwoCoincidentPointPath()
   {
     PathT p = new PathT();
     p.add(0, centre);
     p.add(1, centre);
     return p;
   }

   private PathT ThreeCoincidentPointPath()
   {
     PathT p = new PathT();
     p.add(0, centre);
     p.add(1, centre);
     p.add(2, centre);
     return p;
   }

   private PathT ThreePointPathNoTurns()
   {
     PathT p = new PathT();
     p.add(0, ll);
     p.add(1, centre);
     p.add(2, ur);
     return p;
   }

   private PathT ThreePointPathOneTurn()
   {
     PathT p = new PathT();
     p.add(0, ll);
     p.add(1, ur);
     p.add(2, ll);
     return p;
   }

   private PathT FivePointPath()
   {
     p = new PathT();
     p.add(0, ll);
     p.add(1, lr);
     p.add(2, ur);
     p.add(3, ul);
     p.add(4, ll);
     return p;
   }

   private PathT ComplexPath()
   {
     p = new PathT();
     p.add(0, ll);
     p.add(1, quad1);
     p.add(2, quad2);
     p.add(3, lr);
     p.add(4, quad3);
     p.add(5, ur);
     p.add(6, centre);     
     p.add(7, quad4);
     p.add(8, ul);
     p.add(9, ll);
     return p;
   }

   private PathT FullPath()
   {
     int i;
     p = new PathT();

     for (i=0; i < p.MAX_SIZE; i = i+4)
     {
       p.add(i, ll);
       p.add(i+1, lr);
       p.add(i+2, ur);
       p.add(i+3, ul);
     }
     return p;
   }

}
