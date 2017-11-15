package projeto;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int codigo;
    private int ano;
    private ArrayList<Nota>notas;
    private ArrayList<Professor> lecionadores;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void setLecionadores(ArrayList<Professor> lecionadores) {
        this.lecionadores = lecionadores;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAno() {
        return ano;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public ArrayList<Professor> getLecionadores() {
        return lecionadores;
    }

    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", codigo=" + codigo + ", ano=" + ano + ", notas=" + notas + ", lecionadores=" + lecionadores + '}';
    }
    
    
}
