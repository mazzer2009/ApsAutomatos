/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsautomatos;

import java.util.ArrayList;
import java.util.List;

public class Linguagem {

    private Simbolo inicial;
    private ArrayList<Transicao> listaTransicao;
    private ArrayList<Simbolo> listaSimbolo;

    public Linguagem() {
        listaSimbolo = new ArrayList<>();
        listaTransicao = new ArrayList<>();
    }

    public Simbolo getInicial() {
        return inicial;
    }

    public void setInicial(Simbolo inicial) {
        this.inicial = inicial;
    }

    public ArrayList<Transicao> getListaTransicao() {
        return listaTransicao;
    }

    public void setListaTransicao(ArrayList<Transicao> listaTransicao) {
        this.listaTransicao = listaTransicao;
    }

    public ArrayList<Simbolo> getListaSimbolo() {
        return listaSimbolo;
    }

    public void setListaSimbolo(ArrayList<Simbolo> listaSimbolo) {
        this.listaSimbolo = listaSimbolo;
    }

    public Simbolo getSimbolo(String nome) {
        for (Simbolo simbolo : listaSimbolo) {
            if (nome.equals(simbolo.getNome())) {
                return simbolo;
            }

        }
        return criaSimbolo(nome);
    }

    public Simbolo criaSimbolo(String nome) {
        Simbolo simbolo = new Simbolo();
        //QUEBRAR VERIFICAÇÃO DE MAIUSCULA
        if (nome.equals(nome.toLowerCase())) {
            simbolo.setTerminal(true);
        } else {
            simbolo.setTerminal(false);
        }
        simbolo.setNome(nome);
        addSimbolo(simbolo);
        return simbolo;

    }

    public void addSimbolo(Simbolo simb) {
        listaSimbolo.add(simb);
    }

    public void removeSimbolo(Simbolo simb) {
        listaSimbolo.remove(simb);
    }

    public void addTransicao(Transicao t) {
        listaTransicao.add(t);
    }

    public void removeTransicao(Transicao t) {
        listaTransicao.remove(t);
    }

    public ArrayList<Transicao> getListTransIni(Simbolo s) {
        ArrayList<Transicao> listTrans = new ArrayList<>();
        for (Transicao t : listaTransicao) {
            if (t.getOrigem().equals(s)) {
                listTrans.add(t);
            }
        }
        return listTrans;
    }

    public void removeEps() {
        Simbolo simbOri;
        ArrayList<Simbolo> listTransEps = new ArrayList<>();
        int aux, cont, qtdEps,qtdEpsAt;
        for (Transicao t : listaTransicao) {
            if (t.getListaDestino() == null) {
                listTransEps.add(t.getOrigem());
                listaTransicao.remove(t);
            }
        }
        qtdEps = listTransEps.size();
        qtdEpsAt = 0;
        while (qtdEps != qtdEpsAt) {
            qtdEpsAt = qtdEps;
            for (Transicao t : listaTransicao) {
                cont = 0;
                aux = t.getListaDestino().size();
                for (Simbolo s : listTransEps) {
                    if (t.getListaDestino().contains(s)) {
                        cont++;
                    }
                }
                if ((cont == aux) && (cont > 1)) {
                    listTransEps.add(t.getOrigem());
                }
            }
            qtdEps = listTransEps.size();
                    
        }
        
        
    }

}
