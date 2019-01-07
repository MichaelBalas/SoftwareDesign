######################################
# Author: 	Michael Balas        	 #
# Revised: 	Jan 7, 2019         	 #
# Description:	"MAKEFILE"		     #
######################################

# Assumes JUnit is installed
# Assumes CLASSPATH has been set for Junit

JFLAGS = -g
JCLASS = -cp ./src:.:/usr/share/java/junit4.jar
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = \
	src/Constants.java \
	src/Destinations.java \
	src/FullSequenceException.java \
	src/GenericList.java \
	src/InvalidPointException.java \
	src/InvalidPositionException.java \
	src/InvalidRegionException.java \
	src/Map.java \
	src/Obstacles.java \
	src/PathCalculation.java \
	src/PathT.java \
	src/PointT.java \
	src/RegionT.java \
	src/SafeZone.java \
	src/TestPathCalculation.java \
	src/AllTests.java \

MAIN = AllTests

default: classes

classes: $(CLASSES:.java=.class)

doc:
	doxygen doxConfig
	cd latex && $(MAKE)

test: src/$(MAIN).class
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore $(MAIN)

clean:
	rm -rf html
	rm -rf latex
	cd src
	rm **/*.class
