# Assignment 4: Stacking Queues

- **Out on:** September 28, 2018
- **Due by:** October 5, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Packaging 10%,
  - Style 10% (where applicable),
  - Testing 10% (where applicable),
  - Performance 10% (where applicable),
  - Functionality 60% (where applicable)

## Overview

  The fourth assignment is mostly about stacks and dequeues.
  For the former you'll build a simple calculator application, for the latter
  you'll implement the data structure in a way that satisfies certain
  performance characteristics (in addition to the usual correctness properties).

## Problem 1: Calculating Stacks (50%)

  Your first task is to implement a basic
  [RPN](http://en.wikipedia.org/wiki/Reverse_Polish_notation)
  calculator that supports **integer operands** like `1`, `64738`, and `-42`
  as well as the (binary) **integer operators** `+`, `-`, `*`, `/`, and `%`.
  Your program should be called `Calc` and work as follows:

  - You create an empty `Stack` to hold intermediate results and then
    repeatedly accept input from the user.
    It doesn't matter whether you use the `ArrayStack` or the `ListStack` we
    provide, what **does** matter is that those specific types appear only
    **once** in your program.
    (In other words, the type of the stack you use in your program must be
    `Stack` and not `ArrayStack` or `ListStack`. Polymorphism!)
  - If the user enters a valid integer, you push that integer onto the stack.
  - If the user enters a valid operator, you pop two integers off the stack,
    perform the requested operation, and push the result back onto the stack.
  - If the user enters the symbol `?` (that's a question mark), you print the
    current state of the stack using its `toString` method followed by a
    new line.
  - If the user enters the symbol `.` (that's a dot or full-stop), you pop the
    top element off the stack and print it (**only** the top element, not the
    entire stack) followed by a new line.
  - If the user enters the symbol `!` (that's an exclamation mark or bang),
    you exit the program.

  Note that there are a **number of error conditions** that your program must
  deal with **gracefully** for full credit.
  We'll give you two examples for free, you'll have to **figure out any further
  error conditions for yourself**:

  - If the user enters `blah` (or anything else that doesn't make sense for
    a calculator as specified above) your program should make it clear that
    it can't do anything helpful with that input; but it should not stop at
    that point.
  - If the user requests an operation for which there are not enough
    operands on the stack, your program should notify the user of the problem
    but leave the stack unchanged; again, it should certainly not stop at that
    point.

  Of course this means that you'll have to print **error messages** to the
  user.
  Error messages must be printed to **standard error** and **not** to
  **standard out**!
  (Of course, the regular input and output is done through **standard in**
  and **standard out** as usual.)
  Furthermore, **all error messages must start with the symbol `?` (that's
  a question mark) and be followed by a new line!**

### Examples

  Here are two examples for interacting with `Calc` that will hopefully
  help you understand what you're trying to achieve. First a "slow" example:

  ```
  $ java Calc
  ?
  []
  10
  ?
  [10]
  20 30
  ?
  [30, 20, 10]
  *
  ?
  [600, 10]
  +
  ?
  [610]
  .
  610
  !
  $
  ```

  Here `$` is the shell prompt. After starting the program, the first command
  was `?` to print the stack (which is empty at this point, hence `[]` is the
  output). Then the user typed `10` followed by `?` and we see that the stack
  now holds that number: `[10]`. Now the user typed two numbers `20 30` in
  sequence before hitting return. When we check the stack now using `?` we
  get the answer `[30, 20, 10]` so obviously the "top" of the stack is to the
  left. Then we see the `*` operator being typed, which will multiply the top
  two numbers. We use `?` again to check the result: `[600, 10]`. This is
  followed by the `+` operator, which will add the top two numbers. Again we
  check with `?` and get `[610]` as we'd expect. The `.` command prints the
  same result `610` and finally the user typed the `!` command to quit,
  returning us to the shell. Here's the same example, done "fast" this time:

  ```
  $ java Calc
  ? 10 ? 20 30 ? * ? + ? . !
  []
  [10]
  [30, 20, 10]
  [600, 10]
  [610]
  610
  $
  ```

  As you can see, if the entire sequence of integers, operators, and commands
  is entered on a single line, they are all executed in order. It's like
  having our own little programming language! Finally, here's an example for
  the two error conditions described above:

  ```
  $ java Calc
  1 2 blah 1.0 3 ?
  ?Huh?
  ?Huh?
  [3, 2, 1]
  + + ?
  [6]
  + + ?
  ?Not enough arguments.
  ?Not enough arguments.
  [6]
  !
  $
  ```

  Note in particular that `blah` and `1.0` lead to error messages but are
  otherwise ignored (the program doesn't stop); same for the two `+` operations
  when the stack only has a single element (the program doesn't even modify the
  stack in that case).

### Hints

  - Note that we're dealing with **integers** only (type `Integer` in Java)
    so `/` stands for
    [**integer** division](https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.17.2)
    and `%` stands for
    [**integer** remainder](https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.17.3).
    Both of these should behave in `Calc` just like they do in Java.
    (The details are messy but worth knowing about, especially regarding
    [modulus](https://en.wikipedia.org/wiki/Modulo_operation).)
  - You may find it interesting to read up on
    [Autoboxing and Unboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)
    in Java.
    It's the reason we can use our generic `Stack` implementations for
    `Integer` objects yet still do arithmetic like we would on regular `int`
    variables.
  - You'll probably want to use a `Scanner` object, the methods `hasNext` and
    `next`, but nothing else for getting the input.
  - **Only if you're not afraid of learning on your own:** You'll be able to
    use the [`matches`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#matches-java.lang.String-)
    method of the `String` class to your advantage when it comes to checking
    whether a valid operator was entered.
    (But you can just as well do it with a bunch of separate comparisons if
    you don't want to learn about
    [regular expressions](https://docs.oracle.com/javase/tutorial/essential/regex/).)

## Problem 2: Hacking Growable Dequeues (50%)

  Your second task is to implement a generic `ArrayDequeue` class as outlined
  in lecture.
  As is to be expected, `ArrayDequeue` must implement the `Dequeue` interface
  we provided on github.

  Your implementation **must** be done in terms of an array that **grows by
  doubling** as needed.
  It's up to you whether you want to use a **basic** Java array or the
  `SimpleArray` class you know and love;
  just in case you prefer the latter, we've once again included it on the
  github directory for this assignment.
  Your **initial** array **must** have a length of **one** slot only!
  (Trust us, that's going to make debugging the "doubling" part a lot easier.)

  Your implementation **must** support **all** `Dequeue` operations **except**
  insertion in (worst-case) **constant time**; insertion can take longer **every
  now and then** (when you need to grow the array), but overall **all**
  insertion operations must be **constant amortized time** as discussed in
  lecture.

  You should provide a `toString` method in addition to the methods required
  by the `Dequeue` interface.
  A new dequeue into which 1, 2, and 3 were inserted using `insertBack()`
  should print as `[1, 2, 3]` while an empty dequeue should print as `[]`.

### Testing

  You must write a JUnit 4 test driver for your `ArrayDequeue` class in a
  file `TestArrayDequeue.java`.
  Be sure to test **all** methods and **all** exceptions as well.
  Note that it is **not** enough to have just **one** test case for each
  method; there are plenty of complex interactions between the methods that
  should be covered as well.
  (And yes, you need to test `toString` as well.)

### Documentation

  Don't forget to add proper `javadoc` comments for your `ArrayDequeue` class.
  **Running checkstyle will remind you to do this!**

## Even More Hints

  - Ensure that the version of your code you hand in does not produce any
    extraneous debugging output anymore!
  - Pay attention to edge cases in the input your classes and programs are
    expected to handle! For example, make sure that you handle the **empty**
    input in a reasonable way for Problem 1.
  - Private helper methods are your friends. Your best friends, actually!
    If you don't write plenty of them, you'll have a much harder time getting
    your code to work.

## Bonus Problem (5 pts)

  Develop an algebraic specification for the abstract data type `Queue`.
  Use `new`, `empty`, `enqueue`, `dequeue`, and `front` (with the meaning
  of each as discussed in lecture) as your set of operations.
  Consider **unbounded** queues only.

  The difficulty is going to be modelling the FIFO (first-in-first-out)
  behavior accurately.
  You'll probably need at **least** one axiom with a case distinction using
  an `if` expression; the syntax for this in the `Array` specification for
  example.

  Doing this problem **without** resorting to Google may be rather helpful
  for the upcoming midterm.
  There's no need to submit the problem, but you **can** submit
  it if you wish; just include it at the **end** of your `README` file.


## Deliverables

Go to the assignment 4 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  Calc.java
  ArrayDequeue.java
  TestArrayDequeue.java
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
q
