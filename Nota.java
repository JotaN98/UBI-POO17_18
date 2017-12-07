import java.util.HashMap;
import java.util.Map;

public class Nota extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Nota> nota = new HashMap<String, Nota>();
    
    static{
        Create();
    }
    
    public static Nota getNotaFromID(Entity ID){
        return nota.getOrDefault(
                ID.getCodeID(),
                nota.get(Entity.getGroupIDFromGroup("Nota") + ID)
        );
    }
      
    public static void addNota(Nota x) throws IllegalArgumentException{
        if(getNotaFromID(x).getID() != 0){
            throw new IllegalArgumentException("Objeto já existe.");
        }
        nota.put(x.getCodeID(), x);
    }
	
    public static Entity Create(Entity aluno, double valor) {
    	Nota nNota = new Nota(aluno,valor);
    	addNota(nNota);
    	return nNota;
    }
    public static Entity Create(Entity aluno,double valor,Entity teste){
        Nota nNota = new Nota(aluno,valor,teste);
    	addNota(nNota);
    	return nNota;
    }
    
    public static Entity Create(){
        Nota nNota = new Nota();
        addNota(nNota);
        return nNota;
    }
    
    public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{
        
        if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(!nota.containsKey(ID.getCodeID())) throw new IllegalArgumentException("Nota -"+ID.getCodeID()+"- não existe.");
    
        getNotaFromID(ID).setID(0);
    }
    
    // -- beginning of non static fields
    // -- vars
    private Entity aluno;
    private double valor;
    private Entity teste;
    
    // -- constructors
    public Nota(Entity aluno, double valor){
    	super("Nota", IDCount++);
    	this.aluno=aluno;
        this.valor=valor;
    }
    public Nota(Entity aluno, double valor,Entity teste){
    	super("Nota", IDCount++);
    	this.aluno=aluno;
        this.valor=valor;
        this.teste=teste;
    }
     public Nota(){
    	super("Nota", IDCount++);
    	this.aluno=Entity.Zero;
        this.valor=0;
    }
     
    //Clone constructor
    public Nota(Nota nota){
    	super("Nota",IDCount++);
    	this.aluno=nota.getAluno();
        this.valor=nota.getValor();
    }
    
    // -- methods
    public Entity getAluno() {
        return aluno;
    }
    
    public void setAluno(Entity aluno) throws IllegalArgumentException, NullPointerException{
        
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(Aluno.getAlunoFromID(aluno).getID()!=0)  this.aluno = aluno;
        
        else throw new IllegalArgumentException("Aluno ID -"+aluno+"- não foi encontrado.");
    }
    
        
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    public Entity getTeste(){
        return teste;
    }
    public void setTeste(Entity teste)throws IllegalArgumentException, NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido.");
        if(Teste.getTesteFromID(teste).getID()!=0){
            this.teste=teste;
        }
        else
            throw new IllegalArgumentException("Teste -"+teste+"- não foi encontrado.");    
    }
    

    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj.getClass()==getClass()){
            Nota nObj=(Nota) obj;
            
           return super.equals(obj)
                   && aluno == nObj.aluno
                   && valor == nObj.valor;
        }
        return false;
    }
      
    public Object clone(){
        return new Nota(this);
   }  
    
    public String toString() {
        return ""+getCodeID()+": "+" Aluno: " + Aluno.getAlunoFromID(aluno) + " Valor: " + valor;
    }   
}
