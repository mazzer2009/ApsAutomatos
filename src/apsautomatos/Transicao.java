/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsautomatos;

import java.util.ArrayList;

/**
 *
 * @author emanuel
 */
public class Transicao {

    Simbolo origem;
    ArrayList<Simbolo> listaDestino;

    public Transicao() {
        listaDestino = new ArrayList<>();
    }

    public Simbolo getOrigem() {
        return origem;
    }

    public void setOrigem(Simbolo origem) {
        this.origem = origem;
    }

    public ArrayList<Simbolo> getListaDestino() {
        return this.listaDestino;
    }

    public void setListaDestino(ArrayList<Simbolo> listaDestino) {
        this.listaDestino = listaDestino;
    }

    //AQUI MARCAO USADO NA REMOVE UNITARIO
    @Override
    public Object clone() {
        Transicao t = new Transicao();
        t.setOrigem((Simbolo)getOrigem().clone());
        ArrayList<Simbolo> origem = new ArrayList<>();
        for(Simbolo simb:getListaDestino()){
            origem.add((Simbolo) simb.clone());
        }
        t.setListaDestino(origem);
        return t;
        
    }

    public ArrayList<Simbolo> getCopiaDest(Transicao t1) {
        ArrayList<Simbolo> list = new ArrayList<>();
        for (Simbolo s : t1.getListaDestino()) {
            list.add(s);
        }
        return list;
    }
       
    public void addListaDestino(Simbolo s){
        this.listaDestino.add(s);
    }
    
    @Override
   public boolean equals(Object obj){
       Transicao t = (Transicao)obj;
       if((t.getOrigem().getNome().equals(this.getOrigem().getNome()) && (t.getListaDestino().containsAll(this.getListaDestino())))){
           return true;
       }
       return false;
   }
}
