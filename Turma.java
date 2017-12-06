import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turma extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Turma> turmas = new HashMap<String, Turma>();

    static {
    	// Turma null
    	Create();
	}

    public static Turma getTurmaFromID(Entity ID){
        return turmas.getOrDefault(
        		ID.getCodeID(),
				turmas.get(Entity.getGroupIDFromGroup("Turma") + "0")
		);
    }
     
    
    public static void addTurma(Turma x) throws NullPointerException{
        if(getTurmaFromID(x).getID() == 0){
            throw new NullPointerException("Turma nãoexistente");
        }
        turmas.put(x.getCodeID(), x);
    }
     
    public static Entity Create() {
    	Turma nTurma = new Turma();
    	addTurma(nTurma);
    	return nTurma;
    }
	
    public static Entity Create(String anoLetivo, String nome, int ano, Entity curso, Entity diretor) {
    	Turma nTurma = new Turma(anoLetivo,nome,ano,curso,diretor);
    	addTurma(nTurma);
    	return nTurma;
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
		curso = Entity.Zero;
		diretor = Entity.Zero;
		aulas = new ArrayList<Entity>();
		horario = new ArrayList<ArrayList<Entity>>();
		for (int dds = 0; dds < 5; dds++){
			horario.add(new ArrayList<Entity>());
			for (int hora = 0; hora < 10; hora++){
				horario.get(dds).add(Entity.Zero);
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
	public Turma(Turma turma){
		super("Turma", IDCount++);
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
	public void addAluno(Entity aluno) throws IllegalArgumentException, NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		// check if aluno exists
    	if(Aluno.getAlunoFromID(aluno).getID() == 0) {
			throw new NullPointerException("Aluno \""+ aluno +"\" não existe.");
		}
		// check if turma already has aluno
		if(alunos.contains(aluno)){
			throw new IllegalArgumentException("Aluno \""+ aluno +"\" já faz parte da turma.");
		}
		// check if aluno is already part of another class in current year
		Entity turmaID = Aluno.getAlunoFromID(aluno).getTurma();
		if(turmaID.getID() != 0 && Turma.getTurmaFromID(turmaID).anoLetivo == anoLetivo)
			Turma.getTurmaFromID(turmaID).removeAluno(aluno);

		Aluno.getAlunoFromID(aluno).setTurma(this);
		alunos.add(aluno);
    }
    public void removeAluno(Entity aluno) throws IllegalArgumentException, NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		// check if aluno exists
		if(aluno.getID() == 0)
			throw new NullPointerException("Objeto não encontrado ou apagado.");
    	// check of aluno is part of this class
		if(!alunos.contains(aluno)){
			throw new IllegalArgumentException("Aluno \""+ aluno +"\" não faz parte da turma.");
		}

		Aluno.getAlunoFromID(aluno).setTurma(Entity.Zero);
		alunos.remove(aluno);
	}

	public void addAula(int hora, int diaDaSemana, Entity prof, Entity disciplina, String sala) throws IllegalArgumentException, NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		// check if dia da semana e hora estão dentro
    	if(diaDaSemana < 0 || diaDaSemana > 4) {
			throw new IllegalArgumentException("O período de aulas está compreendido entre Segunda-feira e Sexta-feira");
		}
		if(hora<0 || hora>9) {
			throw new IllegalArgumentException("O horário de funcionamento é entre as 8 e as 18 horas");
		}

		// check if prof exists
		if(Professor.getProfessorFromID(prof) == null){
			throw new IllegalArgumentException("Professor \""+ prof +"\" não existe.");
		}

		// check if disciplina exists
		if(Disciplina.getDisciplinaFromID(disciplina) == null){
			throw new IllegalArgumentException("Disciplina \""+ prof +"\" não existe.");
		}

		// check if sala is within possible salas
		if(	Disciplina.getDisciplinaFromID(disciplina).getPossibleSalas.get(0) != "todas" &&
			!Disciplina.getDisciplinaFromID(disciplina).getPossibleSalas.contains(sala)){
				throw new IllegalArgumentException("Sala \""+sala+"\" não pode ser atribuida à disciplina \""+disciplina+"\".");
		}

		// check if aula is already in horario
		if(horario.get(diaDaSemana).get(hora).getID() != 0){
			throw new IllegalArgumentException("Aula \""+ horario.get(diaDaSemana).get(hora) + "\" já existe.");
		}

		Entity nAulaID = Aula.Create(hora, diaDaSemana, prof, disciplina, this, sala);
		try {
			Professor.getProfessorFromID(prof).addAula(nAulaID);
		} catch (IllegalArgumentException e){
			Aula.Remove(nAulaID);
			throw e;
		}
	}

	public String getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(String anoLetivo) throws  NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		this.anoLetivo = anoLetivo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		this.nome = nome;
	}

	public void setAno(int ano) throws IllegalArgumentException, NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

    	if(ano < 10 || ano > 12)
    		throw new IllegalArgumentException("Ano tem que ser entre 10 e 12.");

		this.ano = ano;
	}
	public int getAno() {
		return ano;
	}

	public ArrayList<Entity> getAlunos() {
		return (ArrayList<Entity>)alunos.clone();
	}
	public void setAlunos(ArrayList<Entity> alunos) throws  NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		for (Entity aluno : alunos){
			try {
				addAluno(aluno);
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	public Entity getCurso() {
		return curso;
	}
	public void setCurso(Entity curso) throws NullPointerException {
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

    	if(Curso.getCursoFromID(curso).getID() == 0){
    		throw new NullPointerException("Curso não existe ou foi apagado.");
		}

		this.curso = curso;
	}

	public Entity getDiretor() {
		return diretor;
	}
	public void setDiretor(Entity diretor) throws NullPointerException{
		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido");

		if(Professor.getProfessorFromID(diretor).getID() == 0)
			throw new IllegalArgumentException("Professor não existe ou foi apagado.");

		this.diretor = diretor;
	}


	// -- method overrides
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj.getClass() == getClass()) {
			Turma nObj = (Turma)obj;

			return 	super.equals(obj) &&
					anoLetivo == nObj.anoLetivo &&
					nome == nObj.nome &&
					nObj.alunos.equals(alunos) &&
					nObj.curso.equals(curso) &&
					nObj.diretor.equals(diretor) &&
					nObj.aulas.equals(aulas) &&
					nObj.horario.equals(horario);
		}
		return false;
	}

	@Override
	protected Object clone() {
		return new Turma(this);
	}

	@Override
	public String toString() {
		return getCodeID() +": " + getNome();
	}
}
