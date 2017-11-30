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
   
    public static long Create(int hora[], long prof, long disciplina, long turma, String sala){
        Aula nAula = new Aula(hora[], prof, disciplina, turma, sala);
        addAula(nAula);
        return nAula.getID();
    }
    
    // -- beginning of non static fields
    // -- vars
    private int hora[];
    private long prof;
    private long disciplina;
    private long turma;
    private String sala;
    
     // -- constructors
    public Aula(int hora[], long prof, long disciplina, long turma, String sala){
        super("Aula", IDCount++);
        this.hora=hora;
        this.prof=prof;
        this.disciplina=disciplina;
        this.turma=turma;
        this.sala=sala;
    }
    
    // -- methods
    public int[] getHora() {
        return hora;
    }

    public void setHora(int[] hora) throws IllegalArgumentException {
        for(int i=0; i<=hora.length; i++){
            if(hora[i]<8 || hora[i]>18){
                System.out.println("As aulas têm de estar compreendidas entre as 8 e as 18 horas");
                throw new IllegalArgumentException();}
        }
        this.hora = hora;
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
        return new Aula(getHora(), getProfessor(), getDisciplina(), getTurma(), getSala());
    }
    
    @Override
    public String toString() {
        return getCodeID() + " Hora [" + hora + "] " + " Professor: "+ prof + " Disciplina: " + disciplina + " Turma: " + turma + " Sala: " + sala ;
    }
    
}
