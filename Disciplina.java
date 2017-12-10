import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Disciplina extends Entity {

	// -- beginning of static fields
	// -- vars
	private static long IDCount = 0;

	private static Map<String, Disciplina> disciplina = new HashMap<String, Disciplina>();

	static {
		// Disciplina null
		Create();
	}
        

	public static Map<String, Disciplina> getDisciplinas(){
		return disciplina;
	}

	public static Disciplina getDisciplinaFromID(long ID) {
		return disciplina.getOrDefault(
				Entity.getGroupIDFromGroup("Disciplina") + ID,
				disciplina.get(Entity.getGroupIDFromGroup("Disciplina") + "0")
		);
	}

	public static Disciplina getDisciplinaFromID(Entity ID) {
		return disciplina.getOrDefault(
				ID.getCodeID(),
				disciplina.get(Entity.getGroupIDFromGroup("Disciplina") + "0")
		);
	}


	public static void addDisciplina(Disciplina x) throws IllegalArgumentException {
		if (getDisciplinaFromID(x).getID() != 0) {
			throw new IllegalArgumentException("Disciplina -" + x + "- existente.");
		}
		disciplina.put(x.getCodeID(), x);
	}

	public static Entity Create() {
		Disciplina nDisciplina = new Disciplina();
		addDisciplina(nDisciplina);
		return nDisciplina;
	}

	public static Entity Create(String pNome, int ano) {
		Disciplina nDisciplina = new Disciplina(pNome, ano);
		addDisciplina(nDisciplina);
		return nDisciplina;
	}

	public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException {

		if (ID.getID() == 0) throw new NullPointerException("Objeto já foi removido.");

		if (!disciplina.containsKey(ID.getCodeID()))
			throw new IllegalArgumentException("Disciplina -" + ID.getCodeID() + "- não existe.");

		Disciplina disciplina = getDisciplinaFromID(ID);

		Turma turma;
		for (Entity aula : disciplina.aulas) {
			turma = Turma.getTurmaFromID(Aula.getAulaFromID(aula).getTurma());
			if (turma.getID() != 0) {
				try {
					turma.removeAula(aula);
				} catch (IllegalArgumentException | NullPointerException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		getDisciplinaFromID(ID).setID(0);
	}


	// -- beginning of non static fields
	// -- vars
	private String nome;
	private int ano;
	private ArrayList<Entity/*Disciplinas*/> aulas;
	private ArrayList<Entity/*Professores*/> professores;
	private ArrayList<String> possibleSalas;


	// -- constructors
	public Disciplina() {
		super("Disciplina", IDCount++);
		this.nome = "";
		this.ano = 0;
		aulas = new ArrayList<Entity>();
		professores = new ArrayList<Entity>();
		possibleSalas = new ArrayList<String>();
	}

	public Disciplina(String pNome, int ano) {
		super("Disciplina", IDCount++);
		this.nome = pNome;
		this.ano = ano;
		aulas = new ArrayList<Entity>();
		professores = new ArrayList<Entity>();
		possibleSalas = new ArrayList<String>();
	}

	// Clone constructor
	public Disciplina(Disciplina disciplina) {
		super("Disciplina", IDCount++);
		nome = disciplina.getNome();
		ano = disciplina.getAno();
		aulas = (ArrayList<Entity>) disciplina.aulas.clone();
		professores = (ArrayList<Entity>) disciplina.professores.clone();
		possibleSalas = (ArrayList<String>) disciplina.possibleSalas.clone();
	}

	//Getters Setters
	public void addAula(Entity aula) throws NullPointerException, IllegalArgumentException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		// check if aula exists
		if (Aula.getAulaFromID(aula).getID() == 0)
			throw new IllegalArgumentException("Aula -" + aula + "- não existe.");

		// check if aula is already in aulas
		if (aulas.contains(aula))
			throw new IllegalAccessError("Aula -" + aula + "- já faz parte das disciplinas.");

		this.aulas.add(aula);
	}

	public void addAulas(ArrayList<Entity> _aulas) throws NullPointerException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		for (Entity aula : _aulas) {
			try {
				addAula(aula);
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public ArrayList<Entity> getAulas(Entity ID) {
		return aulas;
	}

	public void removeAula(Entity aula) {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		// check if aula exists
		if (Aula.getAulaFromID(aula).getID() == 0)
			throw new NullPointerException("Aula -" + aula + "- não existe.");

		// check if aula is in aulas
		if (!aulas.contains(aula))
			throw new IllegalArgumentException("Aula -" + aula + "- não existe.");

		aulas.remove(aulas);
	}

	public void addProfessor(Entity prof) throws NullPointerException {
		//if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		// check if prof exists
		if (Professor.getProfessorFromID(prof).getID() == 0)
			throw new NullPointerException("Professor não existe.");

		// check if prof is already in profs
		if (professores.contains(prof))
			throw new IllegalAccessError("Professor -" + prof + "- já existe.");

		this.professores.add(prof);
	}

	public void addProfessores(ArrayList<Entity> profs) throws NullPointerException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		for (Entity prof : profs) {
			try {
				addProfessor(prof);
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public ArrayList<Entity> getProfessores() {
		return professores;
	}

	public void addPossibleSala(String sala) throws NullPointerException, IllegalArgumentException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		if (sala.contains(sala))
			throw new IllegalArgumentException("Sala " + sala + "já foi adicionada.");

		possibleSalas.add(sala);
	}

	public void addPossibleSalas(ArrayList<String> salas) {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		for (String sala : salas) {
			try {
				addPossibleSala(sala);
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public ArrayList<String> getPossibleSalas() {
		return possibleSalas;
	}

	public void setNome(String nome) throws NullPointerException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setAno(int ano) throws NullPointerException {
		if (this.getID() == 0) throw new NullPointerException("Objeto já foi removido");

		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}


	// -- method overrides


	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Disciplina nObj = (Disciplina) obj;

			return super.equals(nObj) &&
					nome == nObj.nome &&
					ano == nObj.ano &&
					nObj.aulas.equals(aulas) &&
					nObj.professores.equals(professores) &&
					nObj.possibleSalas.equals(possibleSalas);
		}
		return false;
	}

	@Override
	protected Object clone() {
		return new Disciplina(this);
	}

	@Override
	public String toString() {
		return getCodeID() +": "+nome;
	}
}
