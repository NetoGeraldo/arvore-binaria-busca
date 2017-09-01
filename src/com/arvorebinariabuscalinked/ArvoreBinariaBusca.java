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
        
        if (this.noCorrente == null) {
            this.noCorrente = this.raiz;
            return null;
        }
        
        if (this.noCorrente.getChave().compareTo(chave) < 0) {
            this.noCorrente = this.noCorrente.getFilhoEsquerdo();
            return this.remover(chave);
        } else if (this.noCorrente.getChave().compareTo(chave) > 0) {
            this.noCorrente = this.noCorrente.getFilhoDireito();
            return this.remover(chave);
        } else {

            // No nao apresenta subarvore a esquerda
            if (this.noCorrente.getFilhoEsquerdo() == null && this.noCorrente.getFilhoDireito() != null) {
                this.noCorrente.getFilhoDireito().setPai(this.noCorrente.getPai());

                if (this.noCorrente.getPai().getChave().compareTo(this.noCorrente.getChave()) > 0) {
                    this.noCorrente.getPai().setFilhoDireito(this.noCorrente.getFilhoDireito());
                } else {
                    this.noCorrente.getPai().setFilhoEsquerdo(this.noCorrente.getFilhoDireito());
                }
                
                No<Chave, Valor> noRetorno = this.noCorrente;
                this.noCorrente = this.raiz;
                return noRetorno.getValor();
                
            // No nao apresenta subarvore a direita
            } else if (this.noCorrente.getFilhoEsquerdo() != null && this.noCorrente.getFilhoDireito() == null) {
                this.noCorrente.getFilhoEsquerdo().setPai(this.noCorrente.getPai());
                
                if (this.noCorrente.getPai().getChave().compareTo(this.noCorrente.getChave()) > 0) {
                    this.noCorrente.getPai().setFilhoDireito(this.noCorrente.getFilhoEsquerdo());
                } else {
                    this.noCorrente.getPai().setFilhoEsquerdo(this.noCorrente.getFilhoEsquerdo());
                }
                
                No<Chave, Valor> noRetorno = this.noCorrente;
                this.noCorrente = this.raiz;
                return noRetorno.getValor();
                
            // No apresenta subarvore
            } else {
                No<Chave, Valor> noAux = retornarAntecessor(this.noCorrente);
                
                this.noCorrente.getFilhoDireito().setPai(noAux);
                this.noCorrente.getFilhoEsquerdo().setPai(noAux);
                noAux.setPai(this.noCorrente.getPai());
                
                if (this.noCorrente.getPai().getChave().compareTo(this.noCorrente.getChave()) > 0) {
                    this.noCorrente.getPai().setFilhoDireito(noAux);
                } else {
                    this.noCorrente.getPai().setFilhoEsquerdo(noAux );
                }
                
                No<Chave, Valor> noRetorno = this.noCorrente;
                this.noCorrente = this.raiz;
                return noRetorno.getValor();
                
            }
            
        }
        
    }
    
    private No<Chave, Valor> retornarAntecessor(No<Chave, Valor> no) {
        No<Chave, Valor> noCorrente = no.getFilhoEsquerdo();
        
        while (noCorrente.getFilhoDireito() != null) {            
            noCorrente = noCorrente.getFilhoDireito();
        }
        
        return noCorrente;
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
        if (this.raiz == null) {
            return true;
        }
        
        return false;
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
