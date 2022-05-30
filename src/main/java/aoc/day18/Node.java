package aoc.day18;

import java.util.Optional;

public class Node {

    private Integer value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(Node clone) {
        if (clone.value != null) {
            value = clone.value;
        } else {
            left = new Node(clone.left);
            right = new Node(clone.right);
            left.parent = this;
            right.parent = this;
        }
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        left.parent = this;
        right.parent = this;
    }

    public void reduce() {
        boolean applied = true;
        while (applied) {
            applied = explode(0) || split();
        }
    }

    private boolean split() {
        if (value != null && value >= 10) {
            left = new Node((int) Math.floor(value / 2.0));
            right = new Node((int) Math.ceil(value / 2.0));
            left.parent = this;
            right.parent = this;
            value = null;
            return true;
        }
        return (left != null && left.split()) || (right != null && right.split());
    }

    private boolean explode(int depth) {
        if (value == null && left.value != null && right.value != null && depth == 4) {
            getLeafNodeToTheLeft(this).ifPresent(i -> i.value += left.value);
            getLeafNodeToTheRight(this).ifPresent(i -> i.value += right.value);
            value = 0;
            left = null;
            right = null;
            return true;
        }
        return (left != null && left.explode(depth + 1)) || (right != null && right.explode(depth + 1));
    }

    private static Optional<Node> getLeafNodeToTheLeft(Node current) {
        if (current == null || current.parent == null) {
            return Optional.empty();
        }
        if (current.parent.left != current) {
            var leaf = Optional.ofNullable(current.parent.left).flatMap(Node::getRightChildLeafNode);
            if (leaf.isPresent()) {
                return leaf;
            }
        }
        return getLeafNodeToTheLeft(current.parent);
    }

    private static Optional<Node> getLeafNodeToTheRight(Node current) {
        if (current == null || current.parent == null) {
            return Optional.empty();
        }
        if (current.parent.right != current) {
            var leaf = Optional.ofNullable(current.parent.right).flatMap(Node::getLeftChildLeafNode);
            if (leaf.isPresent()) {
                return leaf;
            }
        }
        return getLeafNodeToTheRight(current.parent);
    }

    private Optional<Node> getLeftChildLeafNode() {
        if (value != null) {
            return Optional.of(this);
        }
        var leftLeaf = Optional.ofNullable(left).flatMap(Node::getLeftChildLeafNode);
        if (leftLeaf.isPresent()) {
            return leftLeaf;
        }
        return Optional.ofNullable(right).flatMap(Node::getLeftChildLeafNode);
    }

    private Optional<Node> getRightChildLeafNode() {
        if (value != null) {
            return Optional.of(this);
        }
        var rightLeaf = Optional.ofNullable(right).flatMap(Node::getRightChildLeafNode);
        if (rightLeaf.isPresent()) {
            return rightLeaf;
        }
        return Optional.ofNullable(left).flatMap(Node::getRightChildLeafNode);
    }

    public Node add(Node right) {
        Node result = new Node(new Node(this), new Node(right));
        result.reduce();
        return result;
    }

    public int getMagnitude() {
        if (value != null) {
            return value;
        }
        return 3 * (left != null ? left.getMagnitude() : 0) + 2 * (right != null ? right.getMagnitude() : 0);
    }

    @Override
    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "[" + left + "," + right + "]";
    }
}
