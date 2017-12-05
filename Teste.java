import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Teste> testes = new HashMap<String, Teste>();
    
    public static Teste getTesteFromID(Entity ID){
        return testes.get(Entity.getGroupIDFromGroup("Teste") + ID);
    }
       
    public static boolean addTeste(Teste x){
        if(getTesteFromID((Entity)x) != null){
            System.out.println("Teste existente");
            return false;
        }
        testes.put(x.getCodeID(), x);
        return true;
    }
     
    public static Teste Create(Entity aula,ZonedDateTime data) {
    	Teste nTeste = new Teste(aula,data);
    	addTeste(nTeste);
    	return nTeste;
    }

    private Map<Entity/*ID*/,Entity/*Valor da nota*/> notas;
    private ZonedDateTime data;
    private Entity aula;
    
    //contrutores
    public Teste(){
        super("Teste",IDCount++);
        aula=Entity.Zero;
        data=ZonedDateTime.now();
        notas=new HashMap<Entity,Entity>();

    }
    public Teste(Entity aula,ZonedDateTime data){
        super("Teste",IDCount++);
        this.aula=aula;
        this.data=data;
        notas=new HashMap<Entity,Entity>();
    }
    public Teste(Teste teste){
        super("Teste",teste.getID());
        this.aula=teste.getAula();
        this.data=teste.getData();
        notas = new HashMap<Entity,Entity>();
		for (Map.Entry<Entity,Entity> entry : teste.notas.entrySet()) {
			notas.put(entry.getKey(),entry.getValue());
        }
    }
    public void setData(ZonedDateTime data) {
        this.data = data;
    }
    public ZonedDateTime getData() {
        return data;
    }
    public void setAula(Entity aula){
        this.aula=aula;
    }
    public Entity getAula(){
        return aula;
    }
}
