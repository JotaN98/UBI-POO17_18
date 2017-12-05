import java.util.HashMap;
import java.util.Map;

public class Nota extends Entity{
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Nota> nota = new HashMap<String, Nota>();
    
    public static Nota getNotaFromID(long ID){
        return nota.get(Entity.getGroupIDFromGroup("Nota") + ID);
    }
     
    
    public static boolean addNota(Nota x){
        if(getNotaFromID(x.getID()) != null){
            System.out.println("Nota existente");
            return false;
        }
        nota.put(x.getCodeID(), x);
        return true;
    }
     
    public static Nota Create(Aluno aluno) {
    	Nota nNota = new Nota(aluno);
    	addNota(nNota);
    	return nNota;
    }
	
    public static Nota Create(Aluno aluno,double valor) {
    	Nota nNota = new Nota(aluno,valor);
    	addNota(nNota);
    	return nNota;
    }
    // -- beginning of non static fields
    // -- vars
    private Aluno aluno;
    private double valor;
    //construtores
    public Nota(Aluno aluno,double valor){
    	super("Nota", IDCount++);
    	this.aluno=aluno;
        this.valor=valor;
    }
     public Nota(Aluno aluno){
    	super("Nota", IDCount++);
    	this.aluno=aluno;
        this.valor=0;
    }
    public Nota(Nota nota){
    	super("Nota",nota.getID());
    	this.aluno=nota.getAluno();
        this.valor=nota.getValor();
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public double getValor() {
        return valor;
    }
    public String toString() {
        return "Nota{" + "aluno=" + aluno + ", valor=" + valor + '}';
    }
    @Override
    public boolean equals(Object obj){
        if(obj!=null && obj.getClass()==this.getClass()){
            Nota x=(Nota) obj;
            
            return(this.valor == x.valor && this.aluno.equals(x.aluno));
        }
        return false;
    }
        
    public Object clone(){
        return new Nota(this);
   }     
}
