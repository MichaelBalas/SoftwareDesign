## @file Statistics.py
#  @author Michael Balas
#  @brief Provides statistics functions for the CircleT class
#  @date 12/30/2018

import numpy
from CircleADT import *

## @brief Calculates the average radius of a list of circles
#  @param circles List of CircleT
#  @return Average radius of the list of CircleT
def average(circles):
  radii = [c.radius() for c in circles]
  return numpy.average(radii)

## @brief Calculates the standard deviation of the radii of a list of circles
#  @param circles List of CircleT
#  @return Standard deviation of the radii of the list of CircleT  
def stdDev(circles):
  radii = [c.radius() for c in circles]
  return numpy.std(radii)

## @brief Ranks a list of circles by radius
#  @details Given a list of n circles, this function provides a list of integer 
#           rankings 1 through n that rank the circles by radius (descending).
#           The positions of the ranks in the returned list correspond to the 
#           positions of the circles in the list of circles.  In the case of ties,
#           the dense ranking scheme (as defined at https://en.wikipedia.org/wiki/Ranking)
#           is used.
#  @param circles List of CircleT
#  @return List of rankings 
def rank(circles):
  radii = [c.radius() for c in circles]
  vsmall = float("-inf")
  ranking = [0 for x in radii]
  rank_curr = 0
  for i in range(len(radii)):
    m_curr = max(radii)
    j = radii.index(m_curr)
    if rank_curr == 0 or m_curr != m_prev:
      rank_curr += 1
    ranking[j] = rank_curr
    radii[j] = vsmall
    m_prev = m_curr
  return ranking
