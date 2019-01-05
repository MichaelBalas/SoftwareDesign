## @file testCircleDeque.py
#  @author Michael Balas
#  @brief Implements 25 Pyunit tests
#  @date 2 Jan 2019

import unittest
import math
from pointADT import *
from lineADT import *
from circleADT import *
from deque import *

class PointTest(unittest.TestCase):

    def setUp(self):
        ## Declaring Points
        self.p1 = PointT(1.5,2)
        self.p2 = PointT(-1.5,6)
        self.p3 = PointT(-1.5,10)

        ## Declaring Line
        self.l1 = LineT(self.p1,self.p2)

        ## Declaring Circles
        self.c1 = CircleT(self.p1,5)
        self.c2 = CircleT(self.p2,7.5)        
        self.c3 = CircleT(self.p3,3)
        self.c4 = CircleT(self.p3,math.sqrt(73)-5)

        ## Declaring force lambda functions
        self.f1 = lambda x: x
        self.f2 = lambda x: 5/(x**2)


    def tearDown(self):
        self.p1 = None
        self.p2 = None
        self.l1 = None
        self.c1 = None
        self.c2 = None
        self.c3 = None
        self.c4 = None

    ## Point Testing
    ## @brief Tests xcrd method of PointT class
    def test_xcrd(self):
        self.assertTrue(self.p1.xcrd() == 1.5)
        self.assertTrue(self.p2.xcrd() == -1.5)

    ## @brief Tests ycrd method of PointT class
    def test_ycrd(self):
        self.assertTrue(self.p1.ycrd() == 2)
        self.assertTrue(self.p2.ycrd() == 6)

    ## @brief Tests dist method of PointT class
    def test_dist(self):
        self.assertTrue(self.p1.dist(self.p2) == 5)

    ## @brief Tests rot method of PointT class
    def test_rot1(self):
        #90 degrees rotation
        self.p1.rot(math.pi/2)
        self.assertAlmostEqual(self.p1.xcrd(),-2,None,None,0.0001)
        self.assertAlmostEqual(self.p1.ycrd(),1.5,None,None,0.0001)

    ## @brief Tests rot method of PointT class
    def test_rot2(self):
        #180 degrees rotation
        self.p2.rot(math.pi)
        self.assertAlmostEqual(self.p2.xcrd(),1.5,None,None,0.0001)
        self.assertAlmostEqual(self.p2.ycrd(),-6,None,None,0.0001)


    ## Line Testing
    ## @brief Tests beg method of LineT class
    def test_beg(self):
        self.assertTrue([self.l1.beg().xcrd(),self.l1.beg().ycrd()] == [1.5,2])

    ## @brief Tests end method of LineT class
    def test_end(self):
        self.assertTrue([self.l1.end().xcrd(),self.l1.end().ycrd()] == [-1.5,6])

    ## @brief Tests len method of LineT class
    def test_len(self):
        self.assertTrue(self.l1.len() == 5)
        
    ## @brief Tests mdpt method of LineT class
    def test_mdpt(self):
        self.assertTrue(self.l1.mdpt().xcrd() == 0)
        self.assertTrue(self.l1.mdpt().ycrd() == 4)

    ## @brief Tests rot method of LineT class
    def test_rot(self):
        #180 degrees rotation
        self.l1.rot(math.pi)
        self.assertAlmostEqual(self.p1.xcrd(),-1.5,None,None,0.0001)
        self.assertAlmostEqual(self.p1.ycrd(),-2,None,None,0.0001)
        self.assertAlmostEqual(self.p2.xcrd(),1.5,None,None,0.0001)
        self.assertAlmostEqual(self.p2.ycrd(),-6,None,None,0.0001)


    ## Circle Testing
    ## @brief Tests cen method of CircleT class
    def test_cen(self):
        self.assertTrue([self.c1.cen().xcrd(),self.c1.cen().ycrd()] == [1.5,2])
        self.assertTrue([self.c2.cen().xcrd(),self.c2.cen().ycrd()] == [-1.5,6])

    ## @brief Tests rad method of CircleT class
    def test_rad(self):
        self.assertTrue(self.c1.rad() == 5)
        self.assertTrue(self.c2.rad() == 7.5)

    ## @brief Tests area method of CircleT class
    def test_area(self):
        self.assertAlmostEqual(self.c1.area(),math.pi*5**2,None,None,0.0001)
        self.assertAlmostEqual(self.c2.area(),math.pi*7.5**2,None,None,0.0001)

    ## @brief Tests intersect method of CircleT class
    def test_intersect(self):
        #Intersecting
        self.assertTrue(self.c1.intersect(self.c2) == True)
        #Not intersecting
        self.assertFalse(self.c1.intersect(self.c3) == True)
        #Intersecting at boundary
        self.assertTrue(self.c1.intersect(self.c4) == True)

    ## @brief Tests connection method of CircleT class
    def test_connection(self):
        self.assertTrue(self.c1.connection(self.c2).beg().xcrd() == 1.5)
        self.assertTrue(self.c1.connection(self.c2).beg().ycrd() == 2)

    ## @brief Tests force method of CircleT class
    def test_force(self):
        self.assertAlmostEqual(self.c1.force(self.f1)(self.c2),(math.pi**2)*(5**2)*(7.5**2)*(5),None,None,0.0001)


    ## Deque Testing
    ## @brief Tests pushFront method of Deq class
    def test_pushFront(self):
        Deq.init()
        Deq.pushFront(self.c1)
        self.assertTrue(Deq.front() == self.c1)
        self.assertTrue(Deq.front() == Deq.back())
        for i in range(0,Deq.MAX_SIZE-1):
            Deq.pushFront(self.c2)
        self.assertRaises(Exception,Deq.pushFront,self.c3)

    ## @brief Tests pushBack method of Deq class
    def test_pushBack(self):
        Deq.init()
        Deq.pushBack(self.c1)
        self.assertTrue(Deq.back() == self.c1)
        self.assertTrue(Deq.back() == Deq.front())
        for i in range(0,Deq.MAX_SIZE-1):
            Deq.pushBack(self.c2)
        self.assertRaises(Exception,Deq.pushBack,self.c3)

    ## @brief Tests popFront method of Deq class
    def test_popFront(self):
        Deq.init()
        Deq.pushFront(self.c1)
        Deq.pushFront(self.c2)
        Deq.popFront()
        self.assertTrue(Deq.front() == self.c1)

    ## @brief Tests popBack method of Deq class
    def test_popBack(self):
        Deq.init()
        Deq.pushBack(self.c1)
        Deq.pushBack(self.c2)
        Deq.popBack()
        self.assertTrue(Deq.back() == self.c1)

    ## @brief Tests front method of Deq class
    def test_front(self):
        Deq.init()
        self.assertRaises(Exception,Deq.front)

    ## @brief Tests back method of Deq class
    def test_back(self):
        Deq.init()
        self.assertRaises(Exception,Deq.back)

    ## @brief Tests size method of Deq class
    def test_size(self):
        Deq.init()
        self.assertTrue(Deq.size() == 0)
        Deq.pushFront(self.c1)
        self.assertTrue(Deq.size() == 1)
        Deq.popBack()
        self.assertTrue(Deq.size() == 0)

    ## @brief Tests disjoint method of Deq class
    def test_disjoint(self):
        Deq.init()
        Deq.pushFront(self.c1)
        self.assertTrue(Deq.disjoint())
        #Intersecting at boundary
        Deq.pushBack(self.c4)
        self.assertFalse(Deq.disjoint())
        Deq.popBack()
        #Not intersecting
        Deq.pushBack(self.c3)
        self.assertTrue(Deq.disjoint())

    ## @brief Tests sumFx method of Deq class
    def test_sumFx(self):
        Deq.init()
        #Empty Deq
        self.assertRaises(Exception, Deq.sumFx, self.f2)
        #Push c1
        Deq.pushFront(self.c1)
        self.assertTrue(Deq.sumFx(self.f2) == 0)
        #Push c2
        Deq.pushBack(self.c2)
        self.assertAlmostEqual(Deq.sumFx(self.f2),-1665.495742,None,None,0.0001)
        #Push c3
        Deq.pushBack(self.c3)
        self.assertAlmostEqual(Deq.sumFx(self.f2),-1718.901641,None,None,0.0001)
        #Push c4
        Deq.pushBack(self.c4)
        self.assertAlmostEqual(Deq.sumFx(self.f2),-1793.432319,None,None,0.0001)


if __name__ == '__main__':
    unittest.main()
