
package projeto;

import java.text.DateFormat;
import java.util.ArrayList;

public class Professor extends Pessoa{

    private ArrayList<Disciplina> disciplinas ;
    private ArrayList<Professor> professores;

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public String toString() {
        return "Professor{" + "disciplinas=" + disciplinas + ", professores=" + professores + '}';
    }
    
    
    
}
