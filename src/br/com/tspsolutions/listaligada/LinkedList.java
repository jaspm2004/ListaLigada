package br.com.tspsolutions.listaligada;

/**
 * Classe para representar uma ista ligada
 * 
 * @author José San Pedro
 */
public class LinkedList {
    private Node first, last;
    private int size;

    public LinkedList() {
        this.size = 0;
        first = last = null;
    }
    
    public void add(Object content) {
        Node newNode = new Node(content);
        newNode.setPrev(last);
        newNode.setNext(null);
        
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        
        size++;
    }
    
    public void add(int index, Object content) {
        Node temp = getNode(index);
        
        Node newNode = new Node(content);
        if (temp.getPrev() != null)
            temp.getPrev().setNext(newNode);
        else
            first = newNode;
        
        newNode.setPrev(temp.getPrev());
        newNode.setNext(temp);
        
        temp.setPrev(newNode);
        
        size++;
    }
    
    public Object getContent(int index) {
        return getNode(index).getContent();
    }
    
    /**
    * Retorna o conteúdo do nó da lista na posição, percorrendo a lista de trás para frente
    *
    * @param index posição do nô na lista
    * @return 
    */
    public Object getContentRwd(int index) {
        return getNodeRwd(index).getContent();
    }

    public void delete(int index){
        Node temp = getNode(index);
        // se há apenas um item na lista
        if (size == 1) {
            first = null;
            last = null;
        } else {
            // se é o primeiro da lista
            if (temp == first) {
                first = first.getNext();
                first.setPrev(null);
            } else 
            // se é último
            if (temp.getNext() == null) {
                last = temp.getPrev();
                last.setNext(null);
            } 
            // se não
            else {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
            }
        }
        
        size--;
    }
    
    private Node getNode(int index) {
        Node temp = first;
        int cont = 0;
        
        if (index + 1 <= size) {
            while (cont < index) {
                temp = temp.getNext();
                cont++;
            }
        } else {
            return null;
        }
        
        return temp;
    }
    
    private Node getNodeRwd(int index) {
        Node temp = last;
        int cont = 0;
        
        if (index + 1 <= size) {
            while (cont < index) {
                temp = temp.getPrev();
                cont++;
            }
        } else {
            return null;
        }
        
        return temp;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean find(Object contet) {
        return false;
    }
    
    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getContent().toString());
            temp = temp.getNext();
        }
    }
}