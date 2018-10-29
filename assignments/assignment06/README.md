# Assignment 6: Setting Priorities

- **Out on:** October 26, 2018
- **Due by:** November 2, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Packaging 10%,
  - Style 10% (where applicable),
  - Testing 10% (where applicable),
  - Performance 10% (where applicable),
  - Functionality 60% (where applicable)

## Overview

The sixth assignment is all about sets, priority queues, and various
forms of **experimental analysis** aka benchmarking.
You'll work a lot with [jaybee](http://https://github.com/phf/jb) as
well as with new incarnations of the old `Unique` program.
Think of the former as "unit benchmarking" the individual operations
of a data structure, think of the latter as "system benchmarking" a
complete (albeit small) application.

**It is *very important* that you run your benchmarks under "identical"
conditions to make them comparable.
All your benchmarks should be run on the *same* (virtual) machine, using
the *same* Java version, and with as *little* "load" (unrelated programs
running, other users logged in, etc.) as possible.
Also you should *repeat* your measurements at least a *few* times to rule
out embarrassing outliers.**

**Please note that JUnit 4 test drivers are *not* mentioned explicitly
below. Instead we simply say "...once you're sure things work..." and
what we mean by that is "...once your stuff passes your test cases...".
So yes, you *should* write JUnit 4 test drivers for all the code you
write.**

## Problem 1: Warming Up (20%)

You won't have to write code for this first problem, instead you'll collect
some important **baseline data** you'll need for the following problems.
We have provided **two** implementations of the `Set<T>` interface for you
on Github, `ArraySet<T>` and `ListSet<T>`.

These are the same implementations (at least for the most part) that we
discussed in lecture, but you should still **read** the code to get a good
handle on how they work.
You will **benchmark** these two set implementations in two different ways:

  - With a [jaybee](http://https://github.com/phf/jb) benchmark driver called
    `BasicSetsBench.java`, also provided on github.
  - With the `xtime` script (which is just a nice wrapper around the Linux
    `time` command) and a new version of `Unique.java`, also provided on
    github.

The former just requires building and running `BasicSetsBench` to obtain
the performance profile of the various `Set<T>` operations for each of
the implementations. The github repo has sample commands for compiling and
running with jaybee. Each line is one particular benchmark. The output from jaybee will have:
  - The name corresponds to the name of the method with the @Bench annotation.
  - The first number on each line is how many times Jaybee decided to run that benchmark in order to get a meaningful result.
  - The second number is roughly the time in nanoseconds it took for one benchmark.
  - The third number is roughly how much memory in bytes was allocated for one benchmark (this can sometimes get confused are report negative numbers but dont panic)

Easy points.

The latter requires running the `Unique` program several times for each
`Set<T>` implementation on a **variety** of data sets and measuring the
average time and memory required using `xtime`.
You can generate the data sets using the `makedata.py` script we also
provided; read the long comment at the top of that program to
figure out how to run it. Note this requires python 2 to run.
Note you may need to mark `xtime` executable by changing
the permissions: `$ chmod +x xtime`. This program only runs on Linux, but not Mac,
although will run in the virtual box.

Make sure that follow these guidelines for your data sets:

  - At least three different sizes of files (in terms of the number of
  integers/lines in each), we suggest 1000, 10000, and 100000 elements.
  - At least three different levels of repeated elements, we suggest 0%,
  50%, and 90%.

If you wish, you can also vary the **range** of integers in each file
to get a third dimension you can evaluate performance along, but if
you don't feel like doing that just use a range of 1000000 for each.
(Note that these are exactly the examples also described in the comment
in the Python script itself.)

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
spent in **our** set operations.

## Problem 2: Heuristics Ahead (40%)

Alright, now you get to write some code.
You'll modify the two implementations of `Set<T>` we provided to use
the **heuristics** we discussed in lecture:

  - Change `ListSet<T>` into `MoveToFrontListSet<T>` and add the
    "move to front" heuristic:
    Any operation (**except** for the iterator!) should move the
    element in question all the way to the front of the list!
    Since all set operations call the private `find` method, it
    **should** suffice to make your changes there.
  - Change `ArraySet<T>` into `TransposeArraySet<T>` and add the
    "transpose" heuristic:
    Any operation (**except** for the iterator!) should move the
    element in question **one** slot toward the front by swapping!
    Once again, since all set operations call the private `find`
    method, it **should** suffice to make your changes there.

After you are reasonably sure that your new "adaptive" set
implementations work, collect **all** the information you
collected in Problem 1 **again** for the new implementations:

  - For the [jaybee](http://https://github.com/phf/jb) benchmarks you
    will have to produce a new driver called `AdaptiveSetsBench.java`
    that includes code to trigger the new behaviors.
  - For the `Unique` benchmarks you simply have to instantiate the new
    set implementations and rerun all your benchmarks on the same data
    sets.

**Put the data you collect for this problem in your `README` file and
*describe* your observations, especially in comparison to the results
you obtained in Problem 1.
Also try to *explain* your observations using your understanding of
the code you're benchmarking.
*Why* are the numbers as they are?**

## Problem 3: Queuing Priorities (40%)

For the last problem we leave sets behind and look at the
`PriorityQueue<T>` interface instead.
As discussed in lecture, the **semantics** of priority queues and
sets are **very** different indeed, so why bother having them on
this assignment?
It turns out that `Unique` using a priority queue is a **lot** faster
than using **any** of the set implementations we've seen so far, and
we figured you should be exposed to that.

The big semantic difference between priority queues and sets is that
if we insert "X" into a set three times and remove "X" once, it's gone;
in a priority queue "X" would have to be removed three times before
it's gone.
You'll have to write a new version of `Unique` called `UniqueQueue`
that takes this difference into account:
You can still **insert** every number as it comes along, however when
you **remove** them to print the output you have to be careful not to
print the same number repeatedly.
That would defeat the whole purpose of `Unique` after all.

On github, we provide a (bad!) implementation of the `PriorityQueue<T>`
interface called `SortedArrayPriorityQueue<T>`.
We do this mostly so you have an example for the way you should be
dealing with the `Comparator<T>` objects, but also to give you something
you can measure your own implementation against.
**You probably still need to read up on comparators and how they work!**

You will implement `BinaryHeapPriorityQueue<T>` using the **binary
heap** data structure described in lecture.
It's your choice whether you want to use a **plain** Java array or
the `ArrayList<T>` class from the Java library as the basis for
this.
**Yes, you definitely need two constructors for your implementation as
well!**
If a client creates a `BinaryHeapPriorityQueue<T>` with no comparator,
the `top` and `remove` methods should operate on the **largest** element
in the queue, not the smallest element.

After you are reasonably sure that your `PriorityQueue<T>` implementations
work, collect **all** the information you collected in Problem 1
**again** for the new implementations:

  - For the [jaybee](http://https://github.com/phf/jb) benchmarks you
    will have to produce a new driver called `PriorityQueuesBench.java`.
    It won't be possible to exactly match the previous drivers, just do
    your best.
    If you believe that the data you collect here is "too different"
    because of the disconnect between `Set<T>` and `PriorityQueue<T>`
    just say so in your comparison.
  - For the `Unique` benchmarks you have to adapt the program as described
    above; then rerun all your benchmarks again on the same data sets.

Just to be clear, you should collect performance data for **both** of
the `PriorityQueue<T>` implementations, `SortedArrayPriorityQueue<T>`
as well as `BinaryHeapPriorityQueue<T>`.

**Put the data you collect for this problem in your `README` file and
*describe* your observations, especially in comparison to the results
you obtained in Problems 1 and 2.
Also try to *explain* your observations using your understanding of
the code you're benchmarking.
*Why* are the numbers as they are?**

## Problem 4: Bottom-Up Bonus (+15%)
For some bonus points (yes, we mean actual extra credit), add a method to your BinaryHeapPriorityQueue<T> implementation that will perform a bottom-up build of the heap (in O(n) time), given a parameter that is an appropriate collection of values with the same generic type as those in the priority queue. It is important to realize that it’s perfectly normal for a class to have public methods in addition to whatever interfaces it may implement.

Next, write yet another version of the Unique program called UniqueQueueBU that uses the bottom-up build method instead of inserting values one by one into the queue as they are read. You’ll then need to run the timing benchmarks again with this version on all your data sets. Include your data, observations, comparisons, and conclusions in your README along with the other reflection data. Also make it very clear that you did this bonus part so that we see to give you credit for it.


## Deliverables

Go to the assignment 6 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  MoveToFrontListSet.java
  TransposeArraySet.java
  AdaptiveSetsBench.java
  UniqueQueue.java
  BinaryHeapPriorityQueue.java
  PriorityQueuesBench.java
  UniqueQueueBU.java (optional)
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
