# Assignment 9: StringOmics

- **Out on:** November 16, 2018
- **Due by:** November 30, 2018 before 10:00 pm
- **Collaboration:** None
- **Grading:**
  - Packaging 10%,
  - Style 10% (where applicable),
  - Testing 10% (where applicable),
  - Performance 10% (where applicable),
  - Functionality 60% (where applicable)

## Overview

The ninth assignment focuses on data structures and operations on strings. In this assignment you will implement encoding and decoding using the Burrows Wheeler Transform as well as encoding and decoding in a simple form of run length encoding. In the final problem you will be asked to measure the space savings using run length encoding with and without applying the Burrows Wheeler Transform first.

## Problem 1: Run Length Encoding & Decoding (30%)

Run Length Encoding (RLE) is a simple compression technique where "runs" of 2 or more consecutive occurrences a certain character are represented by a single instance of that character followed by the integer count of how many times that character occurred. For example, under this scheme this string

```
AAABBBBBBBBBBBBBBCDDDDCCCCBAAA
```

Would be represented as the more compact string

```
A3B14CD4C4BA3
```

In this example the RLE version of the string is only 13 characters whereas the original string is 30 characters long, saving 56% of the original space without any loss of information. Notice that if the length of the run is greater than 9 characters, the run length will require more than 1 numeral.

Using the `RLEEncoder.java` and `RLEDecoder.java` files provided to you, your first problem is to implement the empty `RLEEncoder.runLengthEncode()` and `RLEDecoder.runLengthDecode()` methods (you can implement other helper methods too if that keeps the code better organized). For this assignment, you may assume that the input files do not contain any numerals. If they did, the encoding scheme would need to be enhanced to distinguish between numerals that occur in the original text and numerals used to indicate the length of the run. You can also assume that the input string does not contain any non-ascii special characters, meaning you can compare the characters using the type `char` (or `Character`). Your output does not need to keep the same line breaks as the original text.

As always, your code must be checkstyle compliant and you must submit appropriate JUnit tests where you test your function of a variety of strings to encode and decode. You should also test your implementation on the command line and ensure that the output of your encoder can successfully be decoded by your decoder.

## Problem 2: Burrows Wheeler Transformation Encoding (30%)

The Burrows Wheeler Transformation (BWT) is a reversible permutation of a string that has many special properties. It is closely related to the `Suffix Array` and is derived from the last column of the Burrows Wheeler Matrix, which itself is formed by sorting all of the cyclic permutations of a string. The cyclic permutations use the special character `'$'` to mark the end of the string. The original application of the BWT was to transform a source text into a new form that was more easily compressed, although recently many new applications have been developed in string matching. These include the widely used Bowtie algorithm developed by JHU CS Professor Ben Langmead that is extensively used in genomics.

Using the `BWTEncoder.java` file provided to you, this problem is to implement the empty `BWTEncoder.createBWT()` method that constructs the BWT of the input string (you can implement other helper methods too if that keeps the code better organized). Faster linear time methods exist, although for this assignment you can use the simpler methods based on standard sorting techniques. However, you *should not* create an explicit String representation of all cyclic permutations, and your final program *should not* print out the Burrows Wheeler Matrix. Of course, during testing and development it may be helpful to print the Matrix. Instead you should create an array of the starting offsets for each of the cyclic permutations and use the indirect suffix comparison function that we discussed in class. Hint: if you store these offsets in an array of CyclicPermutation inner class objects that implements `Comparable<CyclicPermutation>` with the indirect comparison method, then you can sort the offsets using sort method in `java.util.Arrays`.

For this problem, you may assume that only characters with ASCII values greater than 36 (the value for `'$'`) are input meaning you can use `'$'` as the end of string character. Notably, this excludes the space character, exclamation point, double quote, and hash symbol. You can also assume that the input text does not have any special non-ascii special characters, allowing you to use `char` or `Character` as needed.

As always, your code must be checkstyle compliant and you must submit appropriate JUnit tests where you test your function of a variety of strings to encode.

## Problem 3: Burrows Wheeler Transformation Decoding (30%)

One of the essential properties of the BWT is that it can be reversed back into the source text without any other additional information. This is accomplished by iteratively applying the Last-First property starting with the first character of the BWT until reaching the end of string character `'$'`. The Last-First property states there is an equivalence between the ith occurrence of a character in the first column and the ith occurrence of that character in the last column. This equivalence can be evaluated by counting how many occurrences of a character are present in the BWT string (the last column of the BWM) or by counting characters in the first column (which you will have to determine from the BWT itself).

The pseudocode for reversing the string is as follows:

```
decodeBWT(String bwt)
  String firstCol = makeFirstColumn(bwt)
  StringBuilder text = new StringBuilder()

  // By construction, '$' always starts the zeroth row
  row = 0;
  while (bwt.charAt(row) != '$') {
      text.append(bwt.charAt(row));
      row = applyLF(firstCol, bwt.charAt(row), rank(bwt, row));
  }

  return text.reverse().toString()

```

Using the `BWTDecoder.java` file provided to you, this problem is to implement the missing `BWTDecoder.decodeBWT()` method that decodes the BWT into the pre-BWT source string (you can implement other helper methods too if that keeps the code better organized). Faster methods are possible, but your code *may* explicitly compute the rank of a character by counting from the beginning of the string. Your code *may* also store the first column of the Burrows-Wheeler Matrix in a String. Your code *may not* explicitly store the entire matrix as that would require O(n^2) space (although during testing and development that may be helpful).

For this problem, you may assume assume all of the constraints of the previous problem: only characters with ASCII values greater than 36 (the value for `'$'`), etc. Your output does not need to keep the same line breaks as the original text.

As always, your code must be checkstyle compliant and you must submit appropriate JUnit tests where you test your function of a variety of strings to decode. You should also test your implementation on the command line, especially to ensure that your decode function can correctly process the output of your encode function.

## Problem 4: Compression Test (10%)

This problem does not require any new code development, and instead asks you to apply the code you developed in problems 1-3 to transform 4 test files and then discuss the results in the README file. Specifically your problem is to measure the filesize of (1) the source text, (2) the run length encoded version, (3) the BWT version, and (4) the run length encoded BWT version. You can use the UNIX command `wc -c filename` to count the number of characters in each file. In addition to the filesizes, record the time it takes to encode or decode each file (using `xtime`). In your README, make a table  with the filesizes and encode/decode times. Then write a short paragraph (3-4 sentences) to comment on which files showed the greatest or least change in size and *why*.

For this problem you should evaluate the following texts (provided on github):

* `tale.snippet.txt` A snippet of A Tale of Two Cities
* `tale.book1.txt` Book 1 of A Tale of Two Cities
* `random.small.txt` A small random text file
* `random.large.txt` A large random text file


## Hint: StringBuilder instead of String +

The Java `String` class provides a number of useful methods for accessing individual characters or substrings from an existing string. However `String` variables are immutable, meaning that they cannot be changed and you would need to instead create an entirely new String object. In general you should avoid the `String +` operator to concatenate many strings together as this will create potentially many small `String` objects (it is fine for merging 2 or 3 strings though). Instead, Java provides a `StringBuilder` class that can should be used for concatenating many strings together. See the Javadocs for details.

If you have other questions, please ask on Piazza!

## Hint: Exceptions and special characters

The RLE encoder/decoder should throw an IOException if the input string has unexpected numerals or special characters, and the BWT encoder/decoder should throw an IOException if the input string has invalid characters. The BWT and RLE encoder/decoder should throw an IOException on null input. The RLE encoder/decoder should return an empty string if the input is an empty string (it is perhaps silly to encode/decode an empty string, but is not an error). The BWT encoder should correctly process an empty string, meaning it should return '$'. The BWT decoder should throw an IOException on an empty string, or any input that doesnt contain exactly one '$' character.

## Deliverables

Go to the Assignment 8 page for Gradescope and click submit. Note that you can resubmit any time up until the deadline. You will be prompted to upload your files at which point you will upload all of the necessary source files. In the future we might not list them out, but for this assignment they are listed explicitly below:

```
  README
  RLEEncoder.java
  RLEDecoder.java
  BWTEncoder.java
  BWTDecoder.java
  RLETest.java
  BWTTest.java
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
