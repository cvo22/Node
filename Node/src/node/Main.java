/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author Гамаюнов Иван
 */
// Пример использования.
public class Main {
    public static void main(String[] args) {
        // Создаем дерево.
        Node<String> root = new Node<>("root");
        Node<String> child1 = new Node<>("child1");
        Node<String> child2 = new Node<>("child2");
        Node<String> child3 = new Node<>("child3");
        Node<String> child4 = new Node<>("child4");
        Node<String> child5 = new Node<>("child5");
        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);
        child1.addChild(child4);
        child2.addChild(child5);

        // Создаем дерево.
        Tree<String> tree = new Tree<>(root);

        // Выводим дерево в глубину.
        System.out.println("Depth-first traversal:");
        tree.depthFirstTraversal(root);

        // Выводим дерево в ширину.
        System.out.println("Breadth-first traversal:");
        tree.breadthFirstTraversal(root);

        // Ищем узел по значению данных.
        Node<String> foundNode = tree.searchNode("child4");
        if (foundNode != null) {
            System.out.println("Node found: " + foundNode.getData());
        } else {
            System.out.println("Node not found.");
        }
    }
}
