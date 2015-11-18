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
    //Marco
    public ArrayList<Simbolo> procuraNulls() {
        ArrayList<Simbolo> listaNulls = new ArrayList<>();
        Transicao transicao;
        for (int i = 0; listaTransicao.size() > i; i++) {
            transicao = listaTransicao.get(i);
            //ISePSILON
            if (transicao.getListaDestino().isEmpty()) {
                listaNulls.add(transicao.getOrigem());
                listaTransicao.remove(i);
                i--;
            }
        }
        return listaNulls;
    }

    public ArrayList<Transicao> procuraTransDestNull(ArrayList<Simbolo> listaNulls) {
        ArrayList<Transicao> listaDestNulls = new ArrayList<>();
        int cont;
        for (Transicao t : listaTransicao) {
            cont = 0;
            for (Simbolo s : listaNulls) {
                if (((t.getListaDestino()).contains(s))) {
                    cont++;
                }
            }
            if (cont == t.getListaDestino().size()) {
                listaDestNulls.add(t);
            }
        }
        return listaDestNulls;

    }

    public void procuraTransApenasNull(ArrayList<Transicao> listaTrans) {
        ArrayList<Transicao> transInv = new ArrayList<>();
        boolean aux;
        Transicao tl;
        int j = -1;
        for (Transicao t : listaTrans) {
            aux = false;
            for (int i = 0; i < listaTransicao.size(); i++) {
                tl = listaTransicao.get(i);
                for (Simbolo s : t.getListaDestino()) {
                    if (tl.getOrigem().equals(s)) {
                        for (Simbolo sl : tl.getListaDestino()) {
                            String n = sl.getNome();
                            if ((n.toLowerCase()).equals(n)) {
                                aux = true;
                            } else {
                                if (!(s.equals(sl))) {
                                    for (Transicao ti : transInv) {
                                        if (!(ti.getOrigem().equals(sl))) {
                                            aux = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (t.getOrigem().equals(tl.getOrigem())) {
                    if (t.getListaDestino().containsAll(tl.getListaDestino())) {
                        j = i;
                    }

                }
            }
            if (!aux) {
                transInv.add(t);
                if (j != -1) {
                    listaTransicao.remove(j);
                }
            }

        }
    }

    public ArrayList<Simbolo> addList(ArrayList<Transicao> listaTrans) {
        Transicao ti;
        Transicao tj;
        ArrayList<Simbolo> listaSimbs = new ArrayList<>();
        ArrayList<Transicao> listaT = new ArrayList<>();
        boolean aux;
        int cont, k;
        for (int i = 0; i < listaTrans.size(); i++) {
            ti = listaTrans.get(i);
            aux = true;
            for (int j = 0; j < listaTransicao.size(); j++) {
                tj = listaTransicao.get(j);
                cont = 0;
                if ((ti.getOrigem()).equals((tj.getOrigem())) && (ti.getListaDestino().size()) == (tj.getListaDestino().size())) {
                    for (k = 0; k < ti.listaDestino.size(); k++) {
                        if (((ti.getListaDestino().get(k)).equals(tj.getListaDestino().get(k)))) {
                            cont++;
                        }

                    }
                    if (cont == k) {
                        aux = false;
                    }
                }
            }
            if (aux) {
                listaT.add(ti);
                if (!(listaSimbs.contains(ti.getOrigem()))) {
                    listaSimbs.add(ti.getOrigem());
                }
            }
        }
        listaTransicao.addAll(listaT);
        return listaSimbs;
    }

    public ArrayList<Simbolo> criaNovasTrans(ArrayList<Simbolo> listaSimb) {
        ArrayList<Transicao> novasTrans = new ArrayList<>();
        ArrayList<Simbolo> novaListaSimb;
        ArrayList<Simbolo> listaSimbsNovasTrans;
        Transicao t;
        Transicao nt;
        int x = 0, y = 0;
        for (int i = 0; i < listaTransicao.size(); i++) {
            t = listaTransicao.get(i);
            if (t.getListaDestino().size() > 1) {
                for (int j = 0; j < t.getListaDestino().size(); j++) {
                    x = 0;
                    novaListaSimb = new ArrayList<>();
                    nt = new Transicao();
                    nt.setOrigem(t.getOrigem());
                    for (Simbolo s : t.listaDestino) {
                        if (!(listaSimb.contains(s))) {
                            novaListaSimb.add(s);
                        } else {
                            if (x != j) {
                                novaListaSimb.add(s);
                            }
                        }
                        x++;
                    }
                    nt.setListaDestino(novaListaSimb);
                    novasTrans.add(nt);
                }

            }
        }
        listaSimbsNovasTrans = addList(novasTrans);
        return listaSimbsNovasTrans;
    }

    public void limpaRep() {
        Transicao ti;
        Transicao tj;
        int cont, k = 0;
        for (int i = 0; i < listaTransicao.size(); i++) {
            ti = listaTransicao.get(i);
            for (int j = 0; j < listaTransicao.size(); j++) {
                if (j != i) {
                    tj = listaTransicao.get(j);
                    cont = 0;
                    if (ti.getOrigem().equals(tj.getOrigem())) {
                        if (ti.getListaDestino().size() == tj.getListaDestino().size()) {
                            for (k = 0; k < ti.getListaDestino().size(); k++) {
                                if (ti.getListaDestino().get(k).getNome().equals(tj.getListaDestino().get(k).getNome())) {
                                    cont++;
                                }
                            }
                        if (cont == k) {
                            listaTransicao.remove(j);
                            if (j < i) {
                                i--;
                            }
                            j--;

                        }
                        }
                    }
                }
            }
        }
    }

    public void removeNulls() {
        ArrayList<Simbolo> listaSimbolosN;
        ArrayList<Transicao> listaTransicoesN;

        ArrayList<Simbolo> listaSimbolos = new ArrayList<>();
        ArrayList<Simbolo> listaSimbN = new ArrayList<>();
        ArrayList<Transicao> listaTransicoes = new ArrayList<>();

        int tamanho = -1;

        listaSimbolosN = procuraNulls();
        if (!(listaSimbolosN.isEmpty())) {
            for (Simbolo s : listaSimbolosN) {
                if (!(listaSimbolos.contains(s))) {
                    listaSimbolos.add(s);
                }
            }

            while (tamanho != listaTransicoes.size()) {
                tamanho = listaTransicoes.size();
                listaTransicoesN = procuraTransDestNull(listaSimbolos);
                if (listaTransicoesN.isEmpty()) {
                    break;
                } else {
                    for (Transicao t : listaTransicoesN) {
                        if (!(listaTransicoes.contains(t))) {
                            listaTransicoes.add(t);
                        }
                        if (!(listaSimbolos.contains(t.getOrigem()))) {
                            listaSimbolos.add(t.getOrigem());
                        }
                    }
                }

            }
        }
        procuraTransApenasNull(listaTransicoes);
        listaSimbN = criaNovasTrans(listaSimbolos);

        while (!(listaSimbN.isEmpty())) {
            listaSimbN = criaNovasTrans(listaSimbolos);
        }
        limpaRep();    }

    public void imprimeTrans() {
        System.out.println("--------- Lista Trans -------------");
        for (Transicao tt : listaTransicao) {
            System.out.print("\nOri: " + tt.getOrigem().getNome() + "----->");
            for (Simbolo ss : tt.getListaDestino()) {

                System.out.print("" + ss.getNome());

            }
        }
        System.out.println("\n--------- FIM -------------");

    }

    public boolean isUtil(Transicao t) {
        boolean aux = true;
        for (Simbolo s : t.getListaDestino()) {
            if (!(s.isTerminal())) {
                aux = false;
            }
        }
        return aux;
    }

    public void removeInuteis() {
        ArrayList<Simbolo> uteis = new ArrayList<>();
        ArrayList<Transicao> novasTrans = new ArrayList<>();
        int cont;
        boolean aux;
        for (Transicao t : listaTransicao) {
            if (isUtil(t)) {
                novasTrans.add(t);
                uteis.add(t.getOrigem());
            }
        }

        for (Transicao trans : listaTransicao) {
            if (uteis.contains(trans.getOrigem())) {
                novasTrans.add(trans);
                uteis.add(trans.getOrigem());

            }
        }

        for (Transicao t : listaTransicao) {
            cont = t.getListaDestino().size();
            aux = true;
            for(Simbolo s : t.getListaDestino()){
                if(!(uteis.contains(s) || s.isTerminal())){
                    aux = false;
                }
            }
            if (uteis.containsAll(t.getListaDestino())) {
                aux = true;

            }
            if (aux) {
                novasTrans.add(t);
            }
        }
        listaTransicao = novasTrans;
        limpaRep();
    }

    
    //Marco Fim
    
    
    //REMOVE UNITARIO: AQUI MARCAO

    public ArrayList<Transicao> removeInalcancaveis(ArrayList<Transicao> t) {
        Simbolo inicial = this.getInicial();
        ArrayList<Transicao> nova = new ArrayList<>();
        ArrayList<Transicao> aux = new ArrayList<>();
        for (Transicao trans : t) {
            if (trans.getOrigem().equals(inicial)) {
                nova.add(trans);
            }
        }

        for (int i = 0; i < nova.size(); i++) {
            Transicao s = nova.get(i);
            for (int j = 0; j < s.getListaDestino().size(); j++) {
                aux = getTransicoes(s.getListaDestino().get(j));
                nova.addAll(aux);
            }
        }

        return nova;
    }
    
    //AQI MARCAO (REMOVE UNITARIOS
    public ArrayList<Transicao> getTransicoes(Simbolo s) {
        ArrayList<Transicao> trans = new ArrayList<>();
        for (Transicao transicao : this.listaTransicao) {
            if (transicao.getOrigem().equals(s)) {
                trans.add(transicao);
            }
        }
        return trans;
    }

}
