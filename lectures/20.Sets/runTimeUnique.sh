#!/bin/sh

if [ ! -r random1k.txt ];   then seq 1 1000    | awk '{print int(rand()*100000)}' > random1k.txt; fi
if [ ! -r random10k.txt ];  then seq 1 10000   | awk '{print int(rand()*100000)}' > random10k.txt; fi
if [ ! -r random100k.txt ]; then seq 1 100000  | awk '{print int(rand()*100000)}' > random100k.txt; fi

echo "Testing random1k"
time java Unique < random1k.txt > bla
wc -l bla

echo "Testing random10k"
time java Unique < random10k.txt > bla
wc -l bla

echo "Testing random100k"
time java Unique < random100k.txt > bla
wc -l bla





if [ ! -r spread1k.txt ];   then seq 1 100000  | awk '{print int(rand()*1000)}' > spread1k.txt; fi
if [ ! -r spread10k.txt ];  then seq 1 100000  | awk '{print int(rand()*10000)}' > spread10k.txt; fi
if [ ! -r spread100k.txt ]; then seq 1 100000  | awk '{print int(rand()*100000)}' > spread100k.txt; fi

echo "Testing spread1k"
time java Unique < spread1k.txt > bla
wc -l bla

echo "Testing spread10k"
time java Unique < spread10k.txt > bla
wc -l bla

echo "Testing spread100k"
time java Unique < spread100k.txt > bla
wc -l bla
