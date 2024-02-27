/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Гамаюнов Иван
 */
class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    // Метод для обхода дерева в глубину.
    public void depthFirstTraversal(Node<T> node) {
        System.out.println(node.getData());
        node.getChildren().forEach((child) -> {
            depthFirstTraversal(child);
        });
    }

    // Метод для обхода дерева в ширину.
    public void breadthFirstTraversal(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            System.out.println(currentNode.getData());
            currentNode.getChildren().forEach((child) -> {
                queue.add(child);
            });
        }
    }

    // Метод для поиска узла по значению данных.
    public Node<T> searchNode(T data) {
        return searchNode(root, data);
    }

    private Node<T> searchNode(Node<T> node, T data) {
        if (node.getData().equals(data)) {
            return node;
        }
        for (Node<T> child : node.getChildren()) {
            Node<T> foundNode = searchNode(child, data);
            if (foundNode != null) {
                return foundNode;
            }
        }
        return null;
    }
}
