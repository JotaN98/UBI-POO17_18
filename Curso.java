package projeto;

import java.util.ArrayList;

public class Curso {
    private ArrayList<Disciplina> disciplina;
    private ArrayList<Aluno> Alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Turma> turmas;
    private ArrayList<Nota> notass;

    
    public String toString() {
        return "Curso{" + "disciplina=" + disciplina + ", Alunos=" + Alunos + ", professores=" + professores + ", turmas=" + turmas + ", notass=" + notass + '}';
    }

    public void setDisciplina(ArrayList<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    public void setAlunos(ArrayList<Aluno> Alunos) {
        this.Alunos = Alunos;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    public void setNotass(ArrayList<Nota> notass) {
        this.notass = notass;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplina;
    }

    public ArrayList<Aluno> getAlunos() {
        return Alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public ArrayList<Nota> getNotass() {
        return notass;
    }
   
}
