#!/bin/sh

## Compile non-benchmark code
for i in `/bin/ls *.java | grep -v Bench`
do
  echo "Compile $i"
  javac $i
done

## Compile with jaybee
javac -cp .:../../resources/jaybee-1.0.jar BasicSetsBench.java

## Now run with jaybee
java -jar ../../resources/jaybee-1.0.jar BasicSetsBench
