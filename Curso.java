import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Curso extends Entity {
	// -- beginning of static fields
        // -- vars
    private static long IDCount = 0;
    

    private static Map<String, Curso> cursos = new HashMap<String, Curso>();
    static {
        // Curso null
        Entity e = Create();
    }

    public static int size(){
        int c = 0;
        for(Entity prof : cursos.values()){
            c += (prof.getID() != 0)? 1:0;
        }
        return c;
    }

    public static Map<String, Curso> getCursos(){
        return cursos;
    }


    public static Curso getCursoFromID(long ID){
		return cursos.getOrDefault(
				Entity.getGroupIDFromGroup("Curso") + ID,
				cursos.get(Entity.getGroupFromID("Curso") + "0")
		);
	}

    public static Curso getCursoFromID(Entity ID){
        return cursos.getOrDefault(
        		ID.getCodeID(),
				cursos.get(Entity.getGroupIDFromGroup("Curso") + "0")
		);
    }
            
    public static void addCurso(Curso x) throws IllegalArgumentException{
        //if(getCursoFromID(x).getID() != 0){
        //    throw new IllegalArgumentException("Curso existente");
        //}
        cursos.put(x.getCodeID(), x);
    }
    public static Entity Create() {
        Curso nCurso = new Curso();
        addCurso(nCurso);
        return nCurso;
    }
    public static Entity Create(String nome,Entity diretor) {
        Curso nCurso = new Curso(nome,diretor);
        addCurso(nCurso);
        return nCurso;
    }

    public static void Remove(Entity ID) throws NullPointerException, IllegalArgumentException{
        if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");

        if(!cursos.containsKey(ID.getCodeID()))
            throw new IllegalArgumentException("Curos -" + ID.getCodeID() + "- não existe.");

        Curso curso = getCursoFromID(ID);
        for (Entity turma : Curso.getCursoFromID(ID).getTurmas()) {
		   if(turma.getID() != 0){
                //curso.removeTurma(turma);
				System.out.println("Turma \"" + Turma.getTurmaFromID(turma) + "\" ficou sem curso.");
		   }
        }

		getCursoFromID(ID).setID(0);
    }

    private String nome;
    private ArrayList<Entity> disciplinas;
    private Entity diretor;
    private ArrayList<Entity> turmas;
    private boolean ativo=true;

    //Contrutores
    public Curso(String nome,Entity diretor){
    	super("Curso", IDCount++);
    	this.nome=nome;
        disciplinas=new ArrayList<Entity>();
        turmas=new ArrayList<Entity>();
        this.diretor=diretor;
    }
    public Curso(){
    	super("Curso", IDCount++);
    	this.nome="";
        disciplinas=new ArrayList<Entity>();
        turmas=new ArrayList<Entity>();
        this.diretor=Entity.Zero;
    }
    public Curso(Curso curso){
    	super("Curso", IDCount++);
    	this.nome=curso.getNome();
        disciplinas=(ArrayList<Entity>)curso.disciplinas.clone();
        turmas=(ArrayList<Entity>)curso.turmas.clone();
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
    public ArrayList<Entity> getDisciplinas() {
        return disciplinas;
    }

    public Entity addTurma(String anoLetivo, String nome, int ano, Entity diretor) throws NullPointerException, IllegalArgumentException{
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

        if(ano < 10 || ano > 12)
            throw new IllegalArgumentException("Ano tem que ser entre 10 e 12.");

        for(Curso curso : cursos.values()){
            for(Entity turma : curso.turmas){
                if(Turma.getTurmaFromID(turma).getNome() == nome){
                    throw new IllegalArgumentException("Nome de turma \""+nome+"\" já exsite.");
                }
            }
        }

        Entity nTurma = Turma.Create(anoLetivo,nome,ano,this,diretor);

        turmas.add(nTurma);

        return nTurma;
    }
    public void removeTurma(Entity ID){
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

        if(ID.getID()==0) throw new NullPointerException("Turma não existe.");

        if(!turmas.contains(ID)){
            throw new IllegalArgumentException("Turma -"+ID+"- não existe no curso -"+this+"-.");
        }

        turmas.remove(ID);

        Turma.Remove(ID);
    }
	public void removeTurmaWithoutDeleting(Entity ID){
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if(ID.getID()==0) throw new NullPointerException("Turma não existe.");

		if(!turmas.contains(ID)){
			throw new IllegalArgumentException("Turma -"+ID+"- não existe no curso -"+this+"-.");
		}

		turmas.remove(ID);
	}
	public void addTurmaWithoutCreating(Entity ID){
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if(ID.getID()==0) throw new NullPointerException("Turma não existe.");

		if(turmas.contains(ID)){
			throw new IllegalArgumentException("Turma -"+ID+"- já exsite no curso -"+this+"-.");
		}

		Turma.getTurmaFromID(ID).setCurso(this);
		turmas.add(ID);

	}
    public ArrayList<Entity> getTurmas() {
        return turmas;
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
        return  getCodeID() +": "+ getNome();
    }
    
}
