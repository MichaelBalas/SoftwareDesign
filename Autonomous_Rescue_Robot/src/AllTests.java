/**
 * Author: Michael Balas
 * Revised: Jan 2, 2019
 * 
 * Description: Testing all of the map and path related modules
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   TestRegionT.class,
   TestPathT.class,
   TestPathCalculation.class
})

public class AllTests
{
}
