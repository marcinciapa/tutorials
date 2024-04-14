Code for [Getting Started With Python course](https://www.amigoscode.com/courses/python)

# What I learned

## Getting Started

- `pyenv` is a convinient tool for managing multiple versions of Python (as NVM for NPM or `sdkman` for Java).
- Created and run "Hello World" program in Python

## The Basics

- Defining variables in Python doesn't require declaring type, when another type is assigned to the same variable, they
  are re-declared. However, specifying a type as also possible after `:`.
- Type of the variable can be obtained using `type(variable)` function
- Python is a dynamically typed language - types of variables are checked at runtime
- Indentations matter in Python. Sub-procedures need to be indented.

## Operators

- Python has `**` operator, which is POW

## Control Flow

- It's possible, when adding `f` letter before a string, to inform Python, that the string is formatted and contains
  placeholders. Placeholders will be replaced with values.
- Ternary operator in Python replaces `?` with `if` and `:` with `else`. Pretty simple and convenient.

## Data structures

- List in Python can contain values of different types
- `in` is a comparison in python, which returns true, when elements is present in collection
- List's `remove` method removes only the first instance of value
- `del` statement removes element from a list by index. It also allows removing elements of range (`del numbers[0:3]`,
  upper bound exclusive). When the range is exceeded, the error is not thrown.
- Lists are defined with `[]`. Sets are defined with `{}`.
- Order is not maintained in sets.
- Python has convenient operators to handle set operations (union, intersection, difference)
- Dictionary `{key: value}` is an equivalent of Map

## Loops

- `while` loop in Python may have `else` statement, which is invoked as soon as `while` condition is not met

## Functions

- Function definition starts with `def` keyword in Python
- It's easy to specify default values for arguments with value assignment: (`def greet(name, age=-1)`)
- It's possible to import the entire module (`import math`) or a single function from module (`from math import isqrt`)

## Classes

- A constructor in Python is defined as `def __init__(self...)`.
- All methods in Python class takes `self` as the first argument.
- Attributes of an object can be defined in a constructor, or in any other method. But they can be referenced after they
  were defined.
- In python overriding `__str__(self)` works the same as overriding `toString()` in Java

## Working with dates

- `datetime` module contains `datetime` and `date` modules containing date time functions (`now()`, `today()` etc)
- `datetime` object contains `strftime` method allowing formatting date and time

## Working with files

- To create a file it's enough to open a new file with `"w"` (write) mode: `open("file_name", "w")`
- File should be closed (`file.close()`) after working with it
- There is a convenient way to iterate through the lines of file (`for line in file:`) and extracting lines to
  collection: `file.readLines()`
- `with` syntax of working with files removes the need to close the file after operations on it. It works as try with
  resource in Java.
- It's easy to check if file exists after importing and using `os.path.isfile(file_name)`

## Fetching Data from Internet

- `request` from `urllib` module serves for HTTP communication
- `json` module helps to parse JSON objects