import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Teste> testes = new HashMap<String, Teste>();
    
    public static Teste getTesteFromID(long ID){
        return testes.get(Entity.getGroupIDFromGroup("Teste") + ID);
    }
       
    public static boolean addTeste(Teste x){
        if(getTesteFromID(x.getID()) != null){
            System.out.println("Teste existente");
            return false;
        }
        testes.put(x.getCodeID(), x);
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
    private Map<Long/*ID*/,Long/*Valor da nota*/> notas;
    private ZonedDateTime data;
    private long aula;
    
    //contrutores
    public Teste(){
        super("Teste",IDCount++);
        aula=0;
        data=ZonedDateTime.now();
        notas=new HashMap<Long,Long>();

    }
    public Teste(Long aula,ZonedDateTime data){
        super("Teste",IDCount++);
        this.aula=aula;
        this.data=data;
        notas=new HashMap<Long,Long>();
    }
    public Teste(Teste teste){
        super("Teste",teste.getID());
        this.aula=teste.getAula();
        this.data=teste.getData();
        notas = new HashMap<Long,Long>();
		for (Map.Entry<Long,Long> entry : teste.notas.entrySet()) {
			notas.put(entry.getKey(),entry.getValue());
        }
    }
    public void setData(ZonedDateTime data) {
        this.data = data;
    }
    public ZonedDateTime getData() {
        return data;
    }
    public void setAula(long aula){
        this.aula=aula;
    }
    public long getAula(){
        return aula;
    }
}
