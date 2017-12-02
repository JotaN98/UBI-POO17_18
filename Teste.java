import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Teste> teste = new HashMap<String, Teste>();
    
    public static Teste getTesteFromID(long ID){
        return teste.get(Entity.getGroupIDFromGroup("Teste") + ID);
    }
       
    public static boolean addTeste(Teste x){
        if(getTesteFromID(x.getID()) != null){
            System.out.println("Teste existente");
            return false;
        }
        teste.put(x.getCodeID(), x);
        return true;
    }
     
    public static Teste Create(/*TEM DE SE METER*/) {
    	Teste nTeste = new Teste(/*TEM DE SE METER*/);
    	addProfessor(nTeste);
    	return nTeste;
    }
	
    public static Teste Create(/*TEM DE SE METER*/) {
    	Teste nTeste = new Teste(/*TEM DE SE METER*/);
    	addProfessor(nTeste);
    	return nTeste;
    }
    private Nota nota;
    private ZonedDateTime data;
    
    //contrutores
    public Teste(String groupClass, long ID){
        super(groupClass, ID);
    }
	
    public Teste(Object groupClass, long ID){
	super(groupClass, ID);
    }
	

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public String getAnoLetivo() {
    	return anoLetivo;
	}

    public String toString() {
        return "Teste{" + "disciplina=" + disciplina + ", data=" + data + '}';
    }
    
}
