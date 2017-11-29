import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa{
    // -- beginning of non static fields
    // -- vars
    private static long IDCount = 0;
    private static Map<String, Professor> professores = new HashMap<String, Professor>();
    public static Professor getProfFromID(long ID){
    	return professores.get(Professor.getGroupIDFromGroup("Professor") + ID);
	}
	public static boolean addProfessor(Professor prof){
    	if(getProfFromID(prof.getID()) != null){
			System.out.println("Professor já existente.");
			return false;
		}

		professores.put(prof.getCodeID(), prof);
    	return true;
	}
	public static Professor Create



	// -- beginning of static fields
	// -- vars
	private ArrayList<Long /*Turma*/> turmas;
	private ArrayList<Long /*Teste*/> testes;
	private ArrayList<Long /*Aula*/> aulas;

	private ArrayList<Disciplina> disciplinas ;

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
