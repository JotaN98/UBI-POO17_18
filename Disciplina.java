import java.time.ZonedDateTime;
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
    private int ano;
    private ArrayList<Entity/*Disciplinas*/> aulas;
    private ArrayList<Entity/*Professores*/> professores;
    private ArrayList<String> salas;
    
    
 // -- constructors
    public Disciplina(String pNome) {
        super("Disciplina", IDCount++);
        this.nome = pNome;
        this.ano = 0;
		aulas = new ArrayList<Entity>();
		professores = new ArrayList<Entity>();
    }
	public Disciplina(String pNome, int ano) {
		super("Disciplina", IDCount++);
		this.nome = pNome;
		this.ano = ano;	
	}
	// Clone constructor
	public Disciplina(Disciplina disciplina) {
		super("Disciplina", disciplina.getID());
		setNome(disciplina.getNome());
		setAno(disciplina.getAno());
		setAulas(disciplina.getAulas());
		setProfessores(disciplina.getProfessores());
		setSalas(disciplina.getSalas());
	}
	
	
	
	//Getters Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAulas(ArrayList<Entity> aulas){
    	for(int i =0; i<aulas.size(); i++){
    		this.aulas.add(aulas.get(i));
    	}
    }
    
    public Entity getAulas(Entity ID){
    	return aulas.get(ID);
    }
    
    public void addAula(Entity aulas) {
        this.aulas.add(aulas);
    }


    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", codigo=" + codigo + ", ano=" + ano + ", notas=" + notas + ", lecionadores=" + lecionadores + '}';
    }
}
