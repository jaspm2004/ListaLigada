package br.com.tspsolutions.listaligada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe principal
 * 
 * @author José San Pedro
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList lista1 = new LinkedList();
        preecheLista1(lista1);
        
        LinkedList lista2 = new LinkedList();
        copiaLista1Lista2(lista1, lista2);
        
        escreveLista2(lista2);
    }
    
    /**
     * Copia o conteúdo da lista 1 na lista 2, porém na ordem inversa
     * 
     * @param lista1
     * @param lista2 
     */
    public static void copiaLista1Lista2(LinkedList lista1, LinkedList lista2) {
        for (int i = 0; i < lista1.size(); i++) {
            lista2.add(lista1.getContentRwd(i));
        }
        
        //lista2.print();
    }
    
    /**
     * Preenche a lista com o conteúdo do arquivo entrada.txt
     * 
     * @param lista1 
     */
    public static void preecheLista1(LinkedList lista1) {
        BufferedReader b = null;
        try {
            File input = new File("entrada.txt");
            b = new BufferedReader(new FileReader(input));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lista1.add(readLine);
            }

        } catch (IOException ex) {
            System.out.println("Aconteceu um erro na leitura do arquivo entrada.txt: " + ex.getMessage());
        } finally {
            try {
                if (b != null)
                    b.close();
            } catch (IOException ex) {
               System.out.println("Aconteceu um erro na liberação de recursos: " + ex.getMessage());
            } 
        }
    }
    
    /**
     * Escreve o conteúdo da lista no arquivo saida.txt
     * 
     * @param lista2 
     */
    public static void escreveLista2(LinkedList lista2) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("saida.txt");
            bw = new BufferedWriter(fw);
            for (int i = 0; i < lista2.size(); i++) {
                bw.write(lista2.getContent(i).toString() + "\r\n");
            }
        } catch (IOException ex) {
            System.out.println("Aconteceu um erro na escrita do arquivo saida.txt: " + ex.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                System.out.println("Aconteceu um erro na liberação de recursos: " + ex.getMessage());
            }
        }
    }
}