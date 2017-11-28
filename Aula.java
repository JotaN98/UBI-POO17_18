import java.util.ArrayList;
import java.util.Date;
import javafx.scene.input.DataFormat;
import java.util.Map;
import java.util.HashMap;

public class Aula {
    private Disciplina disciplina;
    private Date data;
    private ArrayList<Aluno> aluno;
    private Date horario;
    
   
    private static final Map<String, Aula> Aulas = new HashMap<String, Aula>();

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Date getData() {
        return data;
    }

    public ArrayList<Aluno> getAluno() {
        return aluno;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setAluno(ArrayList<Aluno> aluno) {
        this.aluno = aluno;
    }

    public static Map<String, Aula> getAulas() {
        return Aulas;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }
    

    
    public String toString() {
        return "Aula{" + "disciplina=" + disciplina + ", data=" + data + ", aluno=" + aluno + '}';
    }
    
    public static boolean existeAula(Aula x){
        for(int i=0;i<Aulas.size();i++){
            if(x.equals(Aulas.get(i)))
                return true;
        }
        return false;
    }
    // NAO FIZ MAIS PORQUE NAO SEI COMO FAZER POR CAUSA DO HORARIO !
    public static boolean addAula(Aula x,Date horarioNovo){
        if(existeAula(x)){
            if(x.getHorario().equals(horarioNovo)){
                System.out.println("Essa aula já existe nesse horário");
                return false;
            }
        }
        Aulas.put(x.getHorario(), x); // ????
        System.out.println("Aula reposta");
        return true;
    }
}
