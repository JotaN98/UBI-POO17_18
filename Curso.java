import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Curso extends Entity {
	// -- beginning of static fields
        // -- vars
    private static long IDCount = 1;
    

    private static Map<String, Curso> cursos = new HashMap<String, Curso>();
            
    public static Curso getCursoFromID(Entity ID){
        return cursos.get(ID.getCodeID());
    }
            
    public static void addCurso(Curso x) throws IllegalArgumentException{
        if(getCursoFromID(x).getID() != 0){
            throw new IllegalArgumentException("Curso existente");
        }
        cursos.put(x.getCodeID(), x);
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
    public void addDisciplina(Entity disciplina) throws IllegalArgumentException, NullPointerException{
	
        if(this.getID()==0){
            throw new NullPointerException("Foi apagado");
        }
        if(Disciplina.getDisciplinaFromID(disciplina).getID()==0){
            throw new NullPointerException("Nao existe");
        }
        if(disciplinas.contains(disciplina)){
            throw new IllegalArgumentException("Disciplina ja adicionada");
        }
        disciplinas.add(disciplina);
    }
    public void removeDisciplina(Entity disciplina)throws IllegalArgumentException, NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido");
        if(disciplina.getID()==0)
            throw new NullPointerException("Objeto nao encontrado ou apagado");
        if(!disciplinas.contains(disciplina))
            throw new NullPointerException("Disciplina "+disciplina+" nao faz parte");
        disciplinas.remove(disciplina);
    }
    public void setAtivo(boolean ativo)throws NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido");
        this.ativo=ativo;
    }
    public boolean getAtivo(){
        return ativo;
    }
    public void setNome(String nome)throws NullPointerException {
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido");
	this.nome = nome;
    }
    public String getNome() {
	return nome;
    }
    public ArrayList<Entity> getDisciplinas() {
        return disciplinas;
    }
    public void addDisciplinas(ArrayList<Entity> disciplinas) throws IllegalArgumentException,NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido");
	for(Entity disciplina : disciplinas){
            try{
                addDisciplina(disciplina);
            }catch(NullPointerException | IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public Entity getDiretor(){
        return diretor;
    }
    public void setDiretor(Entity diretor)throws NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objeto já foi removido");
        this.diretor=diretor;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj.getClass()==this.getClass()){
         Curso x = (Curso)obj;
        
         boolean iguais= x.diretor.equals(this.diretor) && this.nome.equals(x.nome);
         iguais=iguais && this.disciplinas.equals(x.disciplinas);
         return iguais;
        }
        return false;
    }
    @Override
    public Object clone(){
        return new Curso(this);
    }

    @Override
    public String toString() {
        return  "nome=" + nome + "ID"+ getCodeID();
    }
    
}
