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
public class Main {

    public static void main(String[] args) {
        Arquivo arq = new Arquivo();
        Linguagem ling = new Linguagem();

        arq.lerArquivo("teste", ling);
        ArrayList<Transicao> t = ling.getListaTransicao();
        ArrayList<Transicao> ts = new ArrayList<>();
        int i = 0;
        for (Transicao tt : ling.getListaTransicao()) {
            System.out.print("\nOri: " + tt.getOrigem().getNome() + "----->");
            for (Simbolo ss : tt.getListaDestino()) {

                System.out.print("" + ss.getNome());

            }
        }
        System.out.println("\n--------------------");
        ArrayList<Simbolo> ll = ling.procuraNulls();
        for (Simbolo s : ll) {
            System.out.println("S: " + s.getNome());
        }
        System.out.println("---1---");
        ArrayList<Transicao> tt = ling.procuraTransDestNull(ll);
        for(Transicao tss : tt){
            System.out.println(""+tss.getOrigem().getNome());
        }
        System.out.println("--------------------");
        ts = ling.removeInuteis(t);
        for (Transicao nova : ts) {
            System.out.println(" ");
            for (i = 0; i < nova.getListaDestino().size(); i++) {
                //System.out.println(nova.getListaDestino().size());
                System.out.println(nova.getOrigem().getNome() + "----->" + nova.getListaDestino().get(i).getNome());
            }
            //s.add(nova.getListaDestino())

        }

    }

}
