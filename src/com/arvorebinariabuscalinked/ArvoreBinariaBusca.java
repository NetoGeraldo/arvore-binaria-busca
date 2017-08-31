package com.arvorebinariabuscalinked;

import java.util.Collection;

/**
 *
 * @author gsnet
 */
public class ArvoreBinariaBusca<Chave extends Comparable<Chave>, Valor> implements IArvoreBinariaBusca<Chave, Valor> {
    
    private No<Chave, Valor> raiz;
    private No<Chave, Valor> noCorrente; // responsavel por percorrer a arvore na hora de inserir

    public ArvoreBinariaBusca() {   }
    
    @Override
    public boolean inserir(Chave chave, Valor valor) {
        
        No<Chave, Valor> novoNo = new No<>(chave, valor);
        
        if (this.raiz == null) {
            this.raiz = novoNo;
            this.noCorrente = this.raiz;
            return true;
        } else {
            // A chave é menor que a chave do noCorrente
            if (novoNo.getChave().compareTo(this.noCorrente.getChave()) < 0) {
                
                if (this.noCorrente.getFilhoEsquerdo() != null) {
                    this.noCorrente = this.noCorrente.getFilhoEsquerdo();
                    inserir(chave, valor);
                } else {
                    novoNo.setPai(noCorrente);
                    noCorrente.setFilhoEsquerdo(novoNo);
                    this.noCorrente = this.raiz;
                }
                
                return true;
                
            // A chave é maior que a chave do noCorrente
            } else if (novoNo.getChave().compareTo(this.noCorrente.getChave()) > 0) {
                
                if (this.noCorrente.getFilhoDireito() != null) {
                    this.noCorrente = this.noCorrente.getFilhoDireito();
                    inserir(chave, valor);
                } else {
                    novoNo.setPai(noCorrente);
                    noCorrente.setFilhoDireito(novoNo);
                    this.noCorrente = this.raiz;
                }
                
                return true;
            
            // A chave é igual
            } else {
                return false;
            }
            
        }
        
    }
    
    @Override
    public Valor remover(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Valor buscar(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ehVazia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Valor> obterTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Valor> obterTodosPreOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Valor> obterTodosPosOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Valor> obterTodosEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public No<Chave, Valor> getRaiz() {
        return raiz;
    }
    
}
