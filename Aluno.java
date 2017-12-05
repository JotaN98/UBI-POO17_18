import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aluno extends Pessoa {
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Aluno> alunos = new HashMap<String, Aluno>();
    
    public static Aluno getAlunoFromID(Entity ID){
        return alunos.get(ID.getCodeID());
    }
     
    public static boolean addAluno(Aluno x){
        if(getAlunoFromID(x) != null){
            System.out.println("Aluno existente");
            return false;
        }
		alunos.put(x.getCodeID(), x);
		return true;
	}
     
    public static Entity Create(String pNome,String uNome, ZonedDateTime nascimento) {
    	Aluno nAluno = new Aluno(pNome, uNome,  nascimento);
    	addAluno(nAluno);
    	return nAluno;
    }
	
    public static Entity Create(String pNome,String uNome, ZonedDateTime nascimento, int ano, Entity curso, Entity turma, boolean active) {
    	Aluno nAluno = new Aluno(pNome, uNome, nascimento, ano, curso, turma, active);
    	addAluno(nAluno);
    	return nAluno;
    }


    // -- beginning of non static fields
    // -- vars
    private int ano;
    private Entity turma;
    private Entity curso;
    private boolean active;
    private ArrayList<Entity/*Disciplinas*/> notas;
    private Map<ZonedDateTime/*time stamp*/,String> activity;

    // -- constructors
    public Aluno(String pNome,String uNome, ZonedDateTime nascimento) {
        super("Aluno", IDCount++, pNome, uNome, nascimento);
        ano = 0;
		turma = Entity.Zero;
		curso = Entity.Zero;
		active = false;
		notas = new ArrayList<Entity>();
        activity = new HashMap<ZonedDateTime,String>();
        activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
    }
	public Aluno(String pNome,String uNome, ZonedDateTime nascimento, int ano, Entity curso, Entity turma, boolean active) {
		super("Aluno", IDCount++, pNome, uNome, nascimento);
		setAno(ano);
		setCurso(curso);
		setTurma(turma);
		this.active = active;
		notas = new ArrayList<Entity>();
		activity = new HashMap<ZonedDateTime,String>();
		activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
	}
	// Clone constructor
	public Aluno(Aluno aluno) {
		super("Aluno", aluno.getID(), aluno.getPrimeiroNome(), aluno.getUltimoNome(), aluno.getNascimento());
		setAno(aluno.getAno());
		setCurso(aluno.getCurso());
		setTurma(aluno.getTurma());
		active = aluno.active;
		notas = (ArrayList<Entity>)aluno.notas.clone();
		activity = new HashMap<ZonedDateTime,String>();
		for (Map.Entry<ZonedDateTime,String> entry : aluno.activity.entrySet()) {
			activity.put(entry.getKey(),entry.getValue());
		}
	}

    // -- methods
    public void setAno(int ano) throws IllegalArgumentException {
		if (ano < 10 || ano > 12) {
			System.out.println("Ano não pode ser maior que 12 ou menor que 10");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(), "Aluno passou de " + this.ano + " para " + ano + " ano.");
		this.ano = ano;
	}

    public void setCurso(Entity curso) throws IllegalArgumentException{
        if(Curso.getCursoFromID(curso)==null) {
			System.out.println("Curso ID \"" + curso + "\" não foi encontrado.");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(),"Aluno mudou do curso "+this.curso+" para "+curso+".");
		this.curso = curso;
	}

    public void setTurma(Entity turma) throws IllegalArgumentException{
		if(Turma.getTurmaFromID(turma)!=null) {
			activity.put(ZonedDateTime.now(),"Aluno mudou de "+this.turma+" para "+turma+".");
			this.turma = turma;
		}
        else {
            System.out.println("Turma ID \"" + turma + "\" não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAno() {
        return ano;
    }

    public Entity getCurso() {
        return curso;
    }

    public Entity getTurma() {
        return turma;
    }

    public boolean getActive(){
    	return active;
	}

	// -- method overrides
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == getClass()){
			Aluno nobj = (Aluno) obj;

			return 	super.equals(obj) &&
					ano == nobj.ano &&
					nobj.turma.equals(this.turma) &&
					nobj.curso.equals(this.curso) &&
					nobj.notas.equals(this.notas) &&
					active == nobj.active &&
					activity.equals(nobj.activity);

		}
		return false;
	}

	@Override
	public Object clone() { 
    	if(ano == 0)   
            return new Aluno(getPrimeiroNome(),getUltimoNome(),getNascimento());
	return new Aluno(getPrimeiroNome(),getUltimoNome(),getNascimento(),ano, curso, turma, active);
	}

	@Override
	public String toString() {
        return getCodeID() +": " + getNome();
    }
    
}