import java.util.*;

public class LibraryBookSearch {
    static class Book {
        int id;
        String title;
        Book(int id, String title) { this.id = id; this.title = title; }
        public String toString() { return id + " - " + title; }
    }

    static class Node {
        Book book;
        Node left, right;
        int height = 1;
        Node(Book b) { book = b; }
    }

    static class BST {
        Node root;
        int comparisons;
        void insert(Book b) { root = insert(root, b); }
        Node insert(Node n, Book b) {
            if (n == null) return new Node(b);
            if (b.id < n.book.id) n.left = insert(n.left, b);
            else if (b.id > n.book.id) n.right = insert(n.right, b);
            return n;
        }
        Book search(int id) {
            comparisons = 0;
            Node n = root;
            while (n != null) {
                comparisons++;
                if (id == n.book.id) return n.book;
                n = id < n.book.id ? n.left : n.right;
            }
            return null;
        }
        void inorder() { inorder(root); }
        void inorder(Node n) {
            if (n != null) { inorder(n.left); System.out.print(n.book.id + " "); inorder(n.right); }
        }
        int height() { return height(root); }
        int height(Node n) { return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right)); }
    }

    static class AVL {
        Node root;
        int comparisons;
        int h(Node n) { return n == null ? 0 : n.height; }
        int balance(Node n) { return n == null ? 0 : h(n.left) - h(n.right); }
        Node rightRotate(Node y) {
            Node x = y.left, t = x.right;
            x.right = y; y.left = t;
            y.height = 1 + Math.max(h(y.left), h(y.right));
            x.height = 1 + Math.max(h(x.left), h(x.right));
            return x;
        }
        Node leftRotate(Node x) {
            Node y = x.right, t = y.left;
            y.left = x; x.right = t;
            x.height = 1 + Math.max(h(x.left), h(x.right));
            y.height = 1 + Math.max(h(y.left), h(y.right));
            return y;
        }
        void insert(Book b) { root = insert(root, b); }
        Node insert(Node n, Book b) {
            if (n == null) return new Node(b);
            if (b.id < n.book.id) n.left = insert(n.left, b);
            else if (b.id > n.book.id) n.right = insert(n.right, b);
            else return n;
            n.height = 1 + Math.max(h(n.left), h(n.right));
            int bf = balance(n);
            if (bf > 1 && b.id < n.left.book.id) return rightRotate(n);       // LL
            if (bf < -1 && b.id > n.right.book.id) return leftRotate(n);       // RR
            if (bf > 1 && b.id > n.left.book.id) { n.left = leftRotate(n.left); return rightRotate(n); } // LR
            if (bf < -1 && b.id < n.right.book.id) { n.right = rightRotate(n.right); return leftRotate(n); } // RL
            return n;
        }
        Book search(int id) {
            comparisons = 0;
            Node n = root;
            while (n != null) {
                comparisons++;
                if (id == n.book.id) return n.book;
                n = id < n.book.id ? n.left : n.right;
            }
            return null;
        }
        void inorder() { inorder(root); }
        void inorder(Node n) {
            if (n != null) { inorder(n.left); System.out.print(n.book.id + " "); inorder(n.right); }
        }
        int height() { return h(root); }
    }

    static class HashTable {
        Book[] table;
        int collisions;
        int comparisons;
        HashTable(int capacity) { table = new Book[capacity]; }
        int hash(int id) { return Math.floorMod(id, table.length); }
        void insert(Book b) {
            int index = hash(b.id);
            while (table[index] != null) {
                if (table[index].id == b.id) return;
                collisions++;
                index = (index + 1) % table.length;
            }
            table[index] = b;
        }
        Book search(int id) {
            comparisons = 0;
            int index = hash(id), checked = 0;
            while (table[index] != null && checked < table.length) {
                comparisons++;
                if (table[index].id == id) return table[index];
                index = (index + 1) % table.length;
                checked++;
            }
            return null;
        }
    }

    static Book[] data = {
        new Book(1042,"The Alchemist"), new Book(1017,"Wings of Fire"),
        new Book(1093,"Ponniyin Selvan"), new Book(1008,"The Hobbit"),
        new Book(1061,"Atomic Habits"), new Book(1025,"1984"),
        new Book(1104,"Thirukkural"), new Book(1033,"The Guide"),
        new Book(1078,"Ikigai"), new Book(1011,"Malgudi Days"),
        new Book(1086,"The Discovery of India"), new Book(1020,"The White Tiger"),
        new Book(1112,"Silappathikaram"), new Book(1054,"Deep Work"),
        new Book(1003,"A Brief History of Time"), new Book(1099,"The Great Gatsby"),
        new Book(1038,"Train to Pakistan"), new Book(1067,"The Blue Umbrella"),
        new Book(1014,"The God of Small Things"), new Book(1081,"Pride and Prejudice"),
        new Book(1047,"The Jungle Book"), new Book(1108,"Manimekalai"),
        new Book(1029,"The Old Man and the Sea"), new Book(1072,"Sapiens"),
        new Book(1006,"Harry Potter"), new Book(1059,"The Secret Garden"),
        new Book(1090,"The Catcher in the Rye"), new Book(1030,"The Namesake"),
        new Book(1117,"A Suitable Boy"), new Book(1064,"The Little Prince"),
        new Book(1019,"The Diary of a Young Girl"), new Book(1089,"The Fault in Our Stars"),
        new Book(1044,"The Lord of the Rings"), new Book(1101,"The Ramayana"),
        new Book(1023,"The Kite Runner"), new Book(1075,"The Midnight Library"),
        new Book(1001,"Charlotte's Web"), new Book(1051,"The Power of Habit"),
        new Book(1096,"The Secret"), new Book(1036,"The Last Leaf")
    };

    static void show(String label, Book b, int comparisons) {
        System.out.println(label + ": " + (b == null ? "NOT FOUND" : b) +
                           " | comparisons/probes = " + comparisons);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        AVL avl = new AVL();
        HashTable hash = new HashTable(101);

        for (Book b : data) {
            bst.insert(b);
            avl.insert(b);
            hash.insert(b);
        }

        int successKey = 1061; // existing book
        int failKey = 9999;    // absent book

        System.out.println("LIBRARY BOOK SEARCH - 40 RECORDS");
        System.out.println("\nBST INORDER TRAVERSAL:");
        bst.inorder();
        System.out.println("\nAVL INORDER TRAVERSAL:");
        avl.inorder();

        System.out.println("\n\nSUCCESSFUL SEARCH (ID " + successKey + ")");
        Book b1 = bst.search(successKey); show("BST", b1, bst.comparisons);
        Book b2 = avl.search(successKey); show("AVL", b2, avl.comparisons);
        Book b3 = hash.search(successKey); show("Hashing", b3, hash.comparisons);

        System.out.println("\nUNSUCCESSFUL SEARCH (ID " + failKey + ")");
        b1 = bst.search(failKey); show("BST", b1, bst.comparisons);
        b2 = avl.search(failKey); show("AVL", b2, avl.comparisons);
        b3 = hash.search(failKey); show("Hashing", b3, hash.comparisons);

        Book added = new Book(1125, "Computer Science Fundamentals");
        bst.insert(added); avl.insert(added); hash.insert(added);
        System.out.println("\nINSERTION TEST: " + added);
        System.out.println("Inserted into BST, AVL and Hash Table.");

        System.out.println("\nEXPERIMENT SUMMARY");
        System.out.println("Initial records: " + data.length);
        System.out.println("BST height: " + bst.height());
        System.out.println("AVL height: " + avl.height());
        System.out.println("Hash table capacity: " + hash.table.length);
        System.out.println("Hash collisions during initial insertion: " + hash.collisions);
        System.out.println("\nNote: Search comparison/probe counts above are measured by this program.");
    }
}
