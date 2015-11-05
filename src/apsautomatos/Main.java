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
        
        Linguagem lingua=new Linguagem();
        Arquivo arq=new Arquivo();
        arq.lerArquivo("teste", lingua);
        ArrayList<Simbolo> simb = lingua.getListaSimbolo();
        ArrayList<Transicao> trans = lingua.getListaTransicao();
        //System.out.println("aaaaa");
        for (Transicao tran : trans) {
            System.out.println(tran.getOrigem());
            
        }
    }
    
    
}
