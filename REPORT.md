# CONTINUOUS LEARNING ASSESSMENT – 2
## ALGORITHM BATTLE: WHICH DATA STRUCTURE WINS?
### Application: Library Book Search

**Name:** ____________________  
**Register Number:** ____________________  
**Course:** ____________________  
**Institution:** SRM Institute of Science and Technology, Tiruchirappalli

---

## Part A – Problem Selection

### 1. What is the problem?
A library stores many books. Each book has a unique Book ID and a title. A user or librarian must find a book using its ID. Searching every record one by one becomes inefficient as the collection grows.

### 2. Why is efficient searching required?
Efficient searching reduces the time needed to locate books, improves the library service and supports larger collections. The Book ID is used as the search key.

### 3. Why are BST, AVL and Hashing suitable?
- **BST:** Stores keys in sorted tree order and supports searching and inorder traversal.
- **AVL Tree:** A self-balancing BST that controls tree height, keeping search efficient.
- **Hashing:** Maps a Book ID to a table index and can provide very fast average-case lookup. Linear Probing resolves collisions by checking the next available slot.

## Part B – Implementation

The Java program in `src/LibraryBookSearch.java` implements all three structures using the same 40 unique Book ID/title records.

### Operations
1. **Insertion:** Adds each book to BST, AVL and hash table.
2. **Searching:** Tests an existing key (`1061`) and a missing key (`9999`).
3. **Traversal:** Inorder traversal is displayed for BST and AVL. It prints Book IDs in ascending order.
4. **Collision handling:** Hashing uses Linear Probing. If a calculated slot is occupied, the next slot is checked until an empty slot is found.

## Part C – Mini Experiment

### Dataset
40 unique book records are included in the Java source file. The same records and test keys are used for all three methods.

### Test cases
- Successful search: Book ID `1061` (present in dataset).
- Unsuccessful search: Book ID `9999` (not present).
- Insertion test: Book ID `1125`, title `Computer Science Fundamentals`.

### Experimental observations — fill from your own program run

Run the program using the instructions in `README.md`. Copy the exact values printed by your run into this table.

| Parameter | BST | AVL | Hashing |
|---|---:|---:|---:|
| Comparisons/probes — successful search (1061) | ____ | ____ | ____ |
| Comparisons/probes — unsuccessful search (9999) | ____ | ____ | ____ |
| Height | ____ | ____ | Not applicable |
| Collisions during initial insertion | Not applicable | Not applicable | ____ |
| Insertion test (ID 1125) | Successful | Successful | Successful |

**Attach or paste your terminal output here:**  
[Paste your actual program output]

## Part D – Algorithm Battle

| Parameter | BST | AVL | Hashing with Linear Probing |
|---|---|---|---|
| Search | Average O(log n), worst O(n) | O(log n) worst case | Average O(1), worst O(n) |
| Insertion | Average O(log n), worst O(n) | O(log n), includes balancing | Average O(1), worst O(n) |
| Height | Can become skewed | Kept balanced | Not applicable |
| Collision handling | Not applicable | Not applicable | Linear Probing |
| Traversal | Inorder, preorder, postorder possible | Inorder, preorder, postorder possible | No tree traversal |

### Analysis
A normal BST can become unbalanced depending on insertion order. AVL uses rotations to maintain balance, so its height is controlled and its worst-case search time is logarithmic. Hashing is generally suitable for exact Book ID lookup because it does not need to maintain sorted order. However, collisions can increase the number of probes, and the performance depends on the table size and load factor.

Use the measured values from your run to explain which method performed best for the chosen test dataset. Do not decide only from theoretical complexity; refer to the actual comparison/probe counts and tree heights.

## Part E – Final Verdict

**Recommended structure:** Hashing with Linear Probing for a library system whose main requirement is exact search by unique Book ID.

**Justification:** Hashing is expected to provide constant-time average search and insertion when the table is suitably sized and collisions are limited. Linear Probing handles collisions without requiring linked lists or tree nodes. If the library also needs sorted output, range searches or ordered traversal, an AVL Tree is a stronger choice. The final conclusion should be checked against the actual output from your experiment.

## Viva Preparation

1. **What is a BST?**  
   A binary tree where smaller keys are stored on the left and larger keys on the right.

2. **What is the main advantage of AVL?**  
   It automatically balances itself after insertion using rotations.

3. **What is the balance factor?**  
   Height of left subtree minus height of right subtree. In an AVL tree it must be -1, 0 or +1.

4. **Name the four AVL rotations.**  
   LL, RR, LR and RL.

5. **What is hashing?**  
   A technique that maps a key to an array index using a hash function.

6. **What is a collision?**  
   Two different keys produce the same table index.

7. **How does Linear Probing work?**  
   It checks the next table position sequentially until it finds an empty slot or the key.

8. **Why is inorder traversal useful?**  
   It displays BST/AVL keys in ascending order.

9. **Why can a BST become slow?**  
   If insertions create a skewed tree, its height can become n and search can take O(n).

10. **Which is recommended here?**  
    Hashing for exact Book ID lookup; AVL if ordered traversal and guaranteed logarithmic search are also important.

11. **What happens if a new key is inserted?**  
    BST follows comparisons to a leaf position; AVL inserts and rebalances if required; hashing computes an index and uses Linear Probing if occupied.

12. **What is the difference between successful and unsuccessful search?**  
    Successful search finds the key; unsuccessful search checks until it can determine the key is absent.

## Conclusion

This assignment compares BST, AVL Tree and Hashing with Linear Probing for Library Book Search using one common dataset. The program measures search comparisons/probes, tree heights and hash collisions. The final recommendation is based on both theoretical complexity and the measured output recorded by the student.

---
**Academic integrity note:** Run the program, inspect the code, enter your own name/register number, and complete the observation table using your own execution. Be prepared to explain each operation during viva.
