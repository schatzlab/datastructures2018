javac -Xlint:all SimpleArray.java

javac -cp .:../../resources/junit-4.12.jar TestSimpleArrayMore.java
java -cp .:../../resources/junit-4.12.jar:../../resources/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestSimpleArrayMore
