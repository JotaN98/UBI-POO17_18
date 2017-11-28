import java.util.ArrayList;
import java.util.Date;
import javafx.scene.input.DataFormat;
import java.util.Map;
import java.util.HashMap;

public class Aula {
    private Disciplina disciplina;
    private Date data;
    private ArrayList<Aluno> aluno;
    private Date CodeID;
    
    public static boolean addAula(Aula x,Date horarioNovo){
        if(existeAula(x)){
            if(x.getHorario().equals(horarioNovo)){
                System.out.println("Essa aula já existe nesse horário");
                return false;
            }
        }
        Aulas.put(x.getCodeID(), x); 
        System.out.println("Aula reposta");
        return true;
    }
    
    public static boolean existeAula(Aula x){
        for(int i=0;i<Aulas.size();i++){
            if(x.equals(Aulas.get(i)))
                return true;
        }
        return false;
    }
    
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

    public Date getCodeID() {
        return CodeID;
    }

    public void setCodeID(Date horario) {
        this.CodeID = CodeID;
    }

    public String toString() {
        return "Aula{" + "disciplina=" + disciplina + ", data=" + data + ", aluno=" + aluno + '}';
    }    
}
