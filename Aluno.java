import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Aluno extends Pessoa {
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Aluno> alunos = new HashMap<String, Aluno>();
    
    public static Aluno getAlunoFromID(long ID){
        return alunos.get(Entity.getGroupIDFromGroup("Aluno") + ID);
    }
     
    
    public static boolean addAluno(Aluno x){
        if(getAlunoFromID(x.getID()) != null){
            System.out.println("Aluno existente");
            return false;
        }
        alunos.put(x.getCodeID(), x);
        return true;
    }
     
    public static Aluno Create(String pNome,String uNome, ZonedDateTime nascimento) {
    	Aluno nAluno = new Aluno(pNome, uNome,  nascimento);
    	addAluno(nAluno);
    	return nAluno;
    }
	
    public static Aluno Create(String pNome,String uNome, ZonedDateTime nascimento, int ano, long curso, long turma, boolean active) {
    	Aluno nAluno = new Aluno(pNome, uNome, nascimento, ano, curso, turma, active);
    	addAluno(nAluno);
    	return nAluno;
    }


    // -- beginning of non static fields
    // -- vars
    private int ano;
    private long curso;
    private long turma;
    private boolean active;
    private Map<Long/*Disciplinas*/,ZonedDateTime> disciplinasPorFazer;
    private Map<Long/*Disciplinas*/,ZonedDateTime> disciplinasFeitas;
    private Map<ZonedDateTime/*time stamp*/,String> activity;

    // -- constructors
    public Aluno(String pNome,String uNome, ZonedDateTime nascimento) {
        super("Aluno", IDCount++, pNome, uNome, nascimento);
        this.ano = 0;
        this.curso = 0;
        this.turma = 0;
        this.active = false;
        activity = new HashMap<ZonedDateTime,String>();
        disciplinasPorFazer = new HashMap<Long,ZonedDateTime>();
        disciplinasFeitas = new HashMap<Long,ZonedDateTime>();
        activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
    }
    public Aluno(String pNome,String uNome, ZonedDateTime nascimento, int ano, long curso, long turma, boolean active) {
        super("Aluno", IDCount++, pNome, uNome, nascimento);
        setAno(ano);
        setCurso(curso);
        setTurma(turma);
        this.active = active;
        activity = new HashMap<ZonedDateTime,String>();
        disciplinasPorFazer = new HashMap<Long,ZonedDateTime>();
        disciplinasFeitas = new HashMap<Long,ZonedDateTime>();
        activity.put(ZonedDateTime.now(), "Aluno "+toString() +", adicionado/a.");
    }

    // -- methods
    public void setAno(int ano) throws IllegalArgumentException {
		if (10 > ano || ano > 12) {
			System.out.println("Ano não pode ser maior que 12 ou menor que 10");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(), "Aluno mudou de " + this.ano + " para " + ano + " ano.");
		this.ano = ano;
	}

    public void setCurso(Long curso) throws IllegalArgumentException{
        if(Curso.getCursoFromID(curso)==null) {
			System.out.println("Curso ID \"" + curso + "\" não foi encontrado.");
			throw new IllegalArgumentException();
		}

		activity.put(ZonedDateTime.now(),"Aluno mudou de "+this.curso+" para "+curso+".");
		this.curso = curso;
    }

    public void setTurma(Long turma) throws IllegalArgumentException{
        if(Turma.getTurmaFromID(turma)!=null)
            this.turma = turma;
        else {
            System.out.println("Turma ID \"" + turma + "\" não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

    public int getAno() {
        return ano;
    }

    public Curso getCurso() {
        return Curso.getCursoFromID(curso);
    }

    public Turma getTurma() {
        return Turma.getTurmaFromID(turma);
    }

	// -- method overrides
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == getClass()){
			Aluno nobj = (Aluno) obj;

			return 	super.equals(obj) &&
					ano == nobj.ano &&
					curso == nobj.curso &&
					turma == nobj.turma &&
					active == nobj.active &&
					disciplinasFeitas.equals(nobj.disciplinasFeitas) &&
					disciplinasPorFazer.equals(nobj.disciplinasPorFazer) &&
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