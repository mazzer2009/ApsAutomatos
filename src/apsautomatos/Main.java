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
       ts= ling.removeInuteis(t);
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
