package br.com.tspsolutions.listaligada;

/**
 *
 * @author José San Pedro
 */
public class Test {

    /**
     * Classe para testes
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList lista1 = new LinkedList();
        lista1.add("Jose");
        lista1.add("Leandro");
        lista1.add(0, "Carlos");
        lista1.add(2, "Mathews");
        lista1.print();
        
        System.out.println();
        
        lista1.delete(3);
        lista1.print();
        
        System.out.println();
        
        lista1.add(1, "Flávio");
        lista1.print();
    }
}