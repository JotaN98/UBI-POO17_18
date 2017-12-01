import projeto.Entity;
import projeto.Nota;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Curso extends Entity {
	// -- beginning of static fields
        // -- vars
	private static long IDCount = 0;
	
	private static Map<String, Curso> cursos = new HashMap<String, Curso>();
	
	public static Curso getCursosFromID(long ID){
		return cursos.get(Entity.getGroupIDFromGroup("Curso") + ID);
	}
	
	public static boolean addCurso(Curso x){
            if(getCursosFromID(x.getID()) != null){
                System.out.println("Curso existente");
                return false;
            }
            cursos.put(x.getCodeID(), x);
            return true;
        }
        public static boolean RemoveCurso(Curso x){
            if(getCursosFromID(x.getID()) != null){
                System.out.println("Curso existente vai remove-lo");
                return false;
            }
            cursos.put(x.getCodeID(), null);
            return true;
        }
     
        public static Curso Create(/*Tem de se meter o resto aqui*/) {
            Curso nCurso = new Curso(/*Tem de se meter o resto aqui*/);
            addCurso(nCurso);
            return nCurso;
        }
    

	
    // -- beginning of non static fields
    // -- vars
    private String nome;
    private ArrayList<Long> disciplinas;
    private long diretor;

    //Contrutores
    public Curso(String nome,long diretor) throws IllegalArgumentException {
    	super("Curso", IDCount++);
    	this.nome=nome;
        disciplinas=new ArrayList<Long>();
        this.diretor=diretor;
    }
    
    public Curso() throws IllegalArgumentException {
    	super("Curso", IDCount++);
    	this.nome="";
        disciplinas=new ArrayList<Long>();
        this.diretor=0;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return nome;
    }

    public ArrayList<Long> getDisciplinas() {
        return disciplinas;
    }
    public long getDiretor(){
        return diretor;
    }
    public void setDiretor(Long diretor){
        this.diretor=diretor;
    }
    public String toString() {
        return "Curso{" + "nome=" + nome + ", disciplinas=" + disciplinas + ", diretor=" + diretor + '}';
    }
    
}