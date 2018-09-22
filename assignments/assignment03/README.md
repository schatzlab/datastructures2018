# Assignment 3: Assorted Complexities

- **Out on:** September 21, 2018
- **Due by:** September 28, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Functionality 60% (where applicable)
  - Solution Design and README 10% (where applicable)
  - Style 10% (where applicable)
  - Testing 10% (where applicable)

## Overview

The third assignment is mostly about sorting and how fast things go. You will also write yet another implementation of the `Array` interface to help you analyze how many array operations various sorting algorithms perform.

**Note:** The grading criteria now include **10% for unit testing**.
This refers to <a href="http://www.junit.org/">JUnit 4</a> test drivers, not some custom test program you hacked. The problems (on this and future assignments) will state whether you are expected to produce/improve test drivers or not.

## Problem 1: Arrays with Statistics (30%)

Your first task for this assignment is to develop a new kind of `Array` implementation that keeps track of how many **read** and **write** operations have been performed on it. Check out the `Statable` interface first, reproduced here in compressed form (be sure to use **and read** the full interface available in github):

  ```java
  public interface Statable {
      void resetStatistics();
      int numberOfReads();
      int numberOfWrites();
  }
  ```

This describes what we expect of an object that can collect statistics about itself. After a `Statable` object has been "in use" for a while, we can check how many **read** and **write** operations it has been asked to perform. We can also tell it to "forget" what has happened before and start counting both kinds of operations from zero again.

You need to develop a class `StatableArray` that **extends** our dear old `SimpleArray` and also **implements** the `Statable` interface; yes, both at the same time. When a `StatableArray` is created, you initialize internal counters to keep track of the number of **read** and **write** operations it has been asked to perform so far; obviously both counts start at zero. Each time an operation is performed on the `StatableArray` object, you need to **increment** the relevant counter by one and invoke the **actual** operation in the **super class** using Java's `super` keyword.

Don't forget that your constructor for `StatableArray` will also have to invoke the `SimpleArray` constructor!

Consider a freshly constructed `StatableArray` object. It would return 0 for both `numberOfReads` and `numberOfWrites`. Now imagine we call the `length` operation followed by three calls to the `get` operation. At this point, our object would return 4 for `numberOfReads` but still 0 for `numberOfWrites`. If we now call the `put` operation twice, the object would return 2 for `numberOfWrites` but still 4 for `numberOfReads`.

Hopefully this is clear?

**You need to write JUnit 4 test cases for `StatableArray`. Your focus should be on the `Statable` aspect of the class, but you will need to call `Array` methods to trigger the various possible outcomes. Call the file with your test cases `StatableArrayTest.java` please.**

### Hints

- You can get by with the basic `@Before` and `@Test` annotations provided by JUnit, nothing fancier than that is required.
- Since the `Statable` interface doesn't use exceptions, you don't have to test any preconditions either; remember that your focus is on `Statable` and not on `Array` for which (presumably) some other test exists.

## Problem 2: All Sorts of Sorts (50%)

Your second task for this assignment is to explore some of the basic sorting algorithms and their analysis. All of these algorithms are **quadratic** in terms of their **asymptotic** performance, but they nevertheless differ in their **actual** performance.

We'll focus on the following three algorithms:

- Bubble Sort (with the "stop early if no swaps" extension)
- Selection Sort
- Insertion Sort

The github repo contains a basic framework for evaluating sorting algorithms. You'll need a working `StatableArray` class from Problem 1, and you'll need to understand the following interface as well (again compressed, be sure to to use **and read** the full interface:

```java
  public interface SortingAlgorithm<T extends Comparable<T>> {
      void sort(Array<T> array);
      String name();
  }
```

Let's look at the simple stuff first:

An object is considered an algorithm suitable for sorting in this framework if
  (a) we can ask it to sort a given `Array` and (b) we can ask it for its name (e.g. "Insertion Sort").

The more complicated stuff is at the top:
  The use of `extends` **inside** the angle brackets means that any type
  `T` we want to sort must implement the interface `Comparable` as well.
  It obviously can't just be any old type, it must be a type for which the
  expression "a is less than b" actually makes sense.
  Using `Comparable` in this form is Java's way of saying that we can **order**
  the objects; you should definitely **read up** on the details
  [here](http://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)!

As an example for all this, we have provided an implementation of `SelectionSort` on [Piazza](http://piazza.com/) already. (Actually, there are also two other algorithms, `NullSort` and `GnomeSort`, just so you start out with a few to run right away.)

  **You need to write classes implementing `BubbleSort` and `InsertionSort` for this problem. Just like our example algorithms, your classes have to `implement` the `SortingAlgorithm` interface.**

All of this should be fairly straightforward once you get used to the framework. Speaking of the framework, the way you actually "run" the various algorithms is by using the `PolySort.java` program we've provided as well. You should be able to compile and run it without yet having written any sorting code yourself.


Here's how:

```sh
  $ java PolySort 4000 <random.data
  Algorithm            Sorted?  Size         Reads        Writes       Seconds

  Null Sort            false    4,000        0            0            0.000007
  Gnome Sort           true     4,000        32,195,307   8,045,828    0.243852
  Selection Sort       true     4,000        24,009,991   7,992        0.252085
```

This will read the first 4000 strings from the file `random.data` and sort them using all available algorithms. As you can see, the program checks if the algorithm actually worked (Sorted?) and reports how many operations of the underlying `StatableArray` were used in order to perform the sort (Reads, Writes). Finally, the program also prints out long it took to sort the array (Seconds) but that number will vary widely across machines so you can really only use it for relative comparisons on the machine actually running the experiment.

**However, the main point of all this is *not* the coding work.**
Instead, the main point is to **evaluate** and **compare** the sorting algorithms on different sets of data. We've provided three sets of useful test data on github and you can use the command line argument to vary how much of it is used (thereby changing the size of the problem). You should try to quantify **how** the various algorithms differ and explain **why** they differ as well (i.e. what about a given algorithm makes it better or worse than another one for a given data set).

In your `README` file you should describe the series of experiments you ran, what data you collected, and what your conclusions about the performance of these algorithms are.


Some ideas for what to address:

- Does the actual running time correspond to the asymptotic complexity as you would expect?
- What explains the practical differences between these algorithms?
- Does it matter what kind of data (random, already sorted in ascending order, sorted in descending order) you are sorting?

Just to be clear:
  Yes, we'll need the code, and it should be up to the usual standards.
  But the "report" you put in your `README` is just as important as the code!

## Problem 3: Analysis of Selection Sort (20%)

Your final task for this assignment is to analyze the following selection sort algorithm **theoretically** (without running it) in **detail** (without using O-notation).

Here's the code, and you **must** analyze **exactly** this code (the line numbers are given so you can refer to them in your writeup for this problem):

```java
   1: public static void selectionSort(int[] a) {
   2:    for (int i = 0; i < a.length - 1; i++) {
   3:        int min = i;
   4:        for (int j = i + 1; j < a.length; j++) {
   5:            if (a[j] < a[min]) {
   6:                min = j;
   7:            }
   8:        }
   9:        int t = a[i]; a[i] = a[min]; a[min] = t;
  10:     }
  11:  }
  ```

You need to determine **exactly** how many comparisons **C(n)** and assignments **A(n)** are performed by this implementation of selection sort **in the worst case**. Both of those should be **polynomials of degree 2** since you know that the asymptotic complexity of selection sort is **O(n^2)**. (As usual we refer to the size of the problem, which is the length of the array to be sorted here, as "n" above.)

**Important:** Don't just **state** the polynomials, your writeup has to **explain *how* you derived them**! Anyone can google for the answer, but you need to **convince us** that you actually **did the work**!

## Even More Hints

- Ensure that the version of your code you hand in does not produce any
  extraneous debugging output anymore!

## Deliverables

Go to the assignment 3 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  StatableArray.java
  StatableArrayTest.java
  BubbleSort.java
  InsertionSort.java
```

**Note (especially for Java files) your files must be named exactly as we are expecting them for them to work in the autograder.**

Also note that for provided files (such as `Array.java`), we will be dropping in the provided version with your solution. So if you change `Array.java` and try to submit it, the original distributed `Array.java` we have will overwrite it. It is important not to modify those given interface files.

After you submit, the autograder will run and you will get feedback on your functionality and how you performed on our test cases. For this assignment, we will display all of the test cases we run in the autograder to you so you will know exactly what test case failed. The test cases are what gets you the functionality points on the assignment. If for some reason your code did not compile, you should get that output from the autograder showing you the error messages it received. If you cannot figure out why your code is not working in the autograder, but works for you locally, post a private message on piazza.

Include a `README` file that explains what your programs do and
contains the written solutions and any other notes you want us to check out before grading. This is also a required file to upload.

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
