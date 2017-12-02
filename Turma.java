import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turma extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Turma> turma = new HashMap<String, Turma>();
    
    public static Turma getTurmaFromID(long ID){
        return turma.get(Entity.getGroupIDFromGroup("Turma") + ID);
    }
     
    
    public static boolean addTurma(Turma x){
        if(getTurmaFromID(x.getID()) != null){
            System.out.println("Turma existente");
            return false;
        }
        turma.put(x.getCodeID(), x);
        return true;
    }
     
    public static Turma Create(/*TEM DE SE METER*/) {
    	Turma nTurma = new Turma(/*TEM DE SE METER*/);
    	addTurma(nTurma);
    	return nTurma;
    }
	
    public static Turma Create(/*TEM DE SE METER*/) {
    	Turma nTurma = new Turma(/*TEM DE SE METER*/);
    	addTurma(nTurma);
    	return nTurma;
    }


    
    
    
    
    // -- beginning of non static fields
    // -- vars
    private Aluno alunos;
    private ArrayList<String /*Aula*/> aulas;
    private Curso curso;
    
    //Construtores
    public Turma(String groupClass, long ID) throws IllegalArgumentException {
		super(groupClass, ID);
		IDCount++;
	}
    
    public Turma(Object groupClass, long ID){
    	super(groupClass, ID);
    	IDCount++;
    }

    
    
    
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
