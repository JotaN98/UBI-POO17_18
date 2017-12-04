import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Disciplina extends Entity{
	
	// -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Disciplina> disciplina = new HashMap<String, Disciplina>();
    
    public static Disciplina getDisciplinaFromID(Entity ID){
        return disciplina.get(ID.getCodeID());
    }
     
    
    public static boolean addDisciplina(Disciplina x){
        if(getDisciplinaFromID(x) != null){
            System.out.println("Disciplina existente");
            return false;
        }
        disciplina.put(x.getCodeID(), x);
        return true;
    }
     
    public static Disciplina Create(/*TEM DE SE METER*/) {
    	Disciplina nDisciplina = new Disciplina(/*TEM DE SE METER*/);
    	addDisciplina(nDisciplina);
    	return nDisciplina;
    }
	
    public static Disciplina Create(/*TEM DE SE METER*/) {
    	Disciplina nDisciplina = new Disciplina(/*TEM DE SE METER*/);
    	addDisciplina(nDisciplina);
    	return nDisciplina;
    }


    
    
    // -- beginning of non static fields
    // -- vars
    private String nome;
    private int codigo;
    private int ano;
    private ArrayList<Nota>notas;
    private ArrayList<Professor> lecionadores;
    
    
    //Construtor
    public Disciplina(String groupClass, long ID) throws IllegalArgumentException {
		super(groupClass, ID);
		IDCount++;
	}


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void setLecionadores(ArrayList<Professor> lecionadores) {
        this.lecionadores = lecionadores;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAno() {
        return ano;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public ArrayList<Professor> getLecionadores() {
        return lecionadores;
    }

    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", codigo=" + codigo + ", ano=" + ano + ", notas=" + notas + ", lecionadores=" + lecionadores + '}';
    }
}
