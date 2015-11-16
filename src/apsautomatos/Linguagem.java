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

//    public void removeEps() {
//        Simbolo simbOri;
//        ArrayList<Simbolo> listSimbEps = new ArrayList<>();
//        int aux, cont, qtdEps,qtdEpsAt;
//        for (Transicao t : listaTransicao) {
//            if (t.getListaDestino() == null) {
//                listSimbEps.add(t.getOrigem());
//                listaTransicao.remove(t);
//            }
//        }
//        qtdEps = listSimbEps.size();
//        qtdEpsAt = 0;
//        while (qtdEps != qtdEpsAt) {
//            qtdEpsAt = qtdEps;
//            for (Transicao t : listaTransicao) {
//                cont = 0;
//                aux = t.getListaDestino().size();
//                for (Simbolo s : listSimbEps) {
//                    if (t.getListaDestino().contains(s)) {
//                        cont++;
//                    }
//                }
//                if ((cont == aux)) {
//                    listSimbEps.add(t.getOrigem());
//                }
//            }
//            qtdEps = listSimbEps.size();
//                    
//        }
//        
//        for(Simbolo s : listSimbEps){
//        
//            System.out.println("Ini trans com eps: "+s.getNome());
//        }
//    }
//
    public ArrayList<Transicao> removeUnitario(ArrayList<Transicao> t) {
        ArrayList<Transicao> nova = new ArrayList<>();
        for (Transicao outra : t) {
            if (outra.getListaDestino().size() == 1) {
                nova.add(outra);
            }
        }

        //verificar se todos os simbulos de 'nova' sao terminais
        ArrayList<Transicao> teste = new ArrayList<>();
        //teste=t;
        for (Transicao t1 : t) {
            for (int i = 0; i < t1.getListaDestino().size(); i++) {
                Transicao trans = new Transicao();
                for (Transicao nova1 : nova) {
                    if (t1.getListaDestino().get(i).getNome().equals(nova1.getOrigem().getNome())) {
                        System.out.print(t1.getOrigem().getNome());
                        System.out.println(t1.getListaDestino().get(i).getNome());

                        System.out.print(nova1.getOrigem().getNome());
                        System.out.println(nova1.getListaDestino().get(0).getNome());

                        trans.setOrigem(t1.getOrigem());
                        trans.addListaDestino(nova1.getListaDestino().get(0));
                        //teste.add(trans);
                    } else {

                        trans.setOrigem(t1.getOrigem());
                        trans.setListaDestino(t1.getListaDestino());

                    }

                    teste.add(trans);
                }
            }
        }
        for (Transicao t1 : teste) {
            if (t1.getListaDestino().size() == 1 && (!(t1.getListaDestino().get(0).isTerminal()))) {
                removeUnitario(teste);
            }
        }
        return t;
    }

    public ArrayList<Simbolo> removeInuteis(ArrayList<Transicao> t) {
        ArrayList<Simbolo> uteis = new ArrayList<Simbolo>();
        ArrayList<Simbolo> retorno = new ArrayList<Simbolo>();
        for (Transicao transicao : t) {
            if ((transicao.getListaDestino().size() == 1) && (transicao.getListaDestino().get(0).isTerminal())) {
                uteis.add(transicao.getOrigem());
            }
        }
        for (Transicao trans : t) {
            for (Simbolo util : uteis) {
                for (int i = 0, cont = 0; i < trans.getListaDestino().size(); i++) {//get(i).getNome().equals(util.getOrigem().getNome())) {
                    if (trans.getListaDestino().get(i).getNome().equals(util.getNome())) {
                        cont++;
                    }

                    if (cont == trans.getListaDestino().size()) {
                        retorno.add(trans.getOrigem());
                    }
                }
            }
        }
        retorno.addAll(uteis);

        return retorno;
    }
}
