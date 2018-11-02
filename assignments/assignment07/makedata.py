#!/usr/bin/python

# Python script to generate test data for Unique.
#
# If you run the script as
#
#     python makedata.py 100 10000 50
#
# it will generate 100 numbers, each between 1
# and 10000, with roughly 50% repeated numbers.
#
# The existing test data we hand you was generated
# as follows:
#
#    python makedata.py 1000 1000000 90 >biased1k.txt
#    python makedata.py 1000 1000000 50 >mixed1k.txt
#    python makedata.py 1000 1000000 0 >random1k.txt
#
# You may want to create your own test data with
# different properties.

import random as R
import sys as S

length = int(S.argv[1]) # number of items
spread = int(S.argv[2]) # possible items
repeat = int(S.argv[3]) # percentage of repeats

if length > spread and repeat == 0:
    print >>S.stderr, "pigeon holed, won't work"

values = set()
values.add(1)

for _ in range(length):
    v = R.randint(1, spread)
    if repeat == 0:
        while v in values:
            v = R.randint(1, spread)
    elif R.randint(1, 100) <= repeat:
        v = R.sample(values, 1)[0]
    values.add(v)
    print v
