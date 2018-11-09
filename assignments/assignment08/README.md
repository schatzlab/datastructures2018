# Assignment 9: Competitive Spelling Bee

- **Out on:** November 9, 2018
- **Due by:** November 16, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Packaging 10%,
  - Style 10% (where applicable),
  - Testing 10% (where applicable),
  - Performance 30% (where applicable),
  - Functionality 40% (where applicable)

## Overview

The eighth assignment is a little more **open-ended** than what you're
probably used to for this course.
We no longer break things down into **separate** problems below, **the
entire assignment *is* the problem now.**
This also means that the "rubric" for the assignment **is** the grading
breakdown above, and it **all** applies.

Your "one" task for this assignment is to take the simple **spell
checker** we give you and to turn it into the **fastest**, most
**memory-efficient** spell checker in the course, subject to the
**constraints** detailed below.
You are expected to do this by (once again) implementing the `Map`
interface, this time using one of several **hash table** techniques
(your choice, see below).

**Important:**
The 30% for Performance will be awarded by **ranking** your submissions
according to both **time** and **space** required by your spell checker.
Less time is better, less space is better, and both are considered
**separately** for 15% each.
So one submission might win in both categories, or different submissions
might win in each, it all depends.
Submissions that are tied (perform almost the same in our benchmarks) will
receive the same rank (in the respective dimension);
it's theoretically possible (although **highly** unlikely) for all
submissions to be tied.

**Note that your spell checker must produce correct results in
order to take part in the performance tournament!**
If that wasn't the case, winning in the tournament would be trivial:
Just submit a solution that does nothing.
Obviously that's not okay...

## The Spell Checker

The good news is that you don't actually have to write the spell checker:
We hand you `Spell.java` for free!
Here's a quick example for how it works:

```
$ java Spell
Error: Need path to dictionary file!
$ java Spell ogden.dict
I know how to program.
know
program
```

As you can see `Spell` expects the name of a dictionary file as the
sole command line argument.
It reads that dictionary file into a `Map` and then proceeds to read
words from standard input.
It tries to find each word in the `Map` it generated and it prints
out the words it doesn't know, assuming they are spelling errors.
(So input without spelling errors results in no output whatsoever.)
Obviously the `ogden.dict` dictionary is not very complete (indeed
it only contains 852 words, not nearly enough for a decent spell
checker) so it thinks `know` and `program` are spelling errors.

You can find `Spell.java` on github.
We have also posted a tarball `spell.tar.gz` that contains three
different dictionaries, three different example texts to check,
and the expected errors that should be output for some of those
combinations.

You can determine how well `Spell` is doing using the familiar
`xtime` script (which we'll also use for ranking, albeit in a
slightly modified form) from previous assignments.
Here are two examples for benchmarking:

```
$ ./xtime java Spell ogden.dict <democracy.txt >/dev/null
3.08 seconds 190416 kilobytes java Spell ogden.dict
$ ./xtime java Spell scowl-small.dict <sanity.txt >/dev/null
67.45 seconds 211520 kilobytes java Spell scowl-small.dict
```

All these files are available to you, and you should probably start
by trying to figure out why `Spell.java` (before you add your new,
improved `Map` implementation) is only useful for **tiny**
dictionary files.

Note that you **must** use the `Spell.java` program as provided on
github.
The **only** change you're allowed to make is to replace `new SimpleMap`
with `new HashMap` for your new `Map` implementation.
(We will use our own `Spell.java` for grading, so if you made changes
to yours, those changes will "disappear" for grading.)

## The Hash Table

You are supposed to improve the performance of `Spell.java` by
replacing its use of `SimpleMap` with a new `HashMap` class you
write.
Obviously your `HashMap.java` has to implement the `Map`
interface, but beyond that you have **quite** a few options
for how to proceed:

- Your hash table can use any of the following techniques
  (but no others!):
  **separate chaining**,
  **open addressing**, or
  **cuckoo hashing**.

- For open addressing you can resolve collisions by
  **linear probing**,
  **quadratic probing**, or
  **double hashing**.
  (Make sure you understand how the various strategies
  relate to the size of the bucket array.)

- For cuckoo hashing and double hashing you'll need
  (an approximation of)
  **universal hashing**
  (hash functions generated at random with low probability
  for mutual collisions).

- You may implement a bloom filter as a prefilter, but your program must produce
  correct output with zero false positives

We're actually happy to help those adventurous folks who stroll
all the way into universal hashing territory:
You can find `UniversalHashes.java` on github, a class that
implements two common constructions for universal hash functions.
**Just be warned that the code is pretty new and might contain a
bug or three.** (You can't blame us later if your stuff doesn't
work: It's "free code" so it comes with "no warranties" of any
kind. Don't use it if you're worried about it breaking.)

As `HashMap.java` is the "big piece of code" you have to write and
submit this week, you obviously need "all the usual pieces" for it.
In particular:

- You **must** have JUnit 4 test cases. You **may** be able to reuse
  test cases from the previous assignment, however you better make
  sure that they are complete and cover **all** operations (including
  the `iterator()` and `toString()` methods) and exception conditions.
  (Also, if you're still not using base classes for testing against an
  interface, make **sure** you finally start doing so.)
- You **must** have a [jaybee](http://https://github.com/phf/jb)
  benchmark driver. You **may** be able
  to reuse benchmarks from the previous assignment, however you better
  make sure that they are complete and applicable to `HashMap` as well.

And that's it.
Yes, you're **really** on your own for figuring out what kind of hash
table you should implement.
Just a word of caution: The code in the lecture notes is **not**
exactly great.
You should probably only consider it as a starting point if you really
have no idea what else to do.

**All critical map operations, except `insert`, must run in O(1)
*expected* time (or better); `insert` can run in O(1) *amortized*
time in case you have to grow the bucket array table to keep the
load factor down.**

### Got Extra Hash Tables?

Depending on just how serious you are about those Performance points,
you may well end up writing **several** different hash tables over the
course of this assignment.
However, you have to pick **one** of those as your `HashMap.java` and
submit it under that name.
Presumably you'll pick the best one, but if you want to submit any
of the others you wrote (not required, strictly optional) make sure
you give them **different** names that express what **kind** of
hash table you used.
(So, for example, if in addition to your "winning" `HashMap.java`
you also implemented a hash table using separate chaining, call
that one `ChainingHashMap.java` or something similar.
Whichever one you call `HashMap.java` is the one we'll run against
everybody else's code.)

## Iterative Development

You cannot know how fast your `HashMap` is until it's actually
written.
You cannot improve your `HashMap` until you can tell how fast
it is.
So the worst mistake you can make is to "think about it" for days
without writing any code.
(Thinking ahead is good in principle, thinking ahead for too long
is the problem here.)

We recommend you start **right now** by writing the simplest
`HashMap` you can think of and making that work.
For example you could write one based on separate chaining but
with a fixed array size.
Are you going to win with that? No!
But at least now you've started playing the game.

You want your test cases and benchmarks in place before you keep
going.
Make sure that your test cases are complete and that your benchmarks
tell you how well the various `Map` operations work for that first
version of `HashMap`.
You should probably save a backup (or even submit early!) as soon
as you get done with the first round.

From then on, it's "try to improve things" followed by "see if the
tests still pass" followed by "benchmark to see if things actually
got better" followed by either "Woops, that was a bad idea, let's
undo that" or "Yay, I made progress, let's save a backup of the
new version" and so on and so forth.
We predict that there will be a correlation between how well you
do and how often you "went around" this iterative development cycle.

### What Classes Are Allowed?

You may use `java.util.ArrayList` and `java.util.LinkedList` if you
wish.
You may **not** use fancier Java collection classes, in particular
you may **not** use `java.util.HashMap` to implement your `HashMap`.

You may use the `SimpleArray` and `NodeList` classes we handed out
earlier in the semester if you wish.
You may **not** use other `Set` or `Map` implementations to
hack your `HashMap` though.

If you want to use some other data structure class, better ask on
Piazza first!
You don't want to find out minutes before the deadline that you
used something that's not okay...

### What about the README?

You should use your `README` file to explain how you approached
this assignment, what you did in what order, how it worked out,
how your plans changed, etc.
Try to summarize all the different ways you developed, evaluated,
and improved your `HashMap` over time.
If you don't have a story to tell here, you probably didn't do
enough...

### Random Hints

- You have at least two more `Map` implementations from the last
  assignment. Use those to set some goals for how fast your new
  hash table should be. (You should **certainly** be able to beat
  `AvlTreeMap`; beating `TreapMap` is harder, but not impossible.)
- We'll try to run a few "tournaments" ahead of time, but in order
  to do that you'll have to submit early: We can only run your
  code against others if we actually have it! So if you want to
  know where you are in the rankings **before** the deadline, submit
  early (and maybe often).
- All the benchmarking advice we gave on the last two assignments
  pretty much still holds for this one.
  In particular, you may want to look into using the profiler if
  you cannot think of any other ways to improve the performance of
  your `HashMap` anymore.
- You should probably keep track of how the performance changed
  over various versions of your `HashMap` implementation. If you
  don't do that, you may end up with changes that made things
  worse but you never noticed since you didn't have the data to
  check.


## Deliverables

Go to the Assignment 8 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  HashMap.java
  HashMapTest.java
  HashMapBench.java
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
