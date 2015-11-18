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
        arq.lerArquivo("unitario", ling);

      //  arq.lerArquivo("teste", ling);
        ArrayList<Transicao> t = ling.getListaTransicao();
        ArrayList<Simbolo> ts = new ArrayList<>();
        ArrayList<Transicao> tt = new ArrayList<>();
        int i = 0;
//        ts = ling.removeInuteis(t);
//        for (Simbolo nova : ts) {
//            System.out.println(nova.getNome());
//        }
          ling.removeUnitario();
          int j=0;
          for(Transicao trans:t){
              System.out.println(" ");
              for(j=0;j<trans.getListaDestino().size();j++){
              System.out.println(trans.getOrigem().getNome()+ " para "+ trans.getListaDestino().get(j).getNome());
//                  
              }
//        
        
//        for (Transicao tt : ling.getListaTransicao()) {
//            System.out.print("\nOri: " + tt.getOrigem().getNome() + "----->");
//            for (Simbolo ss : tt.getListaDestino()) {
//
//                System.out.print("" + ss.getNome());
//
//            }
//        System.out.println("\n--------------------");
//        ArrayList<Simbolo> ll = ling.procuraNulls();
//        for (Simbolo s : ll) {
//            System.out.println("S: " + s.getNome());
//        }
//        System.out.println("---1---");
//        ArrayList<Transicao> tt = ling.procuraTransDestNull(ll);
//        for (Transicao tss : tt) {
//            System.out.println("" + tss.getOrigem().getNome());
//        }
//        System.out.println("--------------------");
//    }
    }
}

}