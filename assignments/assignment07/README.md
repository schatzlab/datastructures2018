# Assignment 7: Whispering Trees

- **Out on:** November 2, 2018
- **Due by:** November 9, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Packaging 10%,
  - Style 10% (where applicable),
  - Testing 10% (where applicable),
  - Performance 10% (where applicable),
  - Functionality 60% (where applicable)

## Overview

The seventh assignment is all about ordered maps, specifically **fast**
ordered maps in the form of **balanced** binary search trees.
You'll work with a little program called `Words` that reads text from
standard input and uses an (ordered) map to count how often different words
appear.

We're giving you a **basic** (unbalanced) binary search tree implementation
of `OrderedMap` that you can use to play around with the `Words` program and
as starter code for your own developments.

Your **main** goal for this assignment is to replace our
`BinarySearchTreeMap` with your own `AvlTreeMap` and `TreapMap` classes
that provide **balanced** binary search trees with either worst-case
(AVL tree) or expected (treap) logarithmic time performance for **all**
critical map operations.
As in the previous assignment, you'll do lots of **experimental analysis**
aka benchmarking in this one.
You'll once again work with [jaybee](http://https://github.com/phf/jb) as
well as with the new `Words` program.
Think of the former as "unit benchmarking" the individual operations
of a data structure, think of the latter as "system benchmarking" a
complete (albeit small) application.

**It is *very important* that you run your benchmarks under "identical"
conditions to make them comparable. All your benchmarks should be run on
the *same* (virtual) machine, using the *same* Java version, and with as
*little* "load" (unrelated programs
running, other users logged in, etc.) as possible.
Also you should *repeat* your measurements at least a *few* times to rule
out embarrassing outliers.**

**Please note that JUnit 4 test drivers are *not* mentioned explicitly
below. Instead we simply say "...once you're sure things work..." and
what we mean by that is "...once your stuff passes your test cases...".
So yes, you *should* write JUnit 4 test drivers for *all* the code you
write.**

## Problem 1: Warming Up (20%)

This time around you'll have to write **some** code even for this first
problem, but it's still **mostly** about collecting important **baseline
data** you'll need for the following problems.
We've provided an `OrderedMap<K, V>` implementation called
`BinarySearchTreeMap` and a program called `Words` that uses it.
The binary search tree implementation is (at least for the most part)
exactly what we discussed in lecture, but you should still **read**
the code to get a good handle on how it works.
(The following two problems assume that you **start** with the code we
provide here. So you **better** understand it.)

You will **benchmark** the `BinarySearchTreeMap` implementation in two
different ways:

- With a [jaybee](http://https://github.com/phf/jb) benchmark driver called
  `BinarySearchTreeBench.java` that you will have to write.
- With the `xtime` script and the `Words.java` program provided on github.

For your [jaybee](http://https://github.com/phf/jb) benchmark driver, pay
close attention to the fact that the performance for **sorted** insertions
will be a **lot** worse than the performance for **random** insertions!
Make sure you pick sizes for your experiments that (a) clearly illustrate
the difference in behavior but (b) can still be run comfortably (without
having to wait minutes at a time to get a result).
**The most interesting experiment is to see how a sequence of *mixed* random
insertions and removals performs. It's *not* what you'd expect at first.**

For the `xtime` benchmarks you'll run the `Words` program using the
`BinarySearchTreeMap` implementation on a **variety** of data sets,
measuring the average time and memory required.
You can generate the data sets using the `makedata.py` script from the
previous assignment.
**The UNIX `sort` command will be useful to generate sorted versions of
your data sets, so you should read up on it.**

Make sure that follow these guidelines for your data sets:

- At least three different sizes of files (in terms of the number of
words/lines in each), we suggest 1000, 10000, and 100000 elements.
- At least one sorted input and two different random inputs for each
benchmark.

You don't have to cover a variety of repeated elements this time, so
you can just use "0" as the third argument to `makedata.py`; of course
it might still be interesting to see how repeated elements influence
the performance (if at all).

**Put the data you collect for this problem in your `README` file and
*describe* your observations.
Also try to *explain* your observations using your understanding of
the code you're benchmarking.
*Why* are the numbers as they are?**

### Optional (0%)

If you're even more curious about where those benchmarks spend most of
their time, you can also use the Java profiler to figure out where the
"hot spots" in those programs are for a given input file.
You can find examples for how to do this both in Peter's lecture notes
PDF and in Mike's slides, however we're not "pushing" the profiler this
semester so this is **strictly** optional.

Use the **timing** profiler whenever possible because it will give you
an **accurate** picture of what's going on in the code; if that would
take too long, use the **sampling** profiler to at least get a rough
idea of what's going on.
You **may** want to create special test data (larger than 10000 lines
but still small enough to use the timing profiler) as well.
What you should be looking for is the **cumulative percentage** of time
spent in **our** map operations.

## Problem 2: Spinning AVL Trees (50%)

Your second task for this assignment is to develop an `OrderedMap<K, V>`
implementation called `AvlTreeMap` that provides a **balanced** binary
search tree by enforcing the **AVL properties** we discussed in lecture.

**All critical map operations *must* run on O(log n) worst case time!**
Keep this in mind as you write your code, for example when you think
about how to track the height of your subtrees.
It's **not** okay to use the obvious O(n) algorithm to compute heights,
that would **ruin** the whole data structure!

Once you're reasonably sure that you `AvlTreeMap` works as it should
(be smart and write the JUnit test driver in a way that allows you to
easily reuse it for Problem 3 below!), repeat the benchmarks you did
for Problem 1 for your new implementation.
Then modify/enhance the `BinarySearchTreeBench.java` benchmark driver you wrote for Problem 1
**might** into `BalancedBSTBench.java` (be smart and write this one in a way that
allows you to easily reuse it for Problem 3 below!).
Don't forget to run the `Words` benchmarks again, too!

**Put the data you collect for this problem in your `README` file and
*describe* your observations, especially in comparison to the results
you obtained in Problem 1.
Also try to *explain* your observations using your understanding of
the code you're benchmarking.
*Why* are the numbers as they are?**

## Problem 3: Creepy Treaps (30%)

Your final task for this assignment is to develop an `OrderedMap<K, V>`
implementation called `TreapMap` that provides a **probabilistically
balanced** binary search tree by enforcing the **treap properties** we
discussed in lecture.

**All critical map operations *must* run on O(log n) expected time!**
Keep this in mind as you write your code!

Once you're reasonably sure that you `TreapMap` works as it should
(if you were smart you can reuse the JUnit test driver from Problem 2),
repeat the benchmarks you did for Problem 1 for your new implementation.
Modify either the `BinarySearchTreeBench.java` benchmark driver you wrote
for Problem 1 or the `BalancedBSTBench.java` you wrote for Problem 2 into a
new `TreapBench.java`. Don't forget to run the `Words` benchmarks again, too!

**Put the data you collect for this problem in your `README` file and
*describe* your observations, especially in comparison to the results
you obtained in Problem 1 and Problem 2.
Also try to *explain* your observations using your understanding of
the code you're benchmarking.
*Why* are the numbers as they are?**

## By the way...

[Project Gutenberg](http://www.gutenberg.org/) is a good source for
"natural language" test data if you would like to play with that.
I'd suggest
[Einstein](http://www.gutenberg.org/etext/5001),
[Frankenstein](http://www.gutenberg.org/ebooks/84),
or
[Dracula](http://www.gutenberg.org/ebooks/345)
as simple test cases.
Religious texts are more voluminous and thus provide more challenging
test cases, for example
[The Bible](http://www.gutenberg.org/etext/10)
or
[The Koran](http://www.gutenberg.org/etext/7440).
If you're not into religious texts, try
[Dewey](http://www.gutenberg.org/etext/852)
or
[Goldman](http://www.gutenberg.org/etext/2162)
instead, lots to learn.
Feel free to test "natural language" on whatever you want, we'll pick
some of our grading test cases from
[Project Gutenberg](http://www.gutenberg.org/)
as well.


## Deliverables

Go to the Assignment 7 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  AvlTreeMap.java
  AvlTreeMapTest.java
  BalancedBSTBench.java
  BinarySearchTreeBench.java
  TreapMap.java
  TreeMapTest.java
  TreapBench.java
```

**Note (especially for Java files) your files must be named exactly as we are expecting them for them to work in the autograder.**

Also note that for provided files (such as `Set.java`), we will be dropping in the provided version with your solution. So if you change `Set.java` and try to submit it, the original distributed `Set.java` we have will overwrite it. It is important not to modify those given interface files.

After you submit, the autograder will run and you will get feedback on your functionality and how you performed on our test cases. For this assignment, we will not display all of the test cases we run in the autograder to you so you will not know exactly which test case failed. The test cases are what gets you the functionality points on the assignment. If for some reason your code did not compile, you should get that output from the autograder showing you the error messages it received. If you cannot figure out why your code is not working in the autograder, but works for you locally, post a private message on piazza.

Include a `README` file that explains what your programs do and
contains the written solutions and any other notes you want us to check out before grading. This is also a required file to upload.

You should also upload your JUnit test files!

**Finally, make sure to include your name and email address in every
file you turn in (well, in every file for which it makes sense to do so anyway)!**

## Grading

For reference, here is a short explanation of the grading criteria;
some of the criteria don't apply to all problems,
and not all of the criteria are used on all assignments.

**Packaging** refers to the proper organization of the stuff you hand in,
following both the guidelines for Deliverables above as well as the general
submission instructions for assignments.

**Style** refers to Java programming style, including things like consistent
indentation, appropriate identifier names, useful comments, suitable `javadoc`
documentation, etc.
Many aspects of this are enforced automatically by
[Checkstyle](http://checkstyle.sf.net/) when run with the configuration
file available on [github](https://github.com/schatzlab/datastructures2018/tree/master/resources).
Style also includes proper modularization of your code (into interfaces,
classes, methods, using `public`, `protected`, and `private` appropriately,
etc.).  Simple, clean, readable code is what you should be aiming for.

**Testing** refers to proper unit tests for all of the data structure classes
you developed for this assignment, using exceptions and assertions
as introduced in lecture. Make sure you test **all** (implied) axioms that you can think of and
**all** exception conditions that are relevant.

**Performance** refers to how fast/with how little memory your program can
produce the required results compared to other submissions.

**Functionality** refers to your programs being able to do what they should
according to the specification given above; if the specification is ambiguous
and you had to make a certain choice, defend that choice in your `README` file.

**If your programs cannot be built you will get no points whatsoever.
If your programs cannot be built without warnings using `javac -Xlint:all`
we will take off 10% (except if you document a very good reason; no, you
cannot use the `@SuppressWarnings` annotation either).
If your programs fail miserably even once, i.e. terminate with an exception of
any kind, we will take off 10% (however we'll also take those 10% off if you're
trying to be "excessively smart" by wrapping your whole program into a
universal try-catch).**
