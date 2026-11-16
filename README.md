# Library Book Search — BST vs AVL vs Hashing

## Application
A library needs to find a book quickly using its unique Book ID. This project compares:
- Binary Search Tree (BST)
- AVL Tree (self-balancing BST)
- Hash table with Linear Probing

## Requirements
- Java JDK 8 or later
- Terminal / Command Prompt

## Run
Open a terminal in this folder and execute:

```bash
javac -d out src/LibraryBookSearch.java
java -cp out LibraryBookSearch
```

The program uses the same 40-book dataset for all three structures. It prints:
- BST and AVL inorder traversals
- Successful search (ID 1061)
- Unsuccessful search (ID 9999)
- Comparisons/probes for both searches
- BST and AVL heights
- Number of collisions during hash-table insertion
- An insertion test using ID 1125

Run the program yourself and copy the exact output into `REPORT.md`. Do not claim sample values as your own experimental observations.

## GitHub submission
1. Create a new GitHub repository.
2. Upload this complete folder (or push it using Git).
3. Copy the repository URL.
4. Submit that URL and the report through Google Classroom.

## Important
The dataset and test keys are defined near the bottom of `src/LibraryBookSearch.java`. For your viva, be ready to explain how changing the search key changes the path/probe sequence.
