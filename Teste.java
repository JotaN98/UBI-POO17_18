import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Teste> testes = new HashMap<String, Teste>();
    
    static{
        Create();
    }
    
    public static Teste getTesteFromID(Entity ID){
        return testes.getOrDefault(
                ID.getCodeID(),
                testes.get(Entity.getGroupIDFromGroup("Teste") + ID)
        );
    }
       
    public static void addTeste(Teste x) throws IllegalArgumentException{
        if(getTesteFromID(x).getID() != 0){
            System.out.println("Objeto já existe.");
        }
        testes.put(x.getCodeID(), x);
    }
     
    public static Entity Create(Entity aula,ZonedDateTime data) {
    	Teste nTeste = new Teste(aula,data);
    	addTeste(nTeste);
    	return nTeste;
    }

    public static Entity Create(){
        Teste nTeste = new Teste();
        addTeste(nTeste);
        return nTeste;
    }
    
    public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{
        
        if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(!testes.containsKey(ID.getCodeID()))  throw new IllegalArgumentException("Teste -"+ID.getCodeID()+"- não existe.");  
            
        getTesteFromID(ID).setID(0);
    }
    
    
    // -- beginning of non static fields
    // -- vars
    private Map<Entity/*Aluno*/,Entity/*Valor da nota*/> notas;
    private ZonedDateTime data;
    private Entity aula;
    
    //contructors
    public Teste(Entity aula,ZonedDateTime data){
        super("Teste",IDCount++);
        this.aula=aula;
        this.data=data;
        notas=new HashMap<Entity,Entity>();
    }
    
    public Teste(){
        super("Teste",IDCount++);
        aula=Entity.Zero;
        data=ZonedDateTime.now();
        notas=new HashMap<Entity,Entity>();

    }
    
    //Clone constructor
    public Teste(Teste teste){
        super("Teste",teste.getID());
        this.aula=teste.getAula();
        this.data=teste.getData();
        notas = new HashMap<Entity,Entity>();
		for (Map.Entry<Entity,Entity> entry : teste.notas.entrySet()) {
			notas.put(entry.getKey(),entry.getValue());
        }
    }
    
    // -- methods
    public void setData(ZonedDateTime data) {
        this.data = data;
    }
    
    public ZonedDateTime getData() {
        return data;
    }
    
    public void setAula(Entity aula) throws IllegalArgumentException, NullPointerException{
        
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(Aula.getAulaFromID(aula).getID()!=0)  this.aula = aula;
        
        else throw new IllegalArgumentException("Aula ID -"+aula+"- não foi encontrado.");
    }
    
    public Entity getAula(){
        return aula;
    }
    public void addNota(double valor,Entity aluno){
        if(this.getID()==0)
            throw new NullPointerException("Objecto ja foi removido");
        if(valor<0 && valor>20)
            throw new IllegalArgumentException("As notas estão compreendidas entre 0 e 20");
        if(notas.containsKey(aluno))
            throw new IllegalArgumentException("O aluno ja tem uma nota");
        Entity notaNova = Nota.Create(aluno,valor);
        try{
            Aluno.getAlunoFromID(aluno).addNota(notaNova);
        }catch(NullPointerException | IllegalArgumentException e){
         notas.put(aluno, notaNova);
        }
    }
    public void removeNota(double valor,Entity aluno,Entity teste) throws IllegalArgumentException, NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objecto ja foi removido");
        if(aluno.getID()==0)
            throw new NullPointerException("Objeto nao encontrado ou apagado");
        if(teste.getID()==0)
            throw new NullPointerException("Objeto nao encontrado ou apagado");
        if(valor<0 && valor>20)
            throw new IllegalArgumentException("As notas têm compreendidas entre 0 e 20");
        if(notas.containsValue(valor))
            throw new IllegalArgumentException("Essa nota não existe");
        try{
            notas.remove(aluno);
        }catch(NullPointerException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
