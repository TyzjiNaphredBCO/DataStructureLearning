## Problem: Nested List Management
Description: You are tasked with implementing a nested list management system using a stack of lists. Your program will support the following operations:
- Add List: Create a new list with specified elements and push it onto the stack.
- Remove List: Pop the top list from the stack and return its contents.
- Add Element: Add an element to the top list without removing it.
- Display Top List: Print the contents of the top list without removing it.

Input/Output Specification
- Input: A series of commands (strings) that dictate the operations to be performed.
  - ADD_LIST element1, element2, ... (to create a new list and add elements)
  - REMOVE_LIST (to pop the top list)
  - ADD_ELEMENT element (to add an element to the top list)
  - DISPLAY (to display the top list's contents)
- Output: For each REMOVE_LIST and DISPLAY command, output the result.


## Example
Input:
> ADD_LIST apple, banana

> ADD_LIST cherry, date

> DISPLAY

> ADD_ELEMENT elderberry

> DISPLAY

> REMOVE_LIST

> DISPLAY
