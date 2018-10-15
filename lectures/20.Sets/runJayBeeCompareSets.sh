#!/bin/sh

## Compile with jaybee
javac -cp .:../../resources/jaybee-1.0.jar CompareSets.java

## Now run with jaybee
java -jar ../../resources/jaybee-1.0.jar CompareSets
