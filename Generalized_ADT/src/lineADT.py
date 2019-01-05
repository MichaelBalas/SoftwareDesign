## @file lineADT.py
#  @author Michael Balas
#  @brief Provides the LineT ADT class for representing a line in 2D
#  @date 2 Jan 2019

from pointADT import *

##@brief An ADT that respresents a line in 2D
class LineT:

  ## @brief LineT constructor
  #  @details Initializes a LineT object with 2 points
  #  @param p1 The start point of line
  #  @param p2 The end point of line
  def __init__(self, p1, p2):
    self.b = p1
    self.e = p2
    
  ## @brief Gets the beginning of the line
  #  @return The start point of line
  def beg(self):
    return self.b

  ## @brief Gets the ending of the line
  #  @return The end point of line
  def end(self):
    return self.e

  ## @brief Gets the length of the line
  #  @return The length of line
  def len(self):
    return self.b.dist(self.e)

  ## @brief Determines the midpoint of the line
  #  @return The midpoint point of line
  def mdpt(self):
    return PointT((self.b.xcrd()+self.e.xcrd())/2.0, (self.b.ycrd()+self.e.ycrd())/2.0)

  def __avg__(self, x1, x2): #not necessary, for illustrative purposes
      return (x1+x2)/2.0

  ## @brief Sets the new points of the line after rotation
  #  @details Rotates the line around the origin by angle of phi radians
  #  @para phi angle of rotation in radians
  def rot(self, phi):
    self.b.rot(phi)
    self.e.rot(phi)

def __avg__(x1, x2): #not necessary, for illustrative purposes
    return (x1+x2)/2.0
  
    
