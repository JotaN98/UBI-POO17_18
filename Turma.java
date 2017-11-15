/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.ArrayList;

/**
 *
 * @author BrunoTavares
 */
public class Turma {
    private Aluno alunos;
    private ArrayList<Aula> aulas;
    private Curso curso;

    public void setAlunos(Aluno alunos) {
        this.alunos = alunos;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAlunos() {
        return alunos;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public Curso getCurso() {
        return curso;
    }
    
}
