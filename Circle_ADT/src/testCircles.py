from CircleADT import *
from Statistics import *

from math import sqrt

# for testing floating point equality after arithmetic
# from Python development documentation: 
#   https://www.python.org/dev/peps/pep-0485/#proposed-implementation
def isClose(a, b, rel_tol = 1e-09, abs_tol = 0.0):
    return abs(a - b) <= max(rel_tol * max(abs(a), abs(b)), abs_tol)

# @brief Tests the xcoord method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT xcoord method
def test_xcoord():
  global testTot, passed
  testTot += 1
  try:
    assert c1.xcoord() == 1
    assert c2.xcoord() == -3
    assert c3.xcoord() == -2
    assert c4.xcoord() == 1e-10
    assert c5.xcoord() == 1e10
    passed += 1
    print("xcoord test PASSED.")
  except AssertionError:
    print("xcoord test FAILED.")

# @brief Tests the ycoord method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT ycoord method    
def test_ycoord():
  global testTot, passed
  testTot += 1
  try:
    assert c1.ycoord() == 0
    assert c2.ycoord() == -5
    assert c3.ycoord() == 5
    assert c4.ycoord() == 1e-10
    assert c5.ycoord() == 1e10
    passed += 1
    print("ycoord test PASSED.")
  except AssertionError:
    print("ycoord test FAILED.")

# @brief Tests the radius method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT radius method    
def test_radius():
  global testTot, passed
  testTot += 1
  try:
    assert c1.radius() == 2
    assert c2.radius() == 5.25
    assert c3.radius() == 10
    assert c4.radius() == 1e-10
    assert c5.radius() == 1e10
    passed += 1
    print("radius test PASSED.")
  except AssertionError:
    print("radius test FAILED.")

# @brief Tests the area method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT area method
def test_area():
  global testTot, passed
  testTot += 1
  try:
    assert isClose(c1.area(), 12.566370614359172953850573533118)
    assert isClose(c2.area(), 86.590147514568676135126608251641)
    assert isClose(c3.area(), 314.15926535897932384626433832795)
    assert isClose(c4.area(), 3.1415926535897932384626433832795e-20)
    assert isClose(c5.area(), 3.1415926535897932384626433832795e20)
    passed += 1
    print("area test PASSED.")
  except AssertionError:
    print("area test FAILED.")

# @brief Tests the circumference method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT circumference method
def test_circumference():
  global testTot, passed
  testTot += 1
  try:
    assert isClose(c1.circumference(), 12.566370614359172953850573533118)
    assert isClose(c2.circumference(), 32.986722862692829003857755524435)
    assert isClose(c3.circumference(), 62.83185307179586476925286766559)
    assert isClose(c4.circumference(), 6.283185307179586476925286766559e-10)
    assert isClose(c5.circumference(), 6.283185307179586476925286766559e10)
    passed += 1
    print("circumference test PASSED.")
  except AssertionError:
    print("circumference test FAILED.")

# @brief Tests the insideBox method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT insideBox method.  One of the tests covers the edge 
#          case in which the edge of the circle and the edge of the box 
#          are touching. 
def test_insideBox():
  global testTot, passed
  testTot += 1
  x = -12
  y = 100
  w = 20
  h = 110
  try:
    assert c1.insideBox(x, y, w, h)
    assert not c2.insideBox(x, y, w, h)
    assert c3.insideBox(x, y, w, h)
    assert c4.insideBox(x, y, w, h)
    assert not c5.insideBox(x, y, w, h)
    passed += 1
    print("insideBox test PASSED.")
  except AssertionError:
    print("insideBox test FAILED.")

# @brief Tests the intersect method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the CircleT intersect method.  One of the tests covers the edge 
#          case in which the edges of the circles are touching.   
def test_intersect():
  global testTot, passed
  testTot += 1
  ct = CircleT(1,1,sqrt(2))
  try:
    assert c1.intersect(ct)
    assert not c2.intersect(ct)
    assert c3.intersect(ct)
    assert c4.intersect(ct)
    assert not c5.intersect(ct)
    passed += 1
    print("intersect test PASSED.")
  except AssertionError:
    print("intersect test FAILED.")

# @brief Tests the scale method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the radius of CircleT objects after scale has been called.
def test_scale():
  global testTot, passed
  testTot += 1
  # use new local circles since they will be mutated
  c1 = CircleT(1,0,2)
  c2 = CircleT(-3,-5,5.25)
  c3 = CircleT(-2,5,10)
  c4 = CircleT(1e-10,1e-10,1e-10)
  c5 = CircleT(1e10,1e10,1e10)
  c1.scale(1)
  c2.scale(2)
  c3.scale(10)
  c4.scale(1e-10)
  c5.scale(1e10)
  try:
    assert isClose(c1.radius(), 2)
    assert isClose(c2.radius(), 10.5)
    assert isClose(c3.radius(), 100)
    assert isClose(c4.radius(), 1e-20)
    assert isClose(c5.radius(), 1e20)
    passed += 1
    print("scale test PASSED.")
  except AssertionError:
    print("scale test FAILED.")

# @brief Tests the translate method of the CircleT class
# @details Checks for equality between actual and expected values for
#          the x and y coordinates of CircleT objects after translate 
#          has been called.
def test_translate():
  global testTot, passed
  testTot += 1
  # use new local circles since they will be mutated
  c1 = CircleT(1,0,2)
  c2 = CircleT(-3,-5,5.25)
  c3 = CircleT(-2,5,10)
  c4 = CircleT(1e-10,1e-10,1e-10)
  c5 = CircleT(1e10,1e10,1e10)
  c1.translate(0,0)
  c2.translate(1,1)
  c3.translate(-5,10)
  c4.translate(1e-10, -1e-10)
  c5.translate(-1e10, -1e10)
  try:
    assert c1.xcoord() == 1 and c1.ycoord() == 0
    assert c2.xcoord() == -2 and c2.ycoord() == -4
    assert c3.xcoord() == -7 and c3.ycoord() == 15
    assert c4.xcoord() == 2e-10 and c4.ycoord() == 0
    assert c5.xcoord() == 0 and c5.ycoord() == 0
    passed += 1
    print("translate test PASSED.")
  except AssertionError:
    print("translate test FAILED.")

# @brief Tests the average function of the Statistics module
# @details Checks for equality between actual and expected values for
#          the output of the Statistics average function on a list of CircleT.
def test_average():
  global testTot, passed
  testTot += 1
  try:
    assert isClose(average(circles), 2000000003.45)
    passed += 1
    print("average test PASSED.")
  except AssertionError:
    print("average test FAILED.")

# @brief Tests the stdDev function of the Statistics module
# @details Checks for equality between actual and expected values for
#          the output of the Statistics stdDev function on a list of CircleT.    
def test_stdDev():
  global testTot, passed
  testTot += 1
  try:
    assert isClose(stdDev(circles), 3999999998.275)
    passed += 1
    print("stdDev test PASSED.")
  except AssertionError:
    print("stdDev test FAILED.")     
 
# @brief Tests the rank function of the Statistics module
# @details Checks for equality between actual and expected values for
#          the output of the Statistics rank function on a list of CircleT. 
#          Two circles with the same radius are included in the list to
#          cover the edge case in which the ranked list has ties.
def test_rank():
  global testTot, passed
  testTot += 1
  rankCircles = circles
  rankCircles.append(c1) # for testing ties
  try:
    assert rank(circles) == [4,3,2,5,1,4]
    passed += 1
    print("rank test PASSED.")
  except AssertionError:
    print("rank test FAILED.") 
      
c1 = CircleT(1,0,2)
c2 = CircleT(-3,-5,5.25)
c3 = CircleT(-2,5,10)
c4 = CircleT(1e-10,1e-10,1e-10)
c5 = CircleT(1e10,1e10,1e10)

circles = [c1,c2,c3,c4,c5]

testTot = 0
passed = 0

test_xcoord()
test_ycoord()
test_radius()
test_area()
test_circumference()
test_insideBox()
test_intersect()
test_scale()
test_translate()
test_average()
test_stdDev()
test_rank()

print ('\n%d of %d tests passed.') % (passed, testTot)