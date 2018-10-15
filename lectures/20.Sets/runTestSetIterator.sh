#!/bin/sh

javac -Xlint:all ArraySet.java

javac -cp .:../../resources/junit-4.12.jar TestSetIterator.java
java -cp .:../../resources/junit-4.12.jar:../../resources/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestSetIterator
