import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turma extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 1;
    
    private static Map<String, Turma> turma = new HashMap<String, Turma>();
    
    public static Turma getTurmaFromID(Entity ID){
        return turma.get(ID.getCodeID());
    }
     
    
    public static void addTurma(Turma x) throws IllegalArgumentException{
        if(getTurmaFromID(x) != null){
            System.out.println("Turma existente");
            throw new IllegalArgumentException();
        }
        turma.put(x.getCodeID(), x);
    }
     
    public static Long Create() {
    	Turma nTurma = new Turma();
    	addTurma(nTurma);
    	return nTurma.getID();
    }
	
    public static Long Create(String anoLetivo, String nome, int ano, long curso, long diretor) {
    	Turma nTurma = new Turma(anoLetivo,nome,ano,curso,diretor);
    	addTurma(nTurma);
    	return nTurma.getID();
    }


    
    
    
    
    // -- beginning of non static fields
    // -- vars
	private String anoLetivo;
    private String nome;
	private int ano;
	private ArrayList<Entity/*Aluno*/> alunos;
	private Entity curso;
	private Entity diretor;
	private ArrayList<Entity/*Aula*/> aulas;
	private ArrayList<ArrayList<Entity/*Aula*/>> horario;
    
    // -- construtores
    public Turma() throws IllegalArgumentException {
		super("Turma", IDCount++);
		anoLetivo = "";
		nome = "";
		ano = 0;
		alunos = new ArrayList<Entity>();
		curso = 0;
		diretor = 0;
		aulas = new ArrayList<Long>();
		horario = new ArrayList<ArrayList<Long>>();
		for (int dds = 0; dds < 5; dds++){
			horario.add(new ArrayList<Long>());
			for (int hora = 0; hora < 10; hora++){
				horario.get(dds).add(0l);
			}
		}
	}
	public Turma(String anoLetivo, String nome, int ano, Entity curso, Entity diretor) throws IllegalArgumentException {
		super("Turma", IDCount++);
		this.anoLetivo = anoLetivo;
		this.nome = nome;
		this.ano = ano;
		this.curso = curso;
		this.diretor = diretor;
		alunos = new ArrayList<Entity>();
		aulas = new ArrayList<Entity>();
		horario = new ArrayList<ArrayList<Entity>>();
		for (int dds = 0; dds < 5; dds++){
			horario.add(new ArrayList<Entity>());
			for (int hora = 0; hora < 10; hora++){
				horario.get(dds).add(Entity.Zero);
			}
		}
	}
	public Turma(Turma turma) throws IllegalArgumentException{
		super("Turma", turma.getID());
		this.anoLetivo = turma.anoLetivo;
		this.nome = turma.nome;
		this.ano = turma.ano;
		this.curso = turma.curso;
		this.diretor = turma.diretor;
		alunos = (ArrayList<Entity>)turma.alunos.clone();
		aulas = (ArrayList<Entity>)turma.aulas.clone();
		horario = (ArrayList<ArrayList<Entity>>)turma.horario.clone();
	}

	// -- methods
	public void addAluno(Entity aluno) throws IllegalArgumentException{
    	// check if aluno exists
    	if(Aluno.getAlunoFromID(aluno) == null) {
			System.out.println("Aluno \""+ aluno +"\" não existe.");
			throw new IllegalArgumentException();
		}
		//
		if(alunos.contains(aluno)){
			System.out.println("Aluno \""+ aluno +"\" já faz parte da turma.");
			throw new IllegalArgumentException();
		}
		// check if aluno is already part of another class in current year
		Entity turmaID = Aluno.getAlunoFromID(aluno).getTurma();
		if(turmaID.getID() != 0 && Turma.getTurmaFromID(turmaID).anoLetivo == anoLetivo)
			Turma.getTurmaFromID(turmaID).removeAluno(aluno);

		Aluno.getAlunoFromID(aluno).setTurma(this);
		alunos.add(aluno);
    }
    public void removeAluno(Entity aluno) throws IllegalArgumentException{
    	// check of aluno is part of this class
		if(!alunos.contains(aluno)){
			System.out.println("Aluno \""+ aluno +"\" não faz parte da turma.");
			throw new IllegalArgumentException();
		}

		Aluno.getAlunoFromID(aluno).setTurma(Entity.Zero);
		alunos.remove(aluno);
	}

	public void addAula(int diaDaSemana, int hora, Entity prof, Entity disciplina, String sala) throws IllegalArgumentException {
		if(diaDaSemana < 0 || diaDaSemana > 4) {
			System.out.println("O período de aulas está compreendido entre Segunda-feira e Sexta-feira");
			throw new IllegalArgumentException();
		}
		if(hora<0 || hora>5) {
			System.out.println("O horário de funcionamento é entre as 8 e as 18 horas");
			throw new IllegalArgumentException();
		}
		// check if prof exists
		if(Professor.getProfessorFromID(prof) == null){
			System.out.println("Professor \""+ prof +"\" não existe.");
			throw new IllegalArgumentException();
		}
		// check if disciplina exists
		if(Disciplina.getDisciplinaFromID(disciplina) == null){
			System.out.println("Disciplina \""+ prof +"\" não existe.");
			throw new IllegalArgumentException();
		}
		// check if sala is within possible salas
		if(	Disciplina.getDisciplinaFromID(disciplina).getPossibleSalas.get(0) != "todas" &&
			!Disciplina.getDisciplinaFromID(disciplina).getPossibleSalas.contains(sala)){
				System.out.println("Sala \""+sala+"\" não pode ser atribuida à disciplina \""+disciplina"\".");
				throw new IllegalArgumentException();
		}

		Entity nAulaID;
		try {
			nAulaID = Aula.Create();
		} catch (IllegalArgumentException e){/*erro está dentro da função*/}

		try {
			Professor.getProfessorFromID(prof).addAula(nAula);
		} catch (IllegalArgumentException e){
			IDCount--;
			DELETEAULA(nAulaID);
		} // criar aula, ver se cabe no prof, se n#ao couber o que fazemos com a aula craiada ?
		// Se criarmos uma aula e depois de alguma criarmos outra e queremos apagar a primeira ?

	}

	public String getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(String anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAno() {
		return ano;
	}

	public ArrayList<Entity> getAlunos() {
		return (ArrayList<Entity>)alunos.clone();
	}
	public void setAlunos(ArrayList<Entity> alunos) {
		for (Entity aluno : alunos){
			try {
				addAluno(aluno);
			} catch (IllegalArgumentException e){/*O erro é mostrado dentro da função addAluno*/}
		}
	}

	public Entity getCurso() {
		return curso;
	}
	public void setCurso(Entity curso) throws IllegalArgumentException {
    	if(Curso.getCursoFromID(curso)==null){
    		System.out.println("Curso \""+ curso +"\" não existe.");
    		throw new IllegalArgumentException();
		}

		this.curso = curso;
	}

	public Entity getDiretor() {
		return diretor;
	}
	public void setDiretor(Entity diretor) {
		if(Professor.getProfessorFromID(diretor)==null){
			System.out.println("Professor \""+ curso +"\" não existe.");
			throw new IllegalArgumentException();
		}
		this.diretor = diretor;
	}


}
