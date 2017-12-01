import projeto.Entity;
import java.time.ZonedDateTime;

public class Pessoa extends Entity {
    // -- beginning of non static fields
    private String pNome;
    private String uNome;
    private ZonedDateTime nascimento;
    private String obs;

    public Pessoa(Object subClass, long ID, String pNome,String uNome, ZonedDateTime nascimento) {
        super(subClass, ID);
        this.pNome = pNome;
        this.uNome = uNome;
        this.nascimento = nascimento;
    }

    public Pessoa(String subClass, long ID, String pNome,String uNome, ZonedDateTime nascimento) {
        super(subClass, ID);
        this.pNome = pNome;
        this.uNome = uNome;
        this.nascimento = nascimento;
    }

    public void setPrimeiroNome(String nome) {
        this.pNome = nome;
    }
    public void setUltimoNome(String nome) {
        this.uNome = nome;
    }

    public void setNascimento(ZonedDateTime nascimento) {
        this.nascimento = nascimento;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

	public String getNome() {
		return pNome + uNome;
	}
    public String getPrimeiroNome() {
        return pNome;
    }
    public String getUltimoNome() {
        return uNome;
    }

    public ZonedDateTime getNascimento() {
        return nascimento;
    }

    public String getObs() {
        return obs;
    }

    public String toString() {
        return pNome  +" "+uNome;
    }
    
}
