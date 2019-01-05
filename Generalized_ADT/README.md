# Generalized Abstract Data Types
### Purpose
The purpose of this work is to write a Python program that creates, uses, and tests an Abstract Data Type (ADT) for points, lines and circles. A module that stores a deque of circles is also implemented and tested.
### Background
This project takes advantage of functional programming in Python. In a few cases functions are passed as arguments and returned as output. In particular, a function is used for easy modification of the following gravitational law:
&ensp;&ensp;![equation](https://latex.codecogs.com/gif.latex?F%20%3D%20%5Cfrac%7BG%7D%7Br%5E2%7Dm_1m_2%20%3D%20f%28r%29m_1m_2) <br />
where *F* is the force between bodies 1 and 2, *G* is the universal gravitation constant (*G* = 6.672 x 10⁻¹¹ in standard SI units), and *m₁*, *m₂* are the masses of bodies 1 and 2. The function *f*(*r) : R → R* is used to parameterize the gravitational law. Within the code you are able to substitute any value for *f*(*r*) that you like. <br />
&ensp;&ensp;The gravitational law will be used to calculate the force between circles. For simplicity, we assume that the circles have a density of 1 and that they are of unit thickness. This means that we can replace the mass with the area of the circle. Once we have the force acting on one circle from another, we can determine the *x* component of the force so that we can find a total force in the *x* direction. We can also do the same thing in the *y* direction. Moreover, once we know the components of the unbalanced force on a circle we can calculate its acceleration, and thus determine how its position changes over time. This change in position over time could be used in a simulation, computer graphics visualization or in a computer game. All of the code is documented using doxygen.  
### Implementation Details
1. Module **pointADT** creates a point ADT.
2. Module **lineADT** creates a line ADT.
3. Module **circleADT** creates a circle ADT.
4. Module **deque** that implements a deque (double-ended queue) of circles. 
5. The specifications for all modules are shown [here](specifications.pdf).
5. Module **testCircleDeque** tests all of the modules together. There is a makefile, **Makefile** to run **testCircleDeque** via the rule **test**. Each procedure has at least one test case. 
6. The makefile has a rule for **doc**, which compiles the source code documentation into an html and LaTeX version. 
#### Author
Michael Balas

#### License
[GNU General Public License](../LICENSE)
