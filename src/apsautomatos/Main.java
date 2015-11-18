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

        ling.removeInuteis();

    }
}
