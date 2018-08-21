You can use this folder to verify you have the tools needed and working to complete the class.

* [Java](#java)
* [JUnit](#junit)
* [Checkstyle](#checkstyle)

---

## Java
To compile the hello world test file:
`$ javac -Xlint:all Hello.java`

If you have my aliases, you can also just do `$jc Hello.java`

Then to run the compiled program just run
`$ java Hello`

You can clean the .class files by running `$ rm *.class`

## JUnit
JUnit runs from a jar file, so you have to know where that file is installed. If you are using the VM, this is taken care of for you and is already aliased. But you can compile JUnit tests in the following way:
`$ java -classpath <path_to_junit_jar>:. HelloTest.java`

If you have the alias from us, you can just run `$ junitc HelloTest.java`

To run the unit tests, you need to classpath to run the JUnit runner with your file like so:
`$ java -classpath <path_to_junit_jar>:. org.junit.runner.JUnitCore HelloTest`

Again if you have the aliases this could be done by `$ junit HelloTest`

To see what JUnit output looks like when there is an error, try changing a `true` to a `false` in the code and trigger a failed test.

## Checkstyle
Checkstyle is again run from a jar file (there are other ways but I find this the most straightforward). It takes a configuration file to know the style being enforced and a list of whatever Java files you want to check the style for. We don't generally enforce JUnit tests to be checkstyle compliant, so try running checkstyle on the Hello.java file. To run checkstyle you can do the following:
`$ java -classpath <path_to_checkstyle_jar> -c <path_to_config_xml> Hello.java`

Checkstyle should run and you will see the "Starting Audit..." message followed by the "Audit Done". Again, you can have this aliased as `$ check Hello.java`

To see an example of checkstyle reporting errors, go ahead and add some random spaces/tabs in, or remove some JavaDocs. If you re-run checkstyle you will get the error report for what was wrong.
