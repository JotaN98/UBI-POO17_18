import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa{
    // -- beginning of static fields
    // -- vars
    private static Map<String, Professor> professores = new HashMap<String, Professor>();
    private static long IDCount = 1;
    
    private static Map<String, Professor> professor = new HashMap<String, Professor>();
    
    public static Professor getProfessorFromID(Entity ID){
        return professor.get(ID.getCodeID());
    }
     
    
    public static boolean addProfessor(Professor x){
        if(getProfessorFromID(x) != null){
            System.out.println("Professor existente");
            return false;
        }
        professores.put(x.getCodeID(), x);
        return true;
    }
     
    public static Entity Create(String pNome, String uNome, ZonedDateTime nascimento) {
    	Professor nProfessor = new Professor(pNome, uNome, nascimento);
    	addProfessor(nProfessor);
    	return nProfessor;
    }
    // -- beginning of non static fields
    // -- vars
    private ArrayList<Entity> aulas;
    private ArrayList<ArrayList<Entity>> horario;
    private ArrayList<Entity> testes;
    
    //constructors
    public Professor(String pNome, String uNome, ZonedDateTime nascimento) {
	super("Professor", IDCount++ , pNome, uNome, nascimento);
    }
    //Clone constructor
    public Professor(Professor professor){
        super("Professor", professor.getID(), professor.getPrimeiroNome(), professor.getUltimoNome(), professor.getNascimento());
        this.aulas=(ArrayList<Entity>)professor.aulas.clone();
        this.horario=(ArrayList<ArrayList<Entity>>)professor.horario.clone();
        this.testes=(ArrayList<Entity>)professor.testes.clone();
    }
    
    // -- methods
    //Only called by Turma
    public void addAula(Entity aula) throws IllegalArgumentException{
        if(Aula.getAulaFromID(aula)==null){ System.out.println("Aula ID" + aula +" não existe");
            throw new IllegalArgumentException();}
        if(aulas.contains(aula)){
            System.out.println("Já foi atribuida a aula ao professor " + getID());
            throw new IllegalArgumentException();
        }
        aulas.add(aula);
    }
    
    public void removeAula(Entity aula) throws IllegalArgumentException{ //Para atualizar o objeto professor
        if(aulas.contains(aula)){
            aulas.remove(aula);
        }
        else    throw new IllegalArgumentException();
    }
    
    public ArrayList<Entity> getAulas(){
        return (ArrayList<Entity>) aulas.clone();
    }
    
    public void setAulas(ArrayList<Entity> aulas){
        for(int i=0; i<aulas.size();i++){
            this.addAula(aulas.get(i));
        }
    }
    
    public String toString() {
        return "Professor{" + ", professores=" + professores + '}';
    } 
}
