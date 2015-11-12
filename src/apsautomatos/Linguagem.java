/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsautomatos;

import java.util.ArrayList;

public class Linguagem {

    private Simbolo inicial;
    private ArrayList<Transicao> listaTransicao;
    private ArrayList<Simbolo> listaSimbolo;

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
        System.out.println(simb.getNome());

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

    public ArrayList<Transicao> removeUnitario(ArrayList<Transicao> t) {
        ArrayList<Transicao> nova = new ArrayList<>();
        for (Transicao outra : t) {
            if (outra.getListaDestino().size() == 1) {
                nova.add(outra);
            }
        }
        for (Transicao t1 : t) {
            for (int i = 0; i < t1.getListaDestino().size(); i++) {
                for (Transicao nova1 : nova) {
                    if (t1.getListaDestino().get(i).getNome().equals(nova1.getOrigem().getNome())) {
                        t1.getListaDestino().get(i).setNome(nova1.getListaDestino().get(0).getNome());

                    }
                }
            }
        }
        return t;
    }

}
