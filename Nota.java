import java.util.HashMap;
import java.util.Map;

public class Nota extends Entity{
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
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
     
    public static Nota Create(/*TEM DE SE METER*/) {
    	Nota nNota = new Nota(/*TEM DE SE METER*/);
    	addNota(nNota);
    	return nNota;
    }
	
    public static Nota Create(/*TEM DE SE METER*/) {
    	Nota nNota = new Nota(/*TEM DE SE METER*/);
    	addNota(nNota);
    	return nNota;
    }

    
    
    
    // -- beginning of non static fields
    // -- vars
    
    //construtores
	public Nota(String groupClass, long ID) throws IllegalArgumentException {
		super(groupClass, ID);
	}
	
	public Nota(Object groupClass, long ID){
		super(groupClass, ID);
	}
	
	
    private Aluno aluno;
    private Teste teste;
    private double valor;
    
    //ADICIONAR MAPA PARA NOTAS

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Teste getTeste() {
        return teste;
    }

    public double getValor() {
        return valor;
    }

    public String toString() {
        return "Nota{" + "aluno=" + aluno + ", teste=" + teste + ", valor=" + valor + '}';
    }
    
}
