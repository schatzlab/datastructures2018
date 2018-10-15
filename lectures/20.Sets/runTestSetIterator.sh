#!/bin/sh

javac -Xlint:all ArraySet.java

javac -cp .:junit-4.12.jar TestSetIterator.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestSetIterator
