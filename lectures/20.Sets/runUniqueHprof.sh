#!/bin/sh

## run java with hprof enabled
java -agentlib:hprof=cpu=times Unique < random1k.txt > bla

## Examine the profile
# less java.hprof.txt


## This will sample every 10 milliseconds (faster, but not as precise)
# java -agentlib:hprof=cpu=samples Unique < random1k.txt > bla

## Now profile the memory
# java -agentlib:hprof Unique < random1k.txt > bla

