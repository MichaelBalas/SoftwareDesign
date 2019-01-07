/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Testing PathT Class
 */

import org.junit.*;
import static org.junit.Assert.*;

public class TestPathT
{

   private PathT p;

   @Before
   public void setUp()
   {
     p = new PathT();
   }

   @After
   public void tearDown()
   {
     p = null;
   }

   @Test 
   public void testAdd()
   {
     p.add(0, new PointT(0,0));
     assertEquals(1, p.size());
   }

   @Test (expected=InvalidPositionException.class)
   public void testInvalidPositionExceptionNegativePosition()
   {
     p.add(-7, new PointT(0,0));
   }

   @Test (expected=InvalidPositionException.class)
   public void testInvalidPositionExceptionTooLargePosition()
   {
     p.add(1, new PointT(0,0));
   }

   @Test (expected=FullSequenceException.class)
   public void testFullSequenceExceptionAddToFullList()
   {
     int i;
     for (i = 0; i < p.MAX_SIZE; i++)
     {
       p.add(i, new PointT(0,0));
     }
     p.add(p.MAX_SIZE, new PointT(0,0));
   }

   @Test
   public void testDeleteLastPositionFullList()
   {
     int i;
     for (i = 0; i < p.MAX_SIZE; i++)
     {
       p.add(i, new PointT(0,0));
     }
     p.del(p.MAX_SIZE-1);
     assertEquals(p.MAX_SIZE-1, p.size());
   }

}
