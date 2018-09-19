javac -Xlint:all Stack.java ListStack.java EmptyException.java

javac -cp .:../../../resources/junit-4.12.jar TestListStack.java

java -cp .:../../../resources/junit-4.12.jar:../../../resources/hamcrest-core-1.3.jar \
      org.junit.runner.JUnitCore TestListStack
