#!/bin/sh

for i in `/bin/ls -1 *.java | grep -v Test`
do 
  echo "Compiling $i"
  javac -Xlint:all $i
done

echo "Compiling TestListMore.java"
javac -cp .:../../resources/junit-4.12.jar TestListMore.java

echo "Running Junit"
java -cp .:../../resources/junit-4.12.jar:../../resources/hamcrest-core-1.3.jar \
     org.junit.runner.JUnitCore TestListMore
