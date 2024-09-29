## Pattern Oriented Software Design 2024 Fall Assignment

## Important Links
- [Course Link](http://140.124.181.100/yccheng/posd2024f)
- [Gitlab](http://140.124.181.100)
- [Jenkins](http://140.124.181.97:8080)
- [Microsoft Teams](https://teams.microsoft.com/l/team/19%3AoQBubdF152LO2WVrJMRHVX7rOx0wb_v4twMSorq8Va81%40thread.tacv2/conversations?groupId=f0cff185-d612-415d-8bf9-76ed37baeee0&tenantId=dfb5e216-2b8a-4b32-b1cb-e786a1095218)
- [Environment Setting](http://140.124.181.100/course/posd2024f_ta/tree/environment_setting)

## Assignment List

* [Assignment 1](http://140.124.181.100/course/posd2024f_ta/tree/assignment1): Due 9/15 23:59
* [Assignment 2](#assignment-2): Due 10/7 13:00

## Assignment 2
**Deadline**: 13:00 on Oct 7, 2024.

**Notice**: 
1. If your code fails to compile on jenkins server, you'll get no point for the assignment. 
2. If the unit tests written by yourself fails, you'll get no point for the unit tests written by TA.

Here's [the code](http://140.124.181.100/course/posd2024f_ta/-/tree/assignment_template_code) modified from the code written in class, please download and add them to your homework repository.

**Note: Each class in the sample file is the skeleton. You should finish implementation by yourself.**

For this Assignment, you'll [extend the assignment 1](#specification-1-extend-assignment-1), [implement the **Composite pattern**](#specification-2-composite-pattern), and [implement the **Iterator pattern**](#specification-3-iterator-pattern).

Please complete the given code to satisfy all the following conditions.

### Specification 1: Extend Assignment 1
* Please implement the following class - `TwoDimensionalVector`.
	- The class `TwoDimensionalVector` is a vector in 2D space. It has two attributes, `x` and `y`, which are the coordinates of the vector.
	- The class `TwoDimensionalVector` has the following methods:
		- `length()`: calculate the length of the vector and return a double value.
		- `dot()`: calculate the dot product of two vectors and return an int value.
		- `cross()`: calculate the cross product of two vectors and return an int value.
		- `subtract()`: subtract two vectors and return a new vector.

* Please implement new shapes - `ConvexPolygon`.
	- The vectors which used to create the ConvexPolygon need to be sorted in the clockwise direction or counterclockwise direction, the unsorted vectors are unavailable and needs to throw the **ShapeException**.

* Please revise the shape - `Triangle` to construct by `TwoDimensionalVector`.

* Please do exception handling if the shape can't be successfully created.(The excepton type of the TA's test will be **ShapeException** and throw `It's not a circle!`, `It's not a rectangle!`, `It's not a triangle!`, `It's not a convex polygon!`)

* The `ShapeException` class is already implemented in the code. You can use it directly.

* You can remove the unused classes - `Geo`, `InputOutput` and methods - `toString()`.

### Specification 2: Composite Pattern
* Please implement the following class - `CompoundShape`.
	- The class `CompoundShape` is a shape that contains multiple shapes. It has a list of shapes as its attribute.
	- The class `CompoundShape` has the following methods:
		- `area()` : calculate the total area of the shapes in the list and return a double value.
		- `perimeter()`: calculate the total perimeter of the shapes in the list and return a double value.
		- `add()`: add a shape to the list.

* Please implement the default method - `add()` in interface `Shape`.
    - The method `add()` is to throw a **ShapeException** with the message `Illegal Operation`.

### Specification 3: Iterator Pattern.
* Please implement the following class - `NullIterator`.
	- The class `NullIterator` is an iterator for the `Circle`, `Rectangle`, `Triangle`, and `ConvexPolygon`. It has the following methods:
		- `hasNext()`: always return false.
		- `next()`: throw **NoSuchElementException** with the message `Null iterator does not point to any element`.

* Please implement the following method - `iterator` in class `CompoundShape`.
	- The method `iterator` is to return an iterator for the `CompoundShape`.
		- `hasNext()`: return true if the iterator has more elements.
		- `next()`: return the next element in the iteration.

* Please implement the default method - `iterator()` in interface `Shape`.
    - The method `iterator()` is to return a null iterator


* For each function/method/requirement, write at least one unit test for it.

* Please make your directory follow the following file structure:

```
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── org
    │           └── ntut
    │               └── posd2024f
    │                   └── shapes
    │                       ├── Circle.java
    │                       ├── CompoundShape.java
    │                       ├── ConvexPolygon.java
    │                       ├── NullIterator.java
    │                       ├── Rectangle.java
    │                       ├── Shape.java
    │                       ├── ShapeException.java
    │                       ├── Sort.java
    │                       ├── Triangle.java
    │                       └── TwoDimensionalVector.java
    └── test
        └── java
            └── org
                └── ntut
                    └── posd2024f
                        └── shapes
                            ├── CircleTest.java
                            ├── CompoundShapeTest.java
                            ├── ConvexPolygonTest.java
                            ├── NullIteratorTest.java
                            ├── RectangleTest.java
                            ├── ShapeTest.java
                            ├── SortTest.java
                            ├── TriangleTest.java
                            └── TwoDimensionalVectorTest.java
```
## Score
1. Unit tests written by yourself: 35%.
2. Unit tests written by TA: 35%.
3. Correctness pattern implementation: 30%.

## References
* [static class](https://www.geeksforgeeks.org/static-class-in-java/)

* [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)

* [YC Cheng's blog about polygon](http://htsicpp.blogspot.com/2014/10/convex-polygon.html)

* [Oracle Java Document](https://docs.oracle.com/javase/8/docs/api/index.html)


