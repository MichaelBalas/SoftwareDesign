## @file CircleADT.py
#  @author Michael Balas
#  @brief Provides the CircleT ADT class for representing circles
#  @date 12/30/2018

from math import pi, sqrt

## @brief An ADT that represents a circle
class CircleT:

  ## @brief CircleT constructor
  #  @details Initializes a CircleT object with a cartesian coordinate center
  #           and a radius
  #  @param x The x coordinate of the circle center
  #  @param y The y coordinate of the circle center
  #  @param r The radius of the circle
  #  @exception ValueError Throws if supplied radius is negative
  def __init__(self, x, y, r):
    if(r < 0):
      raise ValueError("Radius cannot be negative")
    self.__x = x
    self.__y = y
    self.__r = r
  
  ## @brief Gets the x coordinate of the circle center
  #  @return The x coordinate of the circle center
  def xcoord(self):
    return self.__x
    
  ## @brief Gets the y coordinate of the circle center
  #  @return The y coordinate of the circle center
  def ycoord(self):
    return self.__y

  ## @brief Gets the radius of the circle
  #  @return The radius of the circle  
  def radius(self):
    return self.__r
    
  ## @brief Calculates the area of the circle
  #  @return The area of the circle
  def area(self):
    return pi * self.__r ** 2

  ## @brief Calculates the circumference of the circle
  #  @return The circumference of the circle
  def circumference(self):
    return 2 * pi * self.__r
    
  ## @brief Determines if circle is contained within a box
  #  @details The circles edges may overlap with
  #           the bounds of the box and still be considered contained.
  #  @param x x coordinate of top left corner of box
  #  @param y y coordinate of top left corner of box
  #  @param w Width of box
  #  @param h Height of box
  #  @return Returns true if the circle is contained within the box; false if not
  def insideBox(self, x, y, w, h):
    left = x <= (self.__x - self.__r)
    right = (x + w) >= (self.__x + self.__r)
    top = y >= (self.__y + self.__r)
    bot = (y - h) <= (self.__y - self.__r)
    return left and right and top and bot

  ## @brief Determines whether the circle intersects another circle
  #  @details This function treats circles as filled objects: circles completely
  #           inside other circles are considered as intersecting, even though
  #           their edges do not cross.  The set of points in each circle
  #           includes the boundary (closed sets).
  #  @param c Circle to test intersection with
  #  @return Returns true if the circles intersect; false if not  
  def intersect(self, c):
    xDist = self.__x - c.xcoord()
    yDist = self.__y - c.ycoord()
    centerDist = sqrt(xDist ** 2 + yDist ** 2)
    rSum = self.__r + c.radius()
    return rSum >= centerDist
  
  ## @brief Scales the radius of the circle
  #  @param k Scaling factor
  def scale(self, k):
    self.__r *= k
    
  ## @brief Translates the center of the circle
  #  @param dx Distance to translate the center x coordinate
  #  @param dy Distance to translate the center y coordinate
  def translate(self, dx, dy):
    self.__x += dx
    self.__y += dy
    
