import java.util.ArrayList;

public class Turma extends Entity{
    private Aluno alunos;
    private ArrayList<String /*Aula*/> aulas;
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

    public String toString() {
        return "Turma{" + "alunos=" + alunos + ", aulas=" + aulas + ", curso=" + curso + '}';
    }
    
    
}
