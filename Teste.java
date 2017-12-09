import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
    // -- beginning of static fields
    // -- vars
    private static long IDCount = 0;
    
    private static Map<String, Teste> testes = new HashMap<String, Teste>();
    
    static{
        Create();
    }
    
    public static Map<String, Teste> getTestes(){
        return testes;
    }
    
    public static Teste getTesteFromID(Entity ID){
        return testes.getOrDefault(
                ID.getCodeID(),
                testes.get(Entity.getGroupIDFromGroup("Teste") + ID)
        );
    }
       
    public static void addTeste(Teste x) throws IllegalArgumentException{
        //if(getTesteFromID(x).getID() != 0){
        //    System.out.println("Objeto já existe.");
        //}
        testes.put(x.getCodeID(), x);
    }
     
    public static Entity Create(Entity aula,ZonedDateTime data) {
    	Teste nTeste = new Teste(aula,data);
    	addTeste(nTeste);
    	return nTeste;
    }

    public static Entity Create(){
        Teste nTeste = new Teste();
        addTeste(nTeste);
        return nTeste;
    }
    
    public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{
        
        if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(!testes.containsKey(ID.getCodeID()))  throw new IllegalArgumentException("Teste -"+ID.getCodeID()+"- não existe.");

        Teste teste = getTesteFromID(ID);
        for (Entity nota : teste.getNotas().values()){
            if(nota.getID() != 0) {
                try {
                    teste.removeNota(nota);
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        getTesteFromID(ID).setID(0);
    }
    
    
    // -- beginning of non static fields
    // -- vars
    private Map<Entity/*Aluno*/,Entity/*Valor da nota*/> notas;
    private ZonedDateTime data;
    private Entity aula;
    
    //contructors
    public Teste(Entity aula,ZonedDateTime data){
        super("Teste",IDCount++);
        this.aula=aula;
        this.data=data;
        notas=new HashMap<Entity,Entity>();
    }
    
    public Teste(){
        super("Teste",IDCount++);
        aula=Entity.Zero;
        data=ZonedDateTime.now();
        notas=new HashMap<Entity,Entity>();

    }
    
    //Clone constructor
    public Teste(Teste teste){
        super("Teste",IDCount++);
        this.aula=teste.getAula();
        this.data=teste.getData();
        notas = new HashMap<Entity,Entity>();
		for (Map.Entry<Entity,Entity> entry : teste.notas.entrySet()) {
			notas.put(entry.getKey(),entry.getValue());
        }
    }
    
    // -- methods
    public void setData(ZonedDateTime data) {
        this.data = data;
    }
    
    public ZonedDateTime getData() {
        return data;
    }
    
    public void setAula(Entity aula) throws IllegalArgumentException, NullPointerException{
        
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(Aula.getAulaFromID(aula).getID()!=0)  this.aula = aula;
        
        else throw new IllegalArgumentException("Aula ID -"+aula+"- não foi encontrado.");
    }
    
    public Entity getAula(){
        return aula;
    }
    public void addNota(double valor,Entity aluno){
        if(this.getID()==0)
            throw new NullPointerException("Objecto ja foi removido");
        if(valor<0 && valor>20)
            throw new IllegalArgumentException("As notas estão compreendidas entre 0 e 20");
        if(notas.containsKey(aluno))
            throw new IllegalArgumentException("O aluno ja tem uma nota");

        Entity notaNova = Nota.Create(aluno,valor);
        try{
            Aluno.getAlunoFromID(aluno).addNota(notaNova);
            notas.put(aluno, notaNova);
        }catch(NullPointerException | IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Não foi possivel adicionar nota ao Aluno -"+ aluno +"-.");
            Nota.Remove(notaNova);
        }
    }

    public Map<Entity, Entity> getNotas() {
        return notas;
    }

    public void removeNota(Entity nota) throws IllegalArgumentException, NullPointerException{
        if(this.getID()==0)
            throw new NullPointerException("Objecto ja foi removido");

        if(Nota.getNotaFromID(nota).getID() == 0)
            throw new IllegalArgumentException("Nota já foi removida.");

        if(!notas.containsValue(nota))
            throw new IllegalArgumentException("Essa nota não existe");

        try {
            Nota.Remove(nota);
            notas.remove(Nota.getNotaFromID(nota).getAluno());
        } catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
            System.out.println("Não foi possivel remover nota -"+nota+"- do aluno -"+Nota.getNotaFromID(nota).getAluno());
        }
    }

    // -- method overrides

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Teste nObj = (Teste) obj;

			return super.equals(obj) &&
					nObj.notas.equals(notas) &&
					nObj.data.equals(data) &&
					nObj.aula.equals(aula);
		}
		return false;
	}

	@Override
	protected Object clone() {
		return new Teste(this);
	}

	@Override
	public String toString() {
		return getCodeID() + ": "+ Disciplina.getDisciplinaFromID(Aula.getAulaFromID(aula).getDisciplina()).getNome() +" - "+ data;
	}
}
