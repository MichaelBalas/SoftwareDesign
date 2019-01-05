## @file deque.py
#  @author Michael Balas
#  @brief Implements an abstract object for a deque (double ended queue) of circles
#  @date 2 Jan 2019

from circleADT import *

## @brief An Abstract Object that represents a sequence
class Deq:
  # maximum size of deque is 20
  MAX_SIZE = 20

  # empty sequence
  s = []
  
  ## @brief Deque initializer
  @staticmethod
  def init():
    Deq.s = []
    
  ## @brief insert element at back
  @staticmethod
  def pushBack(c):
    if len(Deq.s) == Deq.MAX_SIZE:
      raise FULL("Maximum size exceeded")
    Deq.s = Deq.s + [c]

  ## @brief insert element at front
  @staticmethod
  def pushFront(c):
    if len(Deq.s) == Deq.MAX_SIZE:
      raise FULL("Maximum size exceeded")
    Deq.s = [c] + Deq.s

  ## @brief removes element at back
  @staticmethod
  def popBack():
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    Deq.s = Deq.s[0:(size-1)]

  ## @brief insert element at front
  @staticmethod
  def popFront():
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    Deq.s = Deq.s[1:size]

  ## @brief Gets last element
  #  @return The last element of deque
  @staticmethod
  def back():
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    return Deq.s[size-1]

  ## @brief Gets first element
  #  @return The first element of deque
  @staticmethod
  def front():
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    return Deq.s[0]

  ## @brief Gets length of deque
  #  @return The last element of deque
  @staticmethod
  def size():
    return len(Deq.s)
  
  ## @brief Determines if the sequence of circles are disjoint
  #  @details Finds if any of the sequence of circles intersect with each other
  #  @return Returns true if no circles in the deque intersect, false otherwise
  @staticmethod
  def disjoint():
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    djoint = True
    for i in range(0, size):
      for j in range(0, size):
        if i != j:
          djoint = djoint and not(Deq.s[i].intersect(Deq.s[j]))
#    return djoint #calculated the conventional way
    return reduce(lambda x, y: x and y, \
                  [not(Deq.s[i].intersect(Deq.s[j])) for i in \
                   range(size) for j in range(size) if i != j],\
                  True) #calculated with the functional way

  ## @brief Determines sum of forces in the x component acting on first circle in the sequence
  #  @return Returns the sum of forces in the x component acting on first circle in the sequence
  @staticmethod
  def sumFx(f):
    size = len(Deq.s)
    if size == 0:
      raise EMPTY("Deque is empty")
    total = 0.0
    for i in range(1, size):
      total = total + __xcomp__(Deq.s[i].force(f)(Deq.s[0]), Deq.s[i], Deq.s[0])

    #return total #calculated the conventional way
    return reduce(lambda a, i: a + __xcomp__(Deq.s[i].force(f)(Deq.s[0]), Deq.s[i], Deq.s[0]), range(1, size), 0.0)
           #calculated with the functional way

## @brief Determines the x component of Force between 2 circles
#  @param F force between circles
#  @param ci first circle 
#  @param cj second circle
#  @return Returns the x component of Force between 2 circles
def __xcomp__(F, ci, cj):
  return F*(ci.cen().xcrd() - cj.cen().xcrd())/ci.connection(cj).len()

## @brief An exception class for FULL deque
class FULL(Exception):
  def __init__(self, value):
    self.value = value
  def __str__(self):
    return str(self.value)

## @brief An exception class for EMPTY deque
class EMPTY(Exception):
  def __init__(self, value):
    self.value = value
  def __str__(self):
    return str(self.value)
