# Circle Abstract Data Type
### Purpose
The purpose of this software design work is to write a Python program that creates, uses, and tests a simple Abstract Data Type (ADT) that stores data on a circle. The Circle ADT will allow a program to create instances of the datatype **CircleT**. A circle ADT may be of interest in computer graphics or gaming applications. The program will consist of two modules and a test driver program. 
### Implementation Details
1. Module **CircleADT** defines a class *CircleT*, which contains the following class methods that define the external interface: 
* A constructor (*CircleT*) that takes three real numbers: *x*, *y*, and *r* as input and assigns them to private instance variables. The *x* and *y* values define the centre of the circle and *r* defines its radius.
* Three getters named **xcoord**, **ycoord**, and **radius** that return the *x* and *y* coordinates of the centre of the circle and the radius of the circle, respectively.
* A method named **area** that returns the area of the circle.
* A method named **circumference** that returns the circumference of the circle.
* A method named **insideBox** that takes the following inputs: the *x* coordinate of the left side of a box (*x0*), the *y* coordinate of the top of a box (*y0*), the width (*w*) of the box and the height (*h*) of the box. The box, the circle and the associated coordinate system are shown below. This method should return true if the circle is inside the box and false if it is not.
![circleBoxIntersect Figure](circleBoxIntersect.png?raw=true)
* A method named **intersect** that takes a second instance of **CircleT** *c* as input and returns true if the circles intersect and false outherwise. (Two circle intersect if they have any points in common. The interior of the circle is considered to be part of the circle). 
* A method named **scale** that takes a float *k* as an argument and changes the radius such that it is scaled by *k*.
* A method named **translate** that takes two floats *dx* and *dy* as arguments and translates the centre of the circle by *dx* in the *x* direction and by *dy* in the *y* direction.
2. Module **Statistics** calculates various statistics for a list of circles (some of the routines are implemented using *numpy*). It consists of the following functions:
* A function named **average** that takes a list of instances of **CircleT** and returns the average radius of all of the circles in the list. This function is implemented using **numpy**.
* A function named **stdDev** that takes a list of instances of **CircleT** and returns the standard deviation of the radii of all of the circles in the list. This function is implemented using **numpy**.
* A function named **rank** that takes a list of instances of **CircleT** and returns a list ranked by radius. A ranking list proides for each element in the list the position it would hold if the list were sorted in descending order of radius. The maximum entry in the list has rank 1. For instance, the rank of radii [6.0, 5.0, 11.0, 9.0] would be [3, 4, 1, 2]. In the case of ties, the dense ranking scheme is used (see [here](https://en.wikipedia.org/wiki/Ranking) for more information).
3. Module **testCircles** tests the first and second modules together. There is a **Makefile** with a rule **test** that runs **testCircles** with the Python interpreter. Each procedure has at least one test case. 
4. The **Makefile** has a rule for **doc**. This rule compiles the documentation into an html and LaTeX version. 
#### Author
Michael Balas

#### License

