/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsautomatos;

public class Simbolo {

    private boolean terminal;
    private String nome;
    private Closure closure;

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Closure getClosure() {
        return closure;
    }

    public void setClosure(Closure closure) {
        this.closure = closure;
    }
    //AQUI MARCAO (REMOVE UNITARIOS)
    @Override
    public boolean equals(Object obj){
        Simbolo s = (Simbolo)obj;
        return s.getNome().equals(this.getNome());
    }
    //AQUI MARCAO (REMOVE UNITARIOS)
    @Override
    public Object clone(){
        Simbolo simb = new Simbolo();
        simb.setNome(nome);
        simb.setTerminal(terminal);
        return simb;
    }
}
