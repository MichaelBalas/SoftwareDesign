## @file pointADT.py
#  @author Michael Balas
#  @brief Provides the PointT ADT class for representing 2D points
#  @date 2 Jan 2019

from math import *

##@brief An ADT that respresents a 2D point
class PointT:

    ## @brief PointT constructor
    #  @details Initializes a PointT object with a cartesian coordinate
    #  @param x The x coordinate of the point
    #  @param y The y coordinate of the point
    def __init__(self, x, y):
        self.xc = x
        self.yc = y

    ## @brief Gets the x coordinate of the point
    #  @return The x coordinate of the point
    def xcrd(self):
        return self.xc

    ## @brief Gets the y coordinate of the point
    #  @return The y coordinate of the point
    def ycrd(self):
        return self.yc

     ## @brief Determines the distance between 2 points
     #  @details Uses pythagorean theorem
     #  @param p Another point
     #  @return The distance between the given points
    def dist(self, p):
        xDist = self.xc - p.xcrd()
        yDist = self.yc - p.ycrd()
        return sqrt(xDist ** 2 + yDist ** 2)

     ## @brief Sets the new coordinates after rotation
     #  @details Rotates the point around the origin by angle of phi radians
     #  @para phi angle of rotation in radians
    def rot(self, phi):
        xc_old = self.xc
        self.xc = cos(phi)*self.xc - sin(phi)*self.yc
        self.yc = sin(phi)*xc_old + cos(phi)*self.yc
        
