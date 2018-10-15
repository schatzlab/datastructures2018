#!/bin/sh

javac -Xlint:all ListSet.java

javac -cp .:junit-4.12.jar TestListSetIterator.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestListSetIterator
