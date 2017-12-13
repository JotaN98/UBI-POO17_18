import javafx.scene.shape.Circle;
import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class MenuAluno {
	public static void MainMenu(){
		int valorIntroduzido = 0;
		while (valorIntroduzido != Menus.MenuExitOp){
			Menus.printMenu("Aluno","Alunos");
			valorIntroduzido = Ler.processarTecladoInt();

			if(valorIntroduzido == 0)/*mostrar todos os cursos*/ {
				Menus.printTodosAlunos();
			}
			else if(valorIntroduzido == 1)/*Criar Aluno*/{
				criarAluno();
			}
			else if(valorIntroduzido == 2)/*Eliminar Aluno*/{
				eliminarAluno();
			}
			else if(valorIntroduzido == 3)/*selecionar aluno*/{
				selecionarAluno()
			}
		}
	}

	public static void criarAluno(){
		Aluno nAluno = Aluno.getAlunoFromID(Aluno.Create());

		System.out.println("A criar aluno "+ (Entity)nAluno +".");

		// set nome
		String nome = "";
		while(nome.equals("")){
			System.out.println("Digite o primeiro nome do Aluno: ");
			nome = Ler.processarTecladoString();
		}
		nAluno.setPrimeiroNome(nome);
		nome = "";
		while(nome.equals("")){
			System.out.println("Digite o ultimo nome do Aluno: ");
			nome = Ler.processarTecladoString();
		}
		nAluno.setUltimoNome(nome);

		// set nascimento
		int year = 0;
		int month = 0;
		int day = 0;
		while (year == 0){
			System.out.println("Digite o ano em que o Aluno nasceu: ");
			year = Ler.processarTecladoInt();

			if(!(year <= ZonedDateTime.now().getDayOfYear() && year >= 0)) {
				System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getDayOfYear());
				year = 0;
			}
		}
		while (month == 0){
			System.out.println("Digite o ano em que o Aluno nasceu: ");
			month = Ler.processarTecladoInt();

			if(!(month <= 12 && month >= 0)) {
				System.out.println("Mes tem que ser entre 1 e 12");
				month = 0;
			}
		}
		while (day == 0){
			System.out.println("Digite o dia em que o Aluno nasceu: ");
			day = Ler.processarTecladoInt();

			//try to get max day of month in given year
			if(!(day <= 31 && day >= 0)) {
				System.out.println("Mes tem que ser entre 1 e 12");
				day = 0;
			}
		}
		// ver se este zone id está certo
		nAluno.setNascimento(ZonedDateTime.of(year,month,day,0,0,0,0, ZoneId.of("Eur/Lisbon")));

		System.out.println("Aluno \""+ nAluno +"\" criado com sucesso.");


	}
	public static void eliminarAluno(){
		long alunoID = 0;
		Entity alunoE = Entity.Zero;
		while(alunoE.getID() == 0 && Aluno.size() != 0){
			System.out.println("Digite o ID do Aluno que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
			alunoID = Ler.processarTecladoLong();
			alunoE = Aluno.getAlunoFromID(alunoID);

			if(alunoID == 0)
				Menus.printTodosAlunos();
			if(alunoE.getID() == 0)
				System.out.println("Aluno \""+alunoID+"\" não existe.");
			if(alunoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if(Aluno.size() == 0)
			System.out.println("Ainda não existem Alunos.");
		if(alunoID != -1){
			try {
				Aluno.Remove(alunoE);
				System.out.println("Aluno \""+alunoID+" removido com sucesso.");
			} catch (IllegalArgumentException | NullPointerException e){
				System.out.println("Erro ao remover o curso: ");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarAluno(){
		long alunoID = 0;
		Aluno aluno = Aluno.getAlunoFromID(Entity.Zero);
		while(aluno.getID() == 0 && Curso.size() != 0){
			System.out.println("Digite o ID do curso que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
			alunoID = Ler.processarTecladoLong();
			aluno = Aluno.getAlunoFromID(alunoID);

			if(alunoID == 0)
				Menus.printTodosAlunos();
			if(aluno.getID() == 0)
				System.out.println("Aluno  \""+alunoID+"\" não existe.");
			if(alunoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if(Aluno.size() == 0)
			System.out.println("Ainda não existem Alunos.");
		if(alunoID != -1){
			int valorIntroduzido = -1;

			while (valorIntroduzido != 7) {
				System.out.println("Aluno " + aluno);
				System.out.println("1- Mudar Nome");
				System.out.println("2- Mudar Nascimento");
				System.out.println("3- Mudar Ano");
				System.out.println("4- Mudar Turma");
				System.out.println("5- Mudar Curso");
				System.out.println("6- Mudar para " + (aluno.getActive() ? "in" : "") + "activo");
				System.out.println("7- Voltar");

				valorIntroduzido = Ler.processarTecladoInt();

				if (valorIntroduzido == 1)/*Mudar nome*/ {
					String nome = "";
					System.out.println("Digite o primeiro nome do Aluno: ");
					nome = Ler.processarTecladoString();

					if (nome.equalsIgnoreCase(""))
						nome = aluno.getPrimeiroNome();

					aluno.setPrimeiroNome(nome);

					nome = "";
					System.out.println("Digite o ultimo nome do Aluno: ");
					nome = Ler.processarTecladoString();

					if (nome.equalsIgnoreCase(""))
						nome = aluno.getUltimoNome();

					aluno.setUltimoNome(nome);

					System.out.println("Nome do Aluno foi alterado com sucesso.");
				}
				else if (valorIntroduzido == 2)/*Mudar nascimento*/ {
					int year = 0;
					int month = 0;
					int day = 0;
					while (year == 0) {
						System.out.println("Digite o ano em que o Aluno nasceu (0 para cancelar): ");
						year = Ler.processarTecladoInt();

						if (year == 0) {
							System.out.println("Operação cancelada.");
						} else if (!(year <= ZonedDateTime.now().getDayOfYear() && year > 0)) {
							System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getDayOfYear());
							year = 0;
						}
					}
					while (month == 0 && year != 0) {
						System.out.println("Digite o ano em que o Aluno nasceu (0 para cancelar): ");
						month = Ler.processarTecladoInt();

						if (month == 0) {
							System.out.println("Operação cancelada.");
						} else if (!(month <= 12 && month > 0)) {
							System.out.println("Mes tem que ser entre 1 e 12");
							month = 0;
						}
					}
					while (day == 0 && month != 0 && year != 0) {
						System.out.println("Digite o dia em que o Aluno nasceu (0 para cancelar): ");
						day = Ler.processarTecladoInt();

						//try to get max day of month in given year
						if (day == 0) {
							System.out.println("Operação cancelada.");
						} else if (!(day <= 31 && day > 0)) {
							System.out.println("Mes tem que ser entre 1 e 12");
							day = 0;
						}
					}
					// ver se este zone id está certo
					if (!(day == 0 || month == 0 || year == 0)) {
						aluno.setNascimento(ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("Eur/Lisbon")));
						System.out.println("Nascimento alterado com sucesso.");
					}

				}
				else if (valorIntroduzido == 3)/*Mudar ano*/ {
					int ano = 0;
					while (ano < 10 || ano > 12) {
						System.out.println("Insira o ano do aluno (-1 para cancelar): ");

						ano = Ler.processarTecladoInt();

						if (ano == -1) {
							System.out.println("Operação cancelada");
							break;
						} else if (ano < 10 || ano > 12)
							System.out.println("Insira um ano entre 10 e 12");
					}
					if (!(ano < 10 || ano > 12)) {
						try {
							aluno.setAno(ano);
							System.out.println("Ano alterado com sucesso.");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}
					}
				}
				else if (valorIntroduzido == 4)/*mudar curso*/ {
					long turmaID = 0;
					Turma turmaE = Turma.getTurmaFromID(Entity.Zero);
					while(turmaE.getID() == 0 && Turma.size() != 0){
						System.out.println("Digite o ID do Curso(0 para mostrar todos os cursos, -1 para cancelar): ");
						turmaID = Ler.processarTecladoLong();
						turmaE = Turma.getTurmaFromID(turmaID);

						if(turmaID == 0)
							Menus.printTodosCursos();
						if(turmaE.getID() == 0)
							System.out.println("Turma \""+turmaID+"\" não existe.");
						if(turmaID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}

					}
					if(Curso.size() == 0)
						System.out.println("Ainda não existem cursos.");
					if(turmaID != -1) {
						try {
							aluno.setCurso(turmaE);
							System.out.println("Curso definido como \"" + turmaE);
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
				else if (valorIntroduzido == 5)/*Mudar turma*/ {
					long cursoID = 0;
					Curso cursoE = Curso.getCursoFromID(Entity.Zero);
					while (cursoE.getID() == 0 && Curso.size() != 0) {
						System.out.println("Digite o ID do Curso(0 para mostrar todos os cursos, -1 para cancelar): ");
						cursoID = Ler.processarTecladoLong();
						cursoE = Curso.getCursoFromID(cursoID);

						if (cursoID == 0)
							Menus.printTodosCursos();
						if (cursoE.getID() == 0)
							System.out.println("Curso \"" + cursoID + "\" não existe.");
						if (cursoID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}

					}
					if (Curso.size() == 0)
						System.out.println("Ainda não existem cursos.");
					if (cursoID != -1) {
						try {
							aluno.setCurso(cursoE);
							System.out.println("Curso definido como \"" + cursoE);
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
			}




			}
