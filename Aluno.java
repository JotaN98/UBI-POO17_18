
package projeto;

import java.text.DateFormat;

public class Aluno extends Pessoa {
    private int numero;
    private int ano;
    private Curso curso;
    private Turma turma;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getNumero() {
        return numero;
    }

    public int getAno() {
        return ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public Turma getTurma() {
        return turma;
    }
}
