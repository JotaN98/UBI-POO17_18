
public class Menus {
	public static int MenuExitOp = 5;
	public static void printMenu(String singular, String plural){
		System.out.println(plural +":");
		System.out.println("0- Mostrar "+ plural);
		System.out.println("1- Criar "+ singular);
		System.out.println("2- Eliminar "+ singular);
		System.out.println("3- Selecionar "+ singular);
		System.out.println("4- Limpar todos os "+ plural);
		System.out.println("5- Voltar");
	}

	//Mostrar todos os cursos
	public static void printTodosCursos(){
		System.out.println("---");
		System.out.println("Todos os cursos");
		System.out.println("---");
		for(Curso curso : Curso.getCursos().values()){
			if(curso.getID() != 0){
				System.out.println(curso);
			}
		}
		System.out.println("---");
	}

	//Mostrar todas as turmas
	public static void printTodasTurmas(){
		System.out.println("---");
		System.out.println("Todas as Turmas");
		System.out.println("---");
		for(Turma turma : Turma.getTurmas().values()){
			if(turma.getID() != 0){
				System.out.println(turma);
			}
		}
		System.out.println("---");
	}

	//Mostrar todas as Disciplinas
	public static void printTodasDisciplinas(){
		System.out.println("---");
		System.out.println("Todas as Disciplinas");
		System.out.println("---");
		//Fazer isto
		for(Disciplina disciplina : Disciplina.getDisciplinas().values()){
			if(disciplina.getID() != 0){
				System.out.println(disciplina);
			}
		}
		System.out.println("---");
	}

	//Mostrar todos os professores
	public static void printTodosProfessores(){
		System.out.println("---");
		System.out.println("Todos os Professores");
		System.out.println("---");
		for(Professor prof : Professor.getProfessores().values()){
			if(prof.getID() != 0){
				System.out.println(prof);
			}
		}
		System.out.println("---");
	}

	//Mostrar todos os alunos
	public static void printTodosAlunos(){
		System.out.println("---");
		System.out.println("Todos os Alunos");
		System.out.println("---");
		for(Aluno alu : Aluno.getAlunos().values()){
			if(alu.getID() != 0){
				System.out.println(alu);
			}
		}
		System.out.println("---");
	}

	//Mostrar todos os testes
	public static void printTodosTestes(){
		System.out.println("---");
		System.out.println("Todos os Testes");
		System.out.println("---");
		for(Teste test : Teste.getTestes().values()){
			if(test.getID() != 0){
				System.out.println(test);
			}
		}
		System.out.println("---");
	}

	//Mostrar toda as notas
	public static void printTodasNotas(){
		System.out.println("---");
		System.out.println("Todas as Notas");
		System.out.println("---");
		for(Nota not : Nota.getNotas().values()){
			if(not.getID() != 0){
				System.out.println(not);
			}
		}
		System.out.println("---");
	}

	public static int MainMenuExitOp = 6;
	public static void printMainMenu(){
		System.out.println("1- Cursos");
		System.out.println("2- Turmas");
		System.out.println("3- Disciplinas");
		System.out.println("4- Professores");
		System.out.println("5- Alunos");
		System.out.println("6- Guardar e Sair");
	}


}
