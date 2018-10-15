#!/bin/sh

if [ ! -r random1k.txt ];   then seq 1 1000    | awk '{print int(rand()*100000)}' > random1k.txt; fi
if [ ! -r random10k.txt ];  then seq 1 10000   | awk '{print int(rand()*100000)}' > random10k.txt; fi
if [ ! -r random100k.txt ]; then seq 1 100000  | awk '{print int(rand()*100000)}' > random100k.txt; fi

echo "Testing random1k"
time java UniqueList < random1k.txt > bla2
wc -l bla2

echo "Testing random10k"
time java UniqueList < random10k.txt > bla2
wc -l bla2

echo "Testing random100k"
time java UniqueList < random100k.txt > bla2
wc -l bla2





if [ ! -r spread1k.txt ];   then seq 1 100000  | awk '{print int(rand()*1000)}' > spread1k.txt; fi
if [ ! -r spread10k.txt ];  then seq 1 100000  | awk '{print int(rand()*10000)}' > spread10k.txt; fi
if [ ! -r spread100k.txt ]; then seq 1 100000  | awk '{print int(rand()*100000)}' > spread100k.txt; fi

echo "Testing spread1k"
time java UniqueList < spread1k.txt > bla2
wc -l bla2

echo "Testing spread10k"
time java UniqueList < spread10k.txt > bla2
wc -l bla2

echo "Testing spread100k"
time java UniqueList < spread100k.txt > bla2
wc -l bla2
