# Author: Michael Balas
# Revised: Jan 9, 2019

# Assumes JUnit is installed

JFLAGS = -g

JCLASS = -cp $(CLASSPATH):src/:/usr/share/java/junit4.jar 

DOC = javadoc

JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = src/*.java

MAIN = BattleshipTests

default: classes

classes:
	$(JC) $(JCLASS) $(CLASSES)

test:
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore $(MAIN)

doc: 
	$(DOC) $(CLASSES) -d javadoc

clean:
	$(RM) src/*.class
	$(RM) -r javadoc

