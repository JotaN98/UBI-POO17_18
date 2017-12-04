import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Curso extends Entity {
	// -- beginning of static fields
        // -- vars
    private static long IDCount = 0;
    

    private static Map<String, Curso> cursos = new HashMap<String, Curso>();
            
    public static Curso getCursosFromID(Entity ID){
        return cursos.get(Entity.getGroupIDFromGroup("Curso") + ID);
    }
            
    public static boolean addCurso(Curso x){
        if(getCursosFromID((Entity)x) != null){
            System.out.println("Curso existente");
            return false;
        }
        cursos.put(x.getCodeID(), x);
        return true;
    }
    public static Curso Create(String nome,Entity diretor) {
    	Curso nCurso = new Curso(nome,diretor);
    	addCurso(nCurso);
    	return nCurso;
    }
    private String nome;
    private ArrayList<Entity> disciplinas;
    private Entity diretor;
    private boolean ativo=true;

    //Contrutores
    public Curso(String nome,Entity diretor){
    	super("Curso", IDCount++);
    	this.nome=nome;
        disciplinas=new ArrayList<Entity>();
        this.diretor=diretor;
    }
    public Curso(){
    	super("Curso", IDCount++);
    	this.nome="";
        disciplinas=new ArrayList<Entity>();
        this.diretor=Entity.Zero;
    }
    public Curso(Curso curso){
    	super("Curso", curso.getID());
    	this.nome=curso.getNome();
        disciplinas=(ArrayList<Entity>)curso.disciplinas.clone();
        this.diretor=curso.getDiretor();
    }
    public void setAtivo(boolean ativo){
        this.ativo=ativo;
    }
    public boolean getAtivo(){
        return ativo;
    }
    public void setNome(String nome) {
	this.nome = nome;
    }
    public String getNome() {
	return nome;
    }
    public ArrayList<Entity> getDisciplinas() {
        return disciplinas;
    }
    public Entity getDiretor(){
        return diretor;
    }
    public void setDiretor(Entity diretor){
        this.diretor=diretor;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass()==this.getClass()){
         Curso x = (Curso)obj;
        
         boolean iguais= this.diretor == x.diretor && this.nome.equals(x.nome);
         iguais=iguais && this.disciplinas.equals(x.disciplinas);
         return iguais;
        }
        return false;
    }
    @Override
    public Object clone(){
        return new Curso(this);
    }
}
