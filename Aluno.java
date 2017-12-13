import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aluno extends Pessoa {
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Aluno> alunos = new HashMap<String, Aluno>();

    static {
    	// Aluno null
    	Create();
	}

	public static int size(){
		int c = 0;
		for(Entity prof : alunos.values()){
			c += (prof.getID() != 0)? 1:0;
		}
		return c;
	}

    
    public static Map<String, Aluno> getAlunos(){
        return alunos;
    }
    
    public static Aluno getAlunoFromID(long ID){
        return alunos.getOrDefault(
                Entity.getGroupFromID("Aluno") + ID,
                alunos.get(Entity.getGroupFromID("Aluno") + "0")
        );
    }
    
    public static Aluno getAlunoFromID(Entity ID){
        return alunos.getOrDefault(
        		ID.getCodeID(),
				alunos.get(Entity.getGroupIDFromGroup("Aluno") + "0")
		);
    }
     
    public static void addAluno(Aluno x) throws NullPointerException{
        //if(getAlunoFromID(x).getID() != 0){
        //    throw new NullPointerException("Aluno já foi adicionada.");
        //}
		alunos.put(x.getCodeID(), x);
	}
     
    public static Entity Create() {
    	Aluno nAluno = new Aluno();
    	addAluno(nAluno);
    	return nAluno;
    }

	public static Entity Create(String pNome,String uNome, ZonedDateTime nascimento) {
		Aluno nAluno = new Aluno(pNome, uNome, nascimento);
		addAluno(nAluno);
		return nAluno;
	}
	
    public static Entity Create(String pNome,String uNome, ZonedDateTime nascimento, int ano, Entity curso, boolean active) {
    	Aluno nAluno = new Aluno(pNome, uNome, nascimento, ano, curso, active);
    	addAluno(nAluno);
    	return nAluno;
    }

    public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{
        if(ID.getID() == 0) throw new NullPointerException("Aluno não existe ou já foi removido.");

    	if(!alunos.containsKey(ID.getCodeID()))
			throw new IllegalArgumentException("Aluno -" + ID.getCodeID() + "- não existe.");

    	Teste teste;
    	for (Entity nota : getAlunoFromID(ID).getNotas()){
    		if(nota.getID() != 0) {
				teste = Teste.getTesteFromID(Nota.getNotaFromID(nota).getTeste());
				if(teste.getID() != 0) {
					try {
						teste.removeNota(nota);
					} catch (IllegalArgumentException | NullPointerException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

    	getAlunoFromID(ID).setID(0);
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
    public Aluno() {
        super("Aluno", IDCount++, "", "", null);
        ano = 0;
        turma = Entity.Zero;
	curso = Entity.Zero;
	active = false;
	notas = new ArrayList<Entity>();
        activity = new HashMap<ZonedDateTime,String>();
        activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
    }
	public Aluno(String pNome,String uNome, ZonedDateTime nascimento) {
		super("Aluno", IDCount++, pNome, uNome, nascimento);
		ano = 0;
		curso = Entity.Zero;
		turma = Entity.Zero;
		this.active = true;
		notas = new ArrayList<Entity>();
		activity = new HashMap<ZonedDateTime,String>();
		activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
	}
	public Aluno(String pNome,String uNome, ZonedDateTime nascimento, int ano, Entity curso, boolean active) {
		super("Aluno", IDCount++, pNome, uNome, nascimento);
		setAno(ano);
		setCurso(curso);
		turma = Entity.Zero;
		this.active = active;
		notas = new ArrayList<Entity>();
		activity = new HashMap<ZonedDateTime,String>();
		activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
	}
	// Clone constructor
	public Aluno(Aluno aluno) {
		super("Aluno", IDCount++, aluno.getPrimeiroNome(), aluno.getUltimoNome(), aluno.getNascimento());
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
	public void addNota(Entity nota) throws IllegalArgumentException, NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		Nota rNota = Nota.getNotaFromID(nota);
		if(rNota.getID() == 0)
			throw new IllegalArgumentException("Nota não existe ou foi apagada.");

		// check if nota belongs to student
		if(!Aula.getAulaFromID(Teste.getTesteFromID(rNota.getTeste()).getAula()).getTurma().equals(turma))
			throw new IllegalArgumentException("Aluno não tem o teste -" + rNota.getTeste() +"-.");

		notas.add(nota);
	}
	public void removeNota(Entity nota) throws NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if(Nota.getNotaFromID(nota).getID() == 0)
			throw new IllegalArgumentException("Nota não existe ou foi apagada.");

		if(notas.contains(nota))
			throw new IllegalArgumentException("O Aluno não tem a nota -"+nota+"-.");

		notas.remove(nota);
	}

	public void setAno(int ano) throws IllegalArgumentException, NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if (ano < 10 || ano > 12) {
			System.out.println("Ano não pode ser maior que 12 ou menor que 10");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(), "Aluno passou de " + this.ano + " para " + ano + " ano.");
		this.ano = ano;
	}

    public void setCurso(Entity curso) throws IllegalArgumentException, NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

        if(Curso.getCursoFromID(curso).getID() == 0) {
			System.out.println("Curso ID \"" + curso + "\" não foi encontrado.");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(),"Aluno mudou do curso "+this.curso+" para "+curso+".");
		this.curso = curso;
	}

    public void setTurma(Entity turma) throws IllegalArgumentException, NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if(Turma.getTurmaFromID(turma).getID() != 0) {
			activity.put(ZonedDateTime.now(),"Aluno mudou de "+this.turma+" para "+turma+".");
			this.turma = turma;
		}
        else {
            System.out.println("Turma ID \"" + turma + "\" não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

	public void setActive(boolean active) throws NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");
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

	public ArrayList<Entity> getNotas() {
		return notas;
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
		return new Aluno(this);
	}

	@Override
	public String toString() {
        return getCodeID() +": " + getNome();
    }
    
}