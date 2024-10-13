# Word List Processing

This project consists of various checkpoints aimed at practicing fundamental Java programming concepts such as class design, input/output handling, array manipulation, and sorting. It also builds a word list processing application, allowing users to add, view, and manipulate a list of words.

## Basic I/O and Output Formatting

- Read and reverse multiple lines of user input and print them in reverse order with numbered lines.

## Creating and Using Classes

### Goal:
- Store input lines along with their sequence number in a custom `Line` class and print them in reverse order.


## Building a Word List Application

### Goal:
- Create a word list processing application that reads words from the user and displays the first, last, and entire list of words.

### Steps:
1. Create a `Words` class and a `WordList` class.
2. Implement methods in `WordList` to store and return words.
3. Modify `getFirst()`, `getLast()`, and `toString()` methods for proper functionality.


## Sorting Words Alphabetically

### Goal:
- Sort the word list in alphabetical order.

## Advanced Word List Processing

### Goal:
- Implement methods to compute the average length of words and sort words by their length.


# Dog Application and Bracket Checker

## Overview

This project consists of two main components: a Dog management application and a Bracket Checker utility. The Dog application allows you to create and manage dog objects, including their breeds, registration numbers, and owners. The Bracket Checker checks for balanced brackets in strings and files, helping to validate code syntax or similar tasks.

## Table of Contents

- [Dog Application](#dog-application)
  - [Features](#features)
  - [Classes](#classes)
  - [Usage](#usage)
- [Bracket Checker](#bracket-checker)
  - [Features](#features-1)
  - [Classes](#classes-1)
  - [Usage](#usage-1)
- [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Dog Application

### Features

- Create and manage `Dog` objects.
- Add and manage dog owners using a `Set` to ensure unique names.
- Count total number of `Dog` objects created.
- Maintain a register of dogs, including methods to add, retrieve, and delete dogs.

### Classes

1. **Dog**
   - Attributes: `name`, `dogBreed`, `regNum`, `owners` (Set<String>), `seqNum`.
   - Methods: `toString()`, `addOwner()`, `getOwners()`, `printTotal()`, and static methods for counting dogs.

2. **DogRegister**
   - Attributes: A list to maintain the dog register.
   - Methods: `addDog()`, `getDog()`, `deleteDog()`, `getDogsWhoseNameContains()`, and `GroupByBreed()`.

### Usage

To run the Dog application, compile the Java files and run the `DogBreeder` class, which contains the `main` method to demonstrate the functionalities.

# GUI Calculator

## Overview

This project involves the implementation of a simple GUI calculator in Java. The calculator will support basic arithmetic operations, additional mathematical functions, and memory functionality. The layout and overall appearance of the calculator must adhere to specific design specifications.

![Simple GUI Calculator](../assets/finished_calculator.png "Simple GUI Calculator")

**Important:** Please ensure you read and understand the entire document before you start coding. If clarification is needed, please seek assistance as soon as possible.



### Customization
- **Replace** `yourusername` with your actual GitHub username or organization.
- **Add License Information** if you have a specific license for your project.
- **Adjust any features, classes, or methods** according to the actual implementation details of your project.
- **Add examples or usage instructions** if you have specific input/output examples you'd like to showcase.

Feel free to modify it further to suit your project’s requirements!
