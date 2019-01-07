/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Testing RegionT Class
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestRegionT
{

   private PointT p;
   private RegionT r;
   private final static double WIDTH = 20.0;
   private final static double HEIGHT = 10.0;

   @Before
   public void setUp()
   {
     p = new PointT(Constants.MAX_X/2.0, Constants.MAX_Y/2.0);
     r = new RegionT(p, WIDTH, HEIGHT);
   }

   @After
   public void tearDown()
   {
     p = null;
     r = null;
   }

   @Test (expected=InvalidRegionException.class)
   public void testForExceptionWidthLessThanZero()
   {
     r = new RegionT(p, -10, 10);
   }

   @Test (expected=InvalidRegionException.class)
   public void testForExceptionHeightLessThanZero()
   {
     r = new RegionT(p, 10, -10);
   }

   @Test (expected=InvalidRegionException.class)
   public void testForExceptionOutsideRangeInXDirection()
   {
     r = new RegionT(p, Constants.MAX_X, 10);
   }

   @Test (expected=InvalidRegionException.class)
   public void testForExceptionOutsideRangeInYDirection()
   {
     r = new RegionT(p, 10, Constants.MAX_Y);
   }

   @Test
   public void testPointInRegionCase1True()
   {
     PointT ptest = new PointT(p.xcrd()-Constants.TOLERANCE/2.0, p.ycrd()-Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase1False()
   {
     PointT ptest = new PointT(p.xcrd()-Constants.TOLERANCE, p.ycrd()-Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase2True()
   {
     PointT ptest = new PointT(p.xcrd()-Constants.TOLERANCE/2.0, p.ycrd()+HEIGHT/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase2False()
   {
     PointT ptest = new PointT(p.xcrd()-2*Constants.TOLERANCE, p.ycrd()+HEIGHT/2.0);
     assertFalse(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase3True()
   {
     PointT ptest = new PointT(p.xcrd()-Constants.TOLERANCE/2.0, p.ycrd()+Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase3False()
   {
     PointT ptest = new PointT(p.xcrd()-Constants.TOLERANCE, p.ycrd()+HEIGHT+Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase4True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH/2.0, p.ycrd()-Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase4False()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH/2.0, p.ycrd()-2*Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase5True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH/2.0, p.ycrd()+HEIGHT/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   public void testPointInRegionCase6True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH/2.0, p.ycrd()+HEIGHT+Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase6False()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH/2.0, p.ycrd()+HEIGHT+2*Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }

   public void testPointInRegionCase7True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+Constants.TOLERANCE/2.0, p.ycrd()-Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase7False()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+Constants.TOLERANCE, p.ycrd()-Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }

   public void testPointInRegionCase8True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+Constants.TOLERANCE/2.0, p.ycrd()+HEIGHT/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase8False()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+2.0*Constants.TOLERANCE, p.ycrd()+HEIGHT/2.0);
     assertFalse(r.pointInRegion(ptest));
   }

   public void testPointInRegionCase9True()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+Constants.TOLERANCE/2.0, p.ycrd()+HEIGHT+Constants.TOLERANCE/2.0);
     assertTrue(r.pointInRegion(ptest));
   }

   @Test
   public void testPointInRegionCase9False()
   {
     PointT ptest = new PointT(p.xcrd()+WIDTH+Constants.TOLERANCE, p.ycrd()+HEIGHT+Constants.TOLERANCE);
     assertFalse(r.pointInRegion(ptest));
   }
}
