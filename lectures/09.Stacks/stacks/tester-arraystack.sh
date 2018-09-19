javac -Xlint:all Stack.java ArrayStack.java EmptyException.java

javac -cp .:../../../resources/junit-4.12.jar TestArrayStack.java

java -cp .:../../../resources/junit-4.12.jar:../../../resources/hamcrest-core-1.3.jar \
      org.junit.runner.JUnitCore TestArrayStack
