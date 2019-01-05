## @file lineADT.py
#  @author Michael Balas
#  @brief Provides the CircleT ADT class for representing a circle
#  @date 2 Jan 2019

from math import *
from pointADT import *
from lineADT import *

##@brief An ADT that respresents a circle
class CircleT:

  ## @brief CircleT constructor
  #  @details Initializes a CircleT object using a center point and radius
  #  @param p1 The center point of the circle
  #  @param p2 The radius of the circle
  def __init__(self, cin, rin):
    self.c = cin
    self.r = rin

  ## @brief Gets the center point of the circle
  #  @return The center point of circle
  def cen(self):
    return self.c
  #  return PointT(self.c.xcrd(), self.c.ycrd()) #to return a new point

  ## @brief Gets the radius of the circle
  #  @return The radius circle
  def rad(self):
    return self.r

  ## @brief Gets the area of the circle
  #  @return The area of circle
  def area(self):
    return pi*(self.rad())**2.0

  ## @brief Determines if 2 circles intersect
  #  @details Finds if the 2 circles overlap or touch
  #  @param cin Second circle
  #  @return Returns true if 2 circles intersect, false otherwise
  def intersect(self, cin):
    centerDist = self.connection(cin).len()
    rSum = self.r + cin.rad()
    return rSum >= centerDist

  ## @brief Determines a line from the center of 1st circle to the center of the 2nd circle
  #  @details The length of the line is the distance between the circle center points
  #  @param cin Second circle
  #  @return The line between circle center points
  def connection(self, cin):
    return LineT(self.c, cin.cen())

  ## @brief Determines the force between 2 circles
  #  @details Uses the force formula
  #  @param f function
  #  @return The force between the 2 circles
  def force(self, f):
    return lambda c: self.area()*c.area()*f(self.connection(c).len())
