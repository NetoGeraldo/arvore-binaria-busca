package com.arvorebinariabuscalinked;

/**
 *
 * @author gsnet
 */
public class Teste {
    public static void main(String[] args) {
        
        ArvoreBinariaBusca<Integer, Integer> arvore = new ArvoreBinariaBusca<>();
        
        System.out.println(arvore.inserir(15, 15));
        System.out.println(arvore.inserir(13, 13));
        System.out.println(arvore.inserir(14, 14));
        System.out.println(arvore.inserir(16, 16));
        System.out.println(arvore.inserir(17, 17));
        
        
    }
}
