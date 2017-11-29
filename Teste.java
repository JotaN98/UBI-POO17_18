import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Teste extends Entity{
	
    private static Map<String, Teste> testes = new HashMap<String, Teste>();
    private Disciplina disciplina;
    private ZonedDateTime data; 
    private String anoLetivo;
    private Map<String /*Aluno*/,String/*Nota*/> notas;

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public String getAnoLetivo() {
    	return anoLetivo;
	}

    public String toString() {
        return "Teste{" + "disciplina=" + disciplina + ", data=" + data + '}';
    }
    
}
