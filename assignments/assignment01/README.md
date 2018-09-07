# Assignment 1: Warming Up

- **Out on:** September 7, 2016
- **Due by:** September 14, 2016 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Functionality 65%
  - ADT Solution 30%
  - Solution Design and README 5%
  - Style 0%

## Overview

The first assignment is mostly a warmup exercise to refresh your knowledge of
Java and an ADT problem to start you thinking more abstractly about your data. 

## Problem 1: Unique Numbers (35%)

Your first task is to write a simple Java program `Unique` that analyzes the
command line it is given in a peculiar way. The program accepts **any** number
of **integers** as command line arguments and prints each **unique** integer it
was presented with as its output. For example, the invocation

	java Unique 0 0 10 0 1 0 0 0 10 1

should generate the output

	0
	10
	1

while the invocation

	java Unique 1 9 2 3 1 4 9 5 3 6 0

should generate the output

	1
	9
	2
	3
	4
	5
	6
	0

instead. Note that order **doesn't** matter as long as you print the
correct **set** of numbers, one line per number, without any additional output!

As an added complication, you are **not** allowed to use any Java classes that
serve as advanced data structures, specifically not Java collection classes like
`ArrayList` or `HashMap`. You can use regular Java arrays, and in
fact that's probably the best way to go; the only "problem" is that we don't
specify an upper limit on the number of arguments, you'll have to figure out
how to deal with that...

### Hints

- If you feel like you need to sort something, think again! You don't have to
sort anything to get this problem done.
- The "command line" is the array of strings passed to the main method of your
program. If you're using a graphical development environment you may have to
first figure out how you can start the program with a command line.
- Any non-integer values passed in should cause an exception of type IllegalArgumentException 


## Problem 2: Counter Varieties (30%)

Your second task is to write a number of "counters" that can be used
interchangeably (at least as far as Java is concerned). You are given the
following interface (put it into a file `Counter.java` please):

```java
/** The essence of any counter. */
public interface Counter {
  /** Current value of this counter. */
  int value();
  /** Increment this counter. */
  void up();
  /** Decrement this counter. */
  void down();
}
```

Develop the following:

- An interface `ResetableCounter` that supports the method `void reset()` in
addition to those of `Counter`; this method should set the counter to its initial value
- An implementation of `ResetableCounter` called `BasicCounter` that starts at
the value 0 and counts up and down by +1 and -1 respectively.
- An implementation of `ResetableCounter` called `EvenCounter` that starts at
the value 0, counts up by adding 2, and counts down by subtracting
2
- An implementation of `ResetableCounter` called `TenCounter` that starts at
the value 1, counts up by multiplying by 10, and counts down by dividing by 10.
This should round *up* to the nearest integer if needed
- An implementation of `ResetableCounter` called `FlexibleCounter` that allows
clients to specify a start value as well as an additive increment (used for
counting up) when a counter is created. For example
`new FlexibleCounter(-10, 42)` would yield a counter with the current value -10;
after a call to `up()` its value would be 32.

All of your implementations should be resettable, and each should contain a main
method that tests whether the implementation works as expected using assert as
we did in lecture (this is a simple approach to unit testing, we'll cover a
better approach later).

Finally, make sure that your four counters work with the `PolyCount.java` test
program we provide; it's probably a good idea to read and understand it. :-)

### Hints

- Pay attention to your use of `public` and `private`! The essence of those
counters is not just to hold a bunch of data, but to ensure that a certain
approach to counting is followed; making everything public is a bad idea here.
- Remember that interfaces can extend one another in a way similar to classes
(using the `extends` keyword). Classes implement interfaces however (using the
`implements` keyword).



## Problem 3: List ADT (30%)

In lecture we derived an algebraic specification for the abstract data type
`Array`.  Following that example, develop a specification for the related ADT
`List` supporting these operations:

1. Create a new empty list
2. insert: Insert an integer at a particular position in the list.
3. isEmpty: Return true if the list is empty, otherwise false.
4. clear: Clear the contents of the list
5. length: Return the number of integers currently in the list.
6. get: Retrieve the integer at a particular position in the list.
7. remove: Delete the integer at a particular position in the list.

From this description, the input and output of each operation should hopefully be clear. 

Do this in a text file named `ListADT.txt`

### Notes

- You can assume the Boolean ADT is available that specifies 'true' and 'false'
- Make sure to list all axioms and preconditions -- what assertions and exceptions would you write if you were implementing this
  ADT?

## Solution Design (5%)
- You will be graded on your general solution and design. Discuss in your README file anything related to how you solved the problems and justify why you believe your solution is a good one.
- This is relatively subjective but we are generally looking for good practices in Java (helper methods, inheritance, etc...)

## Even More Hints

- Ensure that the version of your code you hand in does not produce any
extraneous debugging output anymore!
- Pay attention to edge cases in the input your classes and programs are
expected to handle! For example, make sure that you handle an **empty** command
line in a reasonable way for Problem 1.
- You will not be deducted for style on this assignment, however you will still receive checkstyle feedback and general style feedback. In the future, style will be worth roughly 10% of the assignment and you will get checkstyle feedback in the autograder.
- Submitting compiling code is always better, no compilation means no functionality points. You will get freebie points just for having a submission that compiles.


## Deliverables

Go to the assignment 1 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:
```
Unique.java
BasicCounter.java
EvenCounter.java
FlexibleCounter.java
ResetableCounter.java
TenCounter.java
README
ListADT.txt
```

**Note (especially for Java files) your files must be named exactly as we are expecting them for them to work in the autograder.**

Also note that for provided files (such as `Counter.java`), we will be dropping in the provided version with your solution. So if you change `Counter.java` and try to submit it, the original distributed `Counter.java` we have will overwrite it. It is important not to modify those given interface files.

After you submit, the autograder will run and you will get feedback on your functionality and how you performed on our test cases. For this assignment, we will display all of the test cases we run in the autograder to you so you will know exactly what test case failed. The test cases are what gets you the functionality points on the assignment. If for some reason your code did not compile, you should get that output from the autograder showing you the error messages it received. If you cannot figure out why your code is not working in the autograder, but works for you locally, post a private message on piazza.


Include a `README` file that briefly explains what your programs do and
contains any other notes you want us to check out before grading. This is also a

**Finally, make sure to include your name and email address in every file you
turn in (well, in every file for which it makes sense to do so anyway)!**

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
you developed for this assignment, using the [JUnit 4](http://www.junit.org/)
framework as introduced in lecture. Make sure you test **all** (implied) axioms that you can think of and
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

