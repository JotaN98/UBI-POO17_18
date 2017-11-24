import java.util.ArrayList;

public class Curso extends Entity {
    private String nome;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Aluno> Alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Turma> turmas;
    private ArrayList<Nota> notass;


    public void setNome(String nome) {
	this.nome = nome;
    }

    public void setDisciplina(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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

    public String getNome() {
	return nome;
	}

    public ArrayList<Disciplina> getDisciplina() {
        return disciplinas;
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
    
    public String toString() {
        return "Curso{" + "disciplinas=" + disciplinas + ", Alunos=" + Alunos + ", professores=" + professores + ", turmas=" + turmas + ", notass=" + notass + '}';
    }
}
