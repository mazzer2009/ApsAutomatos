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
public class ApsAutomatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Linguagem lingua = new Linguagem();
        Arquivo arq = new Arquivo();
        arq.lerArquivo("teste", lingua);
        ArrayList<Simbolo> simb = lingua.getListaSimbolo();
        ArrayList<Transicao> trans = lingua.getListaTransicao();
        for (Transicao tran : trans) {
            if (tran.getListaDestino() != null) {
                System.out.println("trans: " + tran.getOrigem().getNome() + "   --Dest: " + tran.getListaDestino().get(0).getNome());
            } else {
                System.out.println("trans: " + tran.getOrigem().getNome() + "   --Dest: eps");

            }
        }
    }
}
