package apsautomatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    public void lerArquivo(String arquivo, Linguagem lingua) {
        String auxiliar[];
        ArrayList<Simbolo> listaDest = new ArrayList<>();
        try {
            FileReader file = new FileReader(arquivo + ".txt");
            BufferedReader fi = new BufferedReader(file);
            String linha = fi.readLine();
         //   linha = fi.readLine();

            auxiliar = linha.split(" ");

            for (int i = 0; i < auxiliar.length; i++) {

            }

            for (String a : auxiliar) {
                lingua.criaSimbolo(a);
            }
            linha = fi.readLine();
            lingua.setInicial(lingua.getSimbolo(linha));
            linha = fi.readLine();
            while (linha != null) {
                Transicao transicao = new Transicao();
                listaDest = new ArrayList<>();
                auxiliar = linha.split(" ");
                transicao.setOrigem(lingua.getSimbolo(auxiliar[0]));
                if (auxiliar[1].equals("epsilon")) {
                   // transicao.setListaDestino(null);
                } else {

                    auxiliar = auxiliar[1].split("");

                    for (String dest : auxiliar) {
                        listaDest.add(lingua.getSimbolo(dest));

                    }
                    transicao.setListaDestino(listaDest);
                }
                lingua.addTransicao(transicao);

                linha = fi.readLine();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
