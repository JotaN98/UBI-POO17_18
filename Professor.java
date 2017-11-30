import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa{

	// -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Professor> professor = new HashMap<String, Professor>();
    
    public static Professor getProfessorFromID(long ID){
        return professor.get(Entity.getGroupIDFromGroup("Professor") + ID);
    }
     
    
    public static boolean addProfessor(Professor x){
        if(getProfessorFromID(x.getID()) != null){
            System.out.println("Professor existente");
            return false;
        }
        professor.put(x.getCodeID(), x);
        return true;
    }
     
    public static Professor Create(/*TEM DE SE METER*/) {
    	Professor nProfessor = new Professor(/*TEM DE SE METER*/);
    	addProfessor(nProfessor);
    	return nProfessor;
    }
	
    public static Professor Create(/*TEM DE SE METER*/) {
    	Professor nProfessor = new Professor(/*TEM DE SE METER*/);
    	addProfessor(nProfessor);
    	return nProfessor;
    }

    
    
    // -- beginning of non static fields
    // -- vars
    //contrutores
	public Professor(Object subClass, long ID, String pNome, String uNome, ZonedDateTime nascimento) {
		super(subClass, ID, pNome, uNome, nascimento);
		IDCount++;
	}

	public Professor(String subClass, long ID, String pNome, String uNome, ZonedDateTime nascimento){
		super(subClass, ID, pNome, uNome, nascimento);
		IDCount++;
	}

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
