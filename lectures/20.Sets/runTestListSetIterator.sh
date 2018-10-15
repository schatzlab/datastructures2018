#!/bin/sh

javac -Xlint:all ListSet.java

javac -cp .:../../resources/junit-4.12.jar TestListSetIterator.java
java -cp .:../../resources/junit-4.12.jar:../../resources/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestListSetIterator
