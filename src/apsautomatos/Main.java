/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsautomatos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author emanuel
 */
public class Main {

    public static void main(String[] args) {
        Arquivo arq = new Arquivo();
        Linguagem ling = new Linguagem();
        String s = new String();
        while (!(s.equals("0"))) {

            s = JOptionPane.showInputDialog(null, "Digite o nome do Arquivo", null);
            if (s.isEmpty()) {
                arq.lerArquivo("teste", ling);
            } else {
                arq.lerArquivo(s, ling);
            }
            s = JOptionPane.showInputDialog(null, "Opção 1 - Eliminar Produções Para a Palavra Vazia \nOpção 2 - Eliminar Produções Unitárias\nOpção 3 - Eliminar as Variáveis Que Não Derivam Palavras"
                    + "\nOpção 4 - Elimine variáveis inalcançáveis a partir da variável inicial\nOpção 5 - Executa todos passos anteriores sequenciamente", null);
            if (s.equals("1")) {
                ling.removeNulls();
                ling.imprimeTrans();
            } else if (s.equals("2")) {
                ling.removeUnitario();
                ling.imprimeTrans();
            } else if (s.equals("3")) {
                ling.removeInuteis();
                ling.imprimeTrans();
            } else if (s.equals("4")) {
                ling.removeInalcancaveis(ling.getListaTransicao());
                ling.imprimeTrans();
            } else if (s.equals("5")) {
                ling.removeNulls();
                ling.removeUnitario();
                ling.removeInuteis();
                ling.removeInalcancaveis(ling.getListaTransicao());
                ling.imprimeTrans();
            } else if (!(s.equals("0"))) {
                s = JOptionPane.showInputDialog(null, "Opção 1 - Eliminar Produções Para a Palavra Vazia \nOpção 2 - Eliminar Produções Unitárias\nOpção 3 - Eliminar as Variáveis Que Não Derivam Palavras"
                        + "\nOpção 4 - Elimine variáveis inalcançáveis a partir da variável inicial\nOpção 5 - Executa todos passos anteriores sequenciamente", null);
            }
        }
    }
}
