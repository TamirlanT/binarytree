1. Класс для работы с бинарным деревом:

public class BinaryTree {
    private Node root;

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // метод для добавления элемента в дерево
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
         else if (value > current.value) {
            current.right = addRecursive(current.right, value);
         else {
            // значение уже существует
            return current;
        }

        return current;
    }

    // методы для обхода дерева
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // метод для получения скобочной записи дерева
    public String getBracketNotation() {
        return getBracketNotationRecursive(root);
    }

    private String getBracketNotationRecursive(Node node) {
        if (node == null) {
            return "";
        }

        String left = getBracketNotationRecursive(node.left);
        String right = getBracketNotationRecursive(node.right);

        if (left.isEmpty()        right.isEmpty()) {
            return node.value + "";
        }

        if (right.isEmpty()) {
            return node.value + "(" + left + ")";
        }

        return node.value + "(" + left + ")(" + right + ")";
    }

        }
    }
}
2. Структура данных "Очередь" на основе массива:

public class Queue {
    private int[] elements;
    private int front; // индекс первого элемента в очереди
    private int rear; // индекс последнего элемента в очереди
    private int size; // текущий размер очереди

    public Queue(int capacity) {
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // метод для добавления элемента в очередь
    public void enqueue(int element) {
        if (rear == elements.length - 1) {
            rear = -1;
        }

        elements[++rear] = element;
        size++;
    }

    // метод для извлечения элемента из очереди
    public int dequeue() {
        int element = elements[front++];

        if (front == elements.length) {
            front = 0;
        }

        size–;

        return element;
    }

    // метод для проверки, пуста ли очередь
    public boolean isEmpty() {
        return size == 0;
    }

    // метод для проверки, заполнена ли очередь
    public boolean isFull() {
        return size == elements.length;
    }
}