import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Aula extends Entity implements Serializable {
    // -- beginning of static fields
    // -- vars
    private static final Map<String, Aula> aulas = new HashMap<String, Aula>();
    
    private static long IDCount = 0;
    protected static ArrayList<String> ConversorHoras;
    protected static ArrayList<String> ConversorDiaDaSemana;
    
    static{
    	// aula null
        Create();
    }
    
    public static Map<String, Aula> getAulas(){
        return aulas;
    }
    
    //Initialize Hours and Days of the week converters
    static{
        ConversorHoras = new ArrayList<String>();
        ConversorHoras.add("8:20h - 9:50h");
        ConversorHoras.add("10:10h - 11:40h");
        ConversorHoras.add("11:50h - 13:20h");
        ConversorHoras.add("15:00h - 16:30h");
        ConversorHoras.add("16:45h - 18:15h");
        
        ConversorDiaDaSemana= new ArrayList<String>();
        ConversorDiaDaSemana.add("Segunda-feira");
        ConversorDiaDaSemana.add("Terça-feira");
        ConversorDiaDaSemana.add("Quarta-feira");
        ConversorDiaDaSemana.add("Quinta-feira");
        ConversorDiaDaSemana.add("Sexta-feira");
    }
    
     public static Aula getAulaFromID(long ID){
        return aulas.getOrDefault(
                Entity.getGroupIDFromGroup("Aula") + ID,
                aulas.get(Entity.getGroupIDFromGroup("Aula") + "0")
        );
    }  
    
    public static Aula getAulaFromID(Entity ID){
        return aulas.getOrDefault(
                ID.getCodeID(),
                aulas.get(Entity.getGroupIDFromGroup("Aula") + "0")
        );
    }
    
    public static void addAula(Aula x)throws IllegalArgumentException{
        //if(getAulaFromID(x).getID()!= 0){
        //    throw new IllegalArgumentException("Objeto já existe.");
        //}

        // for loading
        while(IDCount <= x.getID())
            IDCount++;
        aulas.put(x.getCodeID(), x);
    }
   
    public static Entity Create(int hora, int DiaDaSemana, Entity prof, Entity disciplina, Entity turma, String sala){
        Aula nAula = new Aula(hora, DiaDaSemana, prof, disciplina, turma, sala);
        addAula(nAula);
        return nAula;
    }
    
    public static Entity Create(){
        Aula nAula = new Aula();
        addAula(nAula);
        return nAula;
    }
	
	public static Entity create(int id){
		while(IDCount<id-1)
			IDCount++;
		Aula nAula = new Aula();
        addAula(nAula);
        return nAula;
	}
    
     
    public static void Remove(Entity ID) throws IllegalArgumentException, NullPointerException{
        
        if(ID.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(!aulas.containsKey(ID.getCodeID()))  throw new IllegalArgumentException("Aula -"+ID.getCodeID()+"- não existe.");  

        try {
        	Disciplina.getDisciplinaFromID(ID).removeAula(ID);
		} catch(IllegalArgumentException | NullPointerException e){
        	System.out.println(e.getMessage());
		}


		getAulaFromID(ID).setID(0);
    }
    
    // -- beginning of non static fields
    // -- vars
    private int hora;
    private int DiaDaSemana;
    private Entity prof;
    private Entity disciplina;
    private Entity turma;
    private String sala;
    
     // -- constructors
    public Aula(int hora, int DiaDaSemana, Entity prof, Entity disciplina, Entity turma, String sala){
        super("Aula", IDCount++);
        this.hora=hora;
        this.DiaDaSemana=DiaDaSemana;
        this.prof=prof;
        this.disciplina=disciplina;
        this.turma=turma;
        this.sala=sala;
    }

    public Aula(){
        super("Aula", IDCount++);
        this.hora=0;
        this.DiaDaSemana=0;
        this.prof=Entity.Zero;
        this.disciplina=Entity.Zero;
        this.turma=Entity.Zero;
        this.sala="";
    }
    
    //Clone constructor
    public Aula(Aula aula){
        super("Aula", IDCount++);
        this.hora=aula.getHora();
        this.prof=aula.getProfessor();
        this.disciplina=aula.getDisciplina();
        this.turma=aula.getTurma();
        this.sala=aula.getSala();
    }
   
    // -- methods
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) throws IllegalArgumentException, NullPointerException {
        
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if( hora<0 || hora>5){
                throw new IllegalArgumentException("O horário de funcionamento é entre as 8 e as 18 horas");}
        this.hora = hora;
    }
    
    public int getDiaDaSemana(){
        return DiaDaSemana;
    }
    
    public void setDiaDaSemana(int DiaDaSemana) throws IllegalArgumentException, NullPointerException{
        
         if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
         
        if( DiaDaSemana<0 || DiaDaSemana>5){
            throw new IllegalArgumentException("O período de aulas está compreendido entre Segunda-feira e Sexta-feira");}
        this.DiaDaSemana = DiaDaSemana;
    }

    public Entity getProfessor() {
        return prof;
    }

    public void setProfessor(Entity prof) throws IllegalArgumentException, NullPointerException{
        
        if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(Professor.getProfessorFromID(prof).getID()!=0){
            this.prof=prof;
        }
        else{
            throw new IllegalArgumentException("Professor ID -" + prof + "- não foi encontrado.");
        }
    }

    public Entity getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Entity disciplina) throws IllegalArgumentException, NullPointerException {
        
         if(this.getID()==0) throw new NullPointerException("Objeto já foi removida.");
        
        if(Disciplina.getDisciplinaFromID(disciplina).getID()!=0){
        this.disciplina = disciplina;
        }
        else{
            throw new IllegalArgumentException("Disciplina ID -" + disciplina + "- não foi encontrado.");
        }
    }

    public Entity getTurma() {
        return turma;
    }

    public void setTurma(Entity turma)throws IllegalArgumentException, NullPointerException{
        
         if(this.getID()==0) throw new NullPointerException("Objeto já foi removido.");
        
        if(Turma.getTurmaFromID(turma).getID()!=0){
        this.turma = turma;
        }
        else{
            throw new IllegalArgumentException("Turma ID -" + turma + "- não foi encontrado.");
        }
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public String fullDescription(){
		return toString() +": " + " Dia da Semana: " + ConversorDiaDaSemana.get(DiaDaSemana) + " às " + ConversorHoras.get(hora) + " dada por Professor "+ Professor.getProfessorFromID(prof) + " de Turma " + turma + " na sala: " + sala ;
	}

    @Override
    public boolean equals(Object obj){
        if(obj != null && obj.getClass()==getClass()){
            Aula nObj = (Aula) obj;
            
            return super.equals(nObj)
                    && hora == nObj.hora
                    && prof == nObj.prof
                    && disciplina == nObj.disciplina
                    && turma == nObj.turma
                    && sala == nObj.sala; 
            }
            return false; 
    }
    
    @Override 
    public Object clone(){
        return new Aula(this);
    }

    @Override
    public String toString() {
        return getCodeID()+": " + disciplina;
        //return ""+getCodeID()+": " + disciplina + " " + ConversorDiaDaSemana.get(DiaDaSemana) + " às " + ConversorHoras.get(hora) + " dadao por "+ Professor.getProfessorFromID(prof) + " na sala: " + sala;
        //return " -"+getCodeID()+"- " + " Dia da Semana: " + ConversorDiaDaSemana.get(DiaDaSemana) + " Hora [" + ConversorHoras.get(hora) + "] Professor: "+ Professor.getProfessorFromID(prof) + " Disciplina: " + disciplina + " Turma: " + turma + " Sala: " + sala ;
    }
    
}
