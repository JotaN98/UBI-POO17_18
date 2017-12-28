import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa{
	// -- beginning of static fields
	// -- vars
	private static Map<String, Professor> professores = new HashMap<String, Professor>();
	private static long IDCount = 0;


	static{
		Create();
	}

	public static int size(){
		int c = 0;
		for(Entity prof : professores.values()){
			c += (prof.getID() != 0)? 1:0;
		}
		return c;
	}

	public static Map<String, Professor> getProfessores(){
		return professores;
	}

	public static Professor getProfessorFromID(long ID){
		return professores.getOrDefault(
			Entity.getGroupIDFromGroup("Professor") + ID,
			professores.get(Entity.getGroupIDFromGroup("Professor") + "0")
		);
	}

	public static Professor getProfessorFromID(Entity ID){
		return professores.getOrDefault(
			ID.getCodeID(),
			professores.get(Entity.getGroupIDFromGroup("Professor") + "0")
		);
	}

	public static void addProfessor (Professor x) throws IllegalArgumentException{
		//if(getProfessorFromID(x).getID() != 0){
		//	throw new IllegalArgumentException("Objeto já existe.");
		//}
		professores.put(x.getCodeID(), x);
	}

	public static Entity Create(String pNome, String uNome, ZonedDateTime nascimento) {
		Professor nProfessor = new Professor(pNome, uNome, nascimento);
		addProfessor(nProfessor);
		return nProfessor;
	}

	public static Entity Create(){
		Professor nProfessor = new Professor();
		addProfessor(nProfessor);
		return new Professor();
	}

	public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{

		if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");

		if(!professores.containsKey(ID.getCodeID()))  throw new IllegalArgumentException("Professor -"+ID.getCodeID()+"- não existe.");

		getProfessorFromID(ID).setID(0);
	}

	// -- beginning of non static fields
	// -- vars
	private ArrayList<Entity> aulas;
	private ArrayList<ArrayList<Entity>> horario;
	private ArrayList<Entity> testes;

	//constructors
	public Professor(String pNome, String uNome, ZonedDateTime nascimento) {
	super("Professor", IDCount++ , pNome, uNome, nascimento);
		aulas=new ArrayList<Entity>();
		testes=new ArrayList<Entity>();

		for(int dia=0; dia<Aula.ConversorDiaDaSemana.size();dia++){
			horario.add(new ArrayList<Entity>());
			for(int hora=0; hora<Aula.ConversorHoras.size();hora++){
				horario.get(dia).add(Entity.Zero);
			}
		}
	}

	public Professor(){
		super("Professor", IDCount++, "", "", null);
		aulas=new ArrayList<Entity>();
		testes=new ArrayList<Entity>();
		horario = new ArrayList<ArrayList<Entity>>();

		for(int dia=0; dia<Aula.ConversorDiaDaSemana.size();dia++){
			horario.add(new ArrayList<Entity>());
			for(int hora=0; hora<Aula.ConversorHoras.size();hora++){
				horario.get(dia).add(Entity.Zero);
			}
		}
	}

	//Clone constructor
	public Professor(Professor professor){
		super("Professor",  IDCount++, professor.getPrimeiroNome(), professor.getUltimoNome(), professor.getNascimento());
		this.aulas=(ArrayList<Entity>)professor.aulas.clone();
		this.horario=(ArrayList<ArrayList<Entity>>)professor.horario.clone();
		this.testes=(ArrayList<Entity>)professor.testes.clone();
	}

	// -- methods

	//Only called by Turma
	public void addAula(Entity aula) throws IllegalArgumentException, NullPointerException{
		Aula nAula = Aula.getAulaFromID(aula);
		int DiaDaSemana = nAula.getDiaDaSemana();
		int Hora = nAula.getHora();

		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");

		//check if Professor can teach Disciplina
		if(!Disciplina.getDisciplinaFromID(nAula.getDisciplina()).getProfessores().contains(this)){
			throw new IllegalArgumentException("O professor ID -"+getCodeID()+"- não pode dar esta Disciplina.");
		}

		//Check if horario is free
		if(horario.get(DiaDaSemana).get(Hora).getID()!= 0){
			throw new IllegalArgumentException("O professor-"+getCodeID()+"-já tem uma aula no bloco pretendido");
		}

		//check if aula exists
		if(Aula.getAulaFromID(aula).getID()==0){
			throw new IllegalArgumentException("Aula -"+aula+"- não pode ser adicinionada ao professor-"+getCodeID()+"- porque não existe.");
		}

		//check if aula has already been assigned
		if(aulas.contains(aula)){
			throw new IllegalArgumentException("Já foi atribuida a aula -"+aula+"- ao professor ID -" + getCodeID() + "-");
		}
		aulas.add(aula);
		//Update horario
		horario.get(DiaDaSemana).set(Hora, aula);
	}


	public void removeAula(Entity aula) throws IllegalArgumentException{ //Para atualizar o objeto professor
		if(aulas.contains(aula)){
			aulas.remove(aula);
		}
		else	throw new IllegalArgumentException("Aula não existe.");
	}

	public ArrayList<Entity> getAulas(){
		return (ArrayList<Entity>) aulas.clone();
	}

	public void setAulas(ArrayList<Entity> aulas) throws NullPointerException{

		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");

		for(int i=0; i<aulas.size();i++){
			try{
				this.addAula(aulas.get(i));}
			catch(NullPointerException | IllegalArgumentException Error){
				System.out.println(Error.getMessage());
			}
		}
	}

	public void addTeste(Entity teste) throws IllegalArgumentException, NullPointerException{
  
		//Check if aula do teste is an aula of Professor
		if(! getAulas().contains( Teste.getTesteFromID(teste).getAula() )){
			throw new IllegalArgumentException("O professor -"+getCodeID()+"- não dá a aula do teste -"+teste+"- .");
		}

		//check if teste exists
		if(Teste.getTesteFromID(teste).getID()==0){
			throw new IllegalArgumentException("Teste -"+teste+"- não pode ser criado pelo professor-"+getCodeID()+"- porque não existe.");
		}

		//check if teste has already been assigned
		if(testes.contains(teste)){
			throw new IllegalArgumentException("Já foi criado o teste -"+teste+"- pelo professor ID -" + getCodeID() + "-");
		}

		testes.add(teste);
	}

	public void removeTeste(Entity teste) throws IllegalArgumentException{ //Para atualizar o objeto professor
		if(testes.contains(teste)){
			testes.remove(teste);
		}
		else	throw new IllegalArgumentException("Teste não existe.");
	}

	public ArrayList<Entity> getTestes(){
		return (ArrayList<Entity>) testes.clone();
	}

	public void setTestes(ArrayList<Entity> testes) throws NullPointerException{

		if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");

		for(int i=0; i<testes.size();i++){
			try{
				this.addTeste(testes.get(i));}
			catch(IllegalArgumentException | NullPointerException Error){
				System.out.println(Error);
			}
		}
	}

	public ArrayList<ArrayList<Entity>> getHorario(){
		return (ArrayList<ArrayList<Entity>>) horario.clone();
	}

	@Override
	public boolean equals(Object obj){
		if(obj != null && obj.getClass()==getClass()){
			Professor nObj = (Professor) obj;
			return super.equals(obj)
					&& nObj.aulas.equals(aulas)
					&& nObj.horario.equals(horario)
					&& nObj.testes.equals(testes);
			}
			return false;
	}

	@Override
	public Object clone(){
		return new Professor(this);
	}

	public String toString() {
		return getCodeID() + ": " + getNome();
	}
}
