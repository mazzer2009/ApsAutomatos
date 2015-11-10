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
        return listaDestino;
    }

    public void setListaDestino(ArrayList<Simbolo> listaDestino) {
        this.listaDestino = listaDestino;
    }
}
