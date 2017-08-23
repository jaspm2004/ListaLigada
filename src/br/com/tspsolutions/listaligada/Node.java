package br.com.tspsolutions.listaligada;

/**
 * Classe para representar os nós da lista
 * 
 * @author José San Pedro
 */
public class Node {
    private Node prev, next;
    private Object content;

    public Node(Object content) {
        this.content = content;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}