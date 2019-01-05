from math import *
from pointADT import *
from lineADT import *
from circleADT import *
from deque import *

p1 = PointT(1.0, 2.0)
p2 = PointT(1.0, 10.0)

print p1.dist(p2)

p1.rot(pi)
print p1.xcrd()
print p1.ycrd()

l1 = LineT(p1, p2)
print l1.len()

p3 = l1.mdpt()
print p3.xcrd()
print p3.ycrd()

l1.rot(-pi)
print l1.beg().xcrd()
print l1.beg().ycrd()

c1 = CircleT(p1, 9.0)
print c1.area()
c2 = CircleT(p2, 18.0)
print c1.intersect(c2)
l2 = c1.connection(c2)
print "length =" + str(l1.len())

grav = lambda r: 6e-7*r**(-3)
print (c1.force(grav))(c2)

p1 = PointT(1.0, 2.0)
p2 = PointT(1.0, 10.0)
c1 = CircleT(p1, 3.0)
c2 = CircleT(p2, 2.0)

Deq.init()
Deq.pushBack(c1)
Deq.pushFront(c2)
Deq.popBack()
Deq.popBack()
print Deq.size()
#Deq.popBack()
Deq.pushBack(c1)
Deq.pushFront(c2)
print Deq.back().rad()
print Deq.front().rad()

print Deq.disjoint()
Deq.popFront()
print Deq.disjoint()
c3 = CircleT(p2, 1.0)
Deq.pushFront(c3)
print Deq.disjoint()

p1 = PointT(0.0, 0.0)
p2 = PointT(4.0, 0.0)
c1 = CircleT(p1, 1.0)
c2 = CircleT(p2, 1.0)

Deq.init()
Deq.pushFront(c2)
Deq.pushFront(c1)

f = lambda r: 6.672*r**(-3)

print Deq.sumFx(f)

p3 = PointT(8.0, 0.0)
c3 = CircleT(p3, 1.0)

Deq.pushBack(c3)
print Deq.sumFx(f)

pnew = c3.cen()
print pnew.xcrd()
pnew.rot(3.0)
print pnew.xcrd()

p4 = c3.cen()
print p4.xcrd()
