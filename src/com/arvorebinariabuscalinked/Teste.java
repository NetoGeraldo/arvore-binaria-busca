package com.arvorebinariabuscalinked;

/**
 *
 * @author gsnet
 */
public class Teste {
    public static void main(String[] args) {
        
        ArvoreBinariaBusca<Integer, Integer> arvore = new ArvoreBinariaBusca<>();
        
        // Inserção
        System.out.println(arvore.inserir(20, 20));
        System.out.println(arvore.inserir(24, 24));
        System.out.println(arvore.inserir(22, 22));
        System.out.println(arvore.inserir(21, 21));
        System.out.println(arvore.inserir(23, 23));
        System.out.println(arvore.inserir(27, 27));
        System.out.println(arvore.inserir(25, 25));
        System.out.println(arvore.inserir(30, 30));
        System.out.println(arvore.inserir(28, 28));
        System.out.println(arvore.inserir(17, 17));
        System.out.println(arvore.inserir(14, 14));
        System.out.println(arvore.inserir(10, 10));
        System.out.println(arvore.inserir(16, 16));
        System.out.println(arvore.inserir(18, 18));
        System.out.println(arvore.inserir(19, 19));
        System.out.println(arvore.inserir(9, 9));

        // Remoção
        System.out.println(arvore.remover(30));
        System.out.println(arvore.remover(18));
        System.out.println(arvore.remover(22));
        

        
    }
}
