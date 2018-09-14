# Assignment 2: Arrays of Doom!

- **Out on:** September 14, 2018
- **Due by:** September 21, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Functionality 65%
  - ADT Solution 20%
  - Solution Design and README 5%
  - Style 10%

## Overview

The second assignment is mostly about arrays, notably our own array
specifications and implementations, not just the built-in Java arrays.
Of course we also once again snuck a small ADT problem in there...

**Note:** The grading criteria now include **10% for programming style**.
Make sure you use [Checkstyle](http://checkstyle.sf.net/) with the
correct configuration file from [Github](https://github.com/schatzlab/datastructures2018/tree/master/resources)!


## Problem 1: Revenge of Unique (30%)

You wrote a small Java program called `Unique` for Assignment 1.
The program accepted any number of command line arguments (each of
which was supposed to be an integer) and printed each **unique**
integer it received back out once, eliminating duplicates in the process.

For this problem, you will implement a new version of `Unique` called `UniqueRevenge` with **two** major changes:

- First, you are no longer allowed to use Java arrays (nor any other advanced data structure), but you can use **our** `Array` interface and **our** `SimpleArray` implementation from lecture (also available on [github](https://github.com/schatzlab/datastructures2018/blob/master/lectures/03.ArraysGenericsExceptions/SimpleArray.java))

- Second, you're going to modify the program to read the integers from **standard input** instead of processing the command line.

So the resulting `UniqueRevenge` program is invoked as

```
$ java UniqueRevenge
```

with **no** further arguments. The program then waits for input from
the user, who could for example type

```
1 9 2
3
1 4
9 5 3
6 0
```

and then hit the end-of-file key (that's CTRL-D on Unix and CTRL-Z
on Windows). At this point the program should output the unique numbers that were present in the input just like before:

```
1
9
2
3
4
5
6
0
```

Note, like before the output numbers dont need to be sorted, and non-integer values should be treated as before and cause an exception. The files `Array.java` and `SimpleArray.java` are available from [github](https://github.com/schatzlab/datastructures2018/blob/master/assignments/assignment02/).

Please use those official files, not your own versions of them --
the autograder will replace those files with the clean version anyways.

### Hints

- Reading numbers from standard input can be accomplished using a [`java.util.Scanner`](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html) object that has been wrapped around [`System.in`](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#in) which is Java's name for the standard input stream.

- Make sure you hit return one last time at the end of your input and only **then** signal end-of-file with the appropriate key-combination for your operating system (this restriction doesn't apply when you use I/O redirection to give input to the program, a highly recommended practice for testing).

- You will have to process an **unbounded** number of inputs, which requires that you keep track of how "full" the array is. When nothing fits into the array anymore, you'll have to "grow" it somehow. The best approach is to **double** the size of the array when you are out of space. (We'll talk about the reasons for this in lecture next week.)

- Do not try to change **everything at once**, there are too many "moving parts" to get things right that way. Instead, choose **one** thing to change,for example just the way input is given to the program, finish that, test it, and only **then** move on to the next thing. Remember: Baby steps!



## Problem 2: Flexible Arrays (20%)

Develop an algebraic specification for the abstract data type
`FlexibleArray` which works like the existing `Array` ADT for the most
part **except** that both its **lower** and its **upper** index bound
are set when the array is created. The lower as well as upper bound can
be **any** integer, provided the lower bound is **less than or equal**
the upper bound.

Write up the specification for `FlexibleArray` in the format we used
in lecture and **comment** on the design decisions you had to make. Also, tell us what kind of array **you** prefer and why.

**Note:** Some programming languages, notably Pascal and Ada, support
arrays of this kind instead of the zero-based arrays that are dominant
in C and Java.

### Hints

- A `FlexibleArray` for which the lower bound equals the upper bound has exactly one slot.

- Your `FlexibleArray` is **not** the `Array` ADT we did in lecture; it doesn't have to support the exact same set of operations.



## Problem 3: Sparse Arrays (35%)

A **sparse** array is an array in which **relatively few** positions
have values that differ from the initial value set when the array was
created. For sparse arrays, it is wasteful to store the value of **all**
positions explicitly since **most of them never change** and take the default value of the array. Instead, we want to store positions that **have actually been changed**.

For this problem, write a class `SparseArray` that implements the `Array`
interface we developed in lecture (the same interface you used for
Problem 1 above). **Do not modify the `Array` interface in any way!**
Instead of using a plain Java array like we did for `SimpleArray`, your
`SparseArray` should use a **linked list** of `Node` objects to store
values, similar to the `ListArray` from lecture (and available in [github](https://github.com/schatzlab/datastructures2018/tree/master/lectures/05.Iterators)).
However, your nodes no longer store just the **data** at a certain
position, they also store **the position itself**!

Here's a rough outline of how your implementation could work:

- Start with an **empty** list (instead of the complete list we built in the constructor of `ListArray`).

- For `put`, check if the relevant position has been modified before (meaning a `Node` object exists for that position); if not, add a `Node` to the list for the position and its new value; otherwise update the correct `Node` to the new value.

- For `get`, check if the relevant position has been modified before; if not, return the default value; otherwise, return the value found in the relevant `Node` object.

**Important:** Your `Node` class must be **nested inside** your
`SparseArray` class with `private` visibility! Clients should **not**
be able to "touch" `Node` objects in **any** way!

(Don't forget to add proper `javadoc` comments for your `SparseArray`
class; in particular, include advice for clients trying to decide
between the regular `SimpleArray` implementation and your new sparse implementation.)

### Testing

As part of Assignment 1, we gave you a program called `PolyCount` that
could be used to test the basic operation of a number of different
`Counter` implementations.

For this assignment, we're giving you a similar program called `PolyArray`
that can be used to test array implementations (some of the details are
a bit more complex for technical reasons, but you don't need to understand
those for now).

However, `PolyArray` is **far** from complete regarding test cases:

- the code in `testNewLength` and `testNewGet` only covers the **first two** axioms of the specification

- the code in `testNewLengthWrong` only covers the **first** precondition of the specification

You need to modify `PolyArray.java` to **add more test cases** so that **all** axioms and preconditions will be tested.

Of course, you should also use `PolyArray` to test your new `SparseArray`
code. Once you're done with `PolyArray` all **three** implementations
should be **fully** tested when the program is run.

### Hints

- Your iterator for `SparseArray` doesn't have to be particularly efficient; indeed, it's rather tricky to make it work fast; don't try. (Or rather: Only try if you're bored!)

- Think about this: Someone creates a `SparseArray<Integer>` with an initial value of 1. Then they put a few numbers different from 1 into the array. For example, the value of slot 4 might be 18. What should happen for `put(4, 1)`?

- Testing a precondition means testing that the **correct** exception is thrown when a **bad** parameter is provided.

- Note that the `PolyArray` we gave you doesn't test iterators at all; it probably should since all array implementations (the ones we gave you and the one you wrote yourself) support iterators...

## Even More Hints

- Ensure that the version of your code you hand in does not produce any extraneous debugging output anymore!

- Pay attention to edge cases in the input your classes and programs are expected to handle! For example, make sure that you handle the **empty** input in a reasonable way for Problem 1.

## Deliverables

Go to the assignment 2 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  UniqueRevenge.java
  FlexibleArrayADT.txt
  SparseArray.java
  PolyArray.java
```

**Note (especially for Java files) your files must be named exactly as we are expecting them for them to work in the autograder.**

Also note that for provided files (such as `Array.java`), we will be dropping in the provided version with your solution. So if you change `Array.java` and try to submit it, the original distributed `Array.java` we have will overwrite it. It is important not to modify those given interface files.

After you submit, the autograder will run and you will get feedback on your functionality and how you performed on our test cases. For this assignment, we will display all of the test cases we run in the autograder to you so you will know exactly what test case failed. The test cases are what gets you the functionality points on the assignment. If for some reason your code did not compile, you should get that output from the autograder showing you the error messages it received. If you cannot figure out why your code is not working in the autograder, but works for you locally, post a private message on piazza.


Include a `README` file that briefly explains what your programs do and
contains any other notes you want us to check out before grading. This is
also a required file to upload.

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
