import java.time.ZonedDateTime;

public class Projeto {

    public static void main(String[] args) {
        Entity eu = Aluno.Create("Luis","Pais", ZonedDateTime.now());
		System.out.println(eu);
	}
    
}
