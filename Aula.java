import java.util.ArrayList;
import java.util.Date;
import javafx.scene.input.DataFormat;
import java.util.Map;
import java.util.HashMap;

public class Aula extends Entity {
    // -- beginning of static fields
    // -- vars
    private static final Map<String, Aula> aulas = new HashMap<String, Aula>();
    private static long IDCount = 0;
    private static ArrayList<String> ConversorHoras;
    private static ArrayList<String> ConversorDiaDaSemana;
    
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
        return aulas.get(Entity.getGroupIDFromGroup("Aula") + ID );
    }
    
    public static boolean addAula(Aula x){
        if(getAulaFromID(x.getID())!=null){
            System.out.println("Aula existente");
            return false;
        }
        aulas.put(x.getCodeID(), x);
        return true;
    }
   
    public static long Create(int hora, long prof, long disciplina, long turma, String sala){
        Aula nAula = new Aula(hora, prof, disciplina, turma, sala);
        addAula(nAula);
        return nAula.getID();
    }
    
    // -- beginning of non static fields
    // -- vars
    private int hora;
    private int DiaDaSemana;
    private long prof;
    private long disciplina;
    private long turma;
    private String sala;
    
     // -- constructors
    public Aula(int hora, long prof, long disciplina, long turma, String sala){
        super("Aula", IDCount++);
        this.hora=hora;
        this.prof=prof;
        this.disciplina=disciplina;
        this.turma=turma;
        this.sala=sala;
    }
    
    public Aula(Aula aula){
        super("Aula", aula.getID());
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

    public void setHora(int hora) throws IllegalArgumentException {
            if( hora<0 || hora>5){
                System.out.println("O horário de funcionamento é entre as 8 e as 18 horas");
                throw new IllegalArgumentException();}
        this.hora = hora;
    }
    
    public int getDiaDaSemana(){
        return DiaDaSemana;
    }
    
    public void setDiaDaSemana(int DiaDaSemana){
        if( DiaDaSemana<0 || DiaDaSemana>5){
            System.out.println("O período de aulas está compreendido entre Segunda-feira e Sexta-feira");
            throw new IllegalArgumentException();}
        this.DiaDaSemana = DiaDaSemana;
    }

    public long getProfessor() {
        return prof;
    }

    public void setProfessor(long prof) throws IllegalArgumentException {
        if(Professor.getProfessorFromID(prof)!=null){
            this.prof=prof;
        }
        else{
            System.out.println("Professor ID \"" + prof + "\"não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

    public long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(long disciplina) throws IllegalArgumentException {
        if(Disciplina.getDisciplinaFromID(disciplina)!=null){
        this.disciplina = disciplina;
        }
        else{
            System.out.println("Disciplina ID \"" + disciplina + "\" não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

    public long getTurma() {
        return turma;
    }

    public void setTurma(long turma)throws IllegalArgumentException {
        if(Turma.getTurmaFromID(turma)!=null){
        this.turma = turma;
        }
        else{
            System.out.println("Turma ID \"" + turma + "\" não foi encontrado.");
            throw new IllegalArgumentException();
        }
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    @Override
    public boolean equals(Object obj){
        if(obj != null && obj.getClass()==getClass()){
            Aula nObj = (Aula) obj;
            
            return super.equals(obj) 
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
        return getCodeID() + " Hora [" + hora + "] " + " Professor: "+ prof + " Disciplina: " + disciplina + " Turma: " + turma + " Sala: " + sala ;
    }
    
}
