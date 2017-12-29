import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class MenuProfessor {
	public static void MainMenu() {
		int valorIntroduzido = 0;
		while (valorIntroduzido != Menus.MenuExitOp) {
			Menus.printMenu("Professor", "Professores");
			valorIntroduzido = Ler.processarTecladoInt();

			if (valorIntroduzido == 0)/*mostrar todos os professors*/ {
				Menus.printTodosProfessores();
			} else if (valorIntroduzido == 1)/*Criar Professor*/ {
				criarProfessor();
			} else if (valorIntroduzido == 2)/*Eliminar Professor*/ {
				eliminarProfessor();
			} else if (valorIntroduzido == 3)/*selecionar aluno*/ {
				selecionarProfessor();
			} else if (valorIntroduzido == 4)/*limpar todos os alunos*/{
				eliminarTodosProfessor();
			} else if(valorIntroduzido != 5)/*nenhuma da opções*/
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");
			// 5 = menuExitOp
		}
	}

	public static void criarProfessor() {
		Professor nProfessor = Professor.getProfessorFromID(Professor.Create());

		System.out.println("A criar professor " + (Entity) nProfessor + ".");

		// set nome
		String nome = "";
		while (nome.equals("")) {
			System.out.println("Digite o primeiro nome do Professor: ");
			nome = Ler.processarTecladoString();
		}
		nProfessor.setPrimeiroNome(nome);
		nome = "";
		while (nome.equals("")) {
			System.out.println("Digite o ultimo nome do Professor: ");
			nome = Ler.processarTecladoString();
		}
		nProfessor.setUltimoNome(nome);

		// set nascimento
		int year = 0;
		int month = 0;
		int day = 0;
		while (year == 0) {
			System.out.println("Digite o ano em que o Professor nasceu: ");
			year = Ler.processarTecladoInt();

			if (!(year <= ZonedDateTime.now().getYear() && year >= 0)) {
				System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getYear());
				year = 0;
			}
		}
		while (month == 0) {
			System.out.println("Digite o mês em que o Professor nasceu: ");
			month = Ler.processarTecladoInt();

			if (!(month <= 12 && month >= 0)) {
				System.out.println("Mes tem que ser entre 1 e 12");
				month = 0;
			}
		}
		while (day == 0) {
			System.out.println("Digite o dia em que o Professor nasceu: ");
			day = Ler.processarTecladoInt();

			//try to get max day of month in given year
			if (!(day <= 31 && day >= 0)) {
				System.out.println("Dia tem que ser entre 1 e 31");
				day = 0;
			}
		}
		// ver se este zone id está certo
		nProfessor.setNascimento(ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));

		System.out.println("Professor \"" + nProfessor + "\" criado com sucesso.");


	}
	public static void eliminarProfessor() {
		long professorID = 0;
		Entity professorE = Entity.Zero;
		while (professorE.getID() == 0 && Professor.size() != 0) {
			System.out.println("Digite o ID do Professor que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
			professorID = Ler.processarTecladoLong();
			professorE = Professor.getProfessorFromID(professorID);

			if (professorID == 0)
				Menus.printTodosProfessores();
                        if (professorID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}
                        else if (professorE.getID() == 0)
				System.out.println("Professor \"" + professorID + "\" não existe.");
			
		}
		if (Professor.size() == 0)
			System.out.println("Ainda não existem Professores.");
		if (professorID != -1) {
			try {
				Professor.Remove(professorE);
				System.out.println("Professor \"" + professorID + " removido com sucesso.");
			} catch (IllegalArgumentException | NullPointerException e) {
				System.out.println("Erro ao remover o Professor: ");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarProfessor() {
		long profID = 0;
		Professor professor = Professor.getProfessorFromID(Entity.Zero);
		while(professor.getID() == 0 && Professor.size() != 0) {
			System.out.println("Digite o ID do Professor(0 para mostrar todos os Professores, -1 para cancelar): ");
			profID = Ler.processarTecladoLong();
			professor = Professor.getProfessorFromID(profID);

			if (profID == 0)
				Menus.printTodosProfessores();
                        if (profID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}
                        else if (professor.getID() == 0)
				System.out.println("Professor  \"" + profID + "\" não existe.");
		}
		if (Professor.size() == 0)
			System.out.println("Ainda não existem Professores.");

		else if (profID != -1) {
			int valorIntroduzido = -1;

			while (valorIntroduzido != 4) {
				System.out.println("Professor " + professor);
				System.out.println("1- Mostrar horario");
				System.out.println("2- Criar teste");
				System.out.println("3- Eliminar teste");
				System.out.println("4- Voltar");


				valorIntroduzido = Ler.processarTecladoInt();

				if(valorIntroduzido == 1)/*mostrar horario*/{
					mostrarHorario(professor);
				}
				else if(valorIntroduzido == 2){

					long aulID = 0;
					Entity aulE = Entity.Zero;
					while(aulE.getID() == 0 && professor.getAulas().size()!=0) {
						System.out.println("Digite a aula:(0 para mostrar o horario, -1 para cancelar(");

						aulID = Ler.processarTecladoLong();
						aulE = Aula.getAulaFromID(aulID);

						if (aulID == 0)
							mostrarHorario(professor);
						if (aulID== -1) {
							System.out.println("Operação cancelada.");
							break;
						}
                                                else if (aulE.getID() == 0)
							System.out.println("Aula \"" + aulE+ "\" não existe.");
					}
					if(professor.getAulas().size() == 0)
						System.out.println("Professor ainda não tem aulas.");
					else if(aulID != -1){
						int year = 0;
						int month = 0;
						int day = 0;
						while (year == 0) {
							System.out.println("Digite o ano para o teste(-1 para cancelar): ");
							year = Ler.processarTecladoInt();

							if(year == -1){
								System.out.println("Operação cancelada.");
								break;
							}
							if (!(year <= ZonedDateTime.now().getYear() && year >= 0)) {
								System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getYear());
								year = 0;
							}
						}
						while (month == 0 && year != -1) {
							System.out.println("Digite o mes para o teste(-1 para cancelar): ");
							month = Ler.processarTecladoInt();

							if(month == -1){
								System.out.println("Operação cancelada.");
								break;
							}
							if (!(month <= 12 && month >= 0)) {
								System.out.println("Mes tem que ser entre 1 e 12");
								month = 0;
							}
						}
						while (day == 0 && month != -1 && year != -1) {
							System.out.println("Digite o dia para o teste: ");
							day = Ler.processarTecladoInt();

							if(day == -1){
								System.out.println("Operação cancelada");
								break;
							}
							if (!(day <= 31 && day >= 0)) {
								System.out.println("Dia tem que ser entre 1 e 31");
								day = 0;
							}
						}
						if(day != -1){
							System.out.println("Teste "+Teste.getTesteFromID(Teste.Create(aulE,ZonedDateTime.of(ZonedDateTime.now().getDayOfYear(),month,day,0,0,0,0,ZoneId.of("Europe/Lisbon"))))+" criado com sucesso");
						}
					}

				}
				else if(valorIntroduzido == 3){
					long testeID = 0;
					Entity testeE = Entity.Zero;
					while (testeE.getID() == 0 && Teste.size() != 0) {
						System.out.println("Digite o ID do Teste que quer eliminar(0 para mostrar todos os Cursos, -1 para cancelar): ");
						testeID = Ler.processarTecladoLong();
						testeE = Teste.getTesteFromID(testeID);

						if (testeID == 0)
							Menus.printTodosTestes();
                                                if (testeID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
                                                else if (testeE.getID() == 0)
							System.out.println("Teste \"" + testeID + "\" não existe.");
					}
					if (Teste.size() == 0)
						System.out.println("Ainda não existem Testes.");
					if (testeID != -1) {
						try {
							Teste.Remove(testeE);
							System.out.println("Teste \"" + testeID + " removido com sucesso.");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Erro ao remover o Professor: ");
							System.out.println(e.getMessage());
						}
					}
				}
				else if (valorIntroduzido != 4)
					System.out.println("Introduza um numero entre 1 e 4.");
			}
		}
	}
	public static void eliminarTodosProfessor() {
		String remover = "";

		while (!remover.equalsIgnoreCase("n") && !remover.equalsIgnoreCase("nao") &&
				!remover.equalsIgnoreCase("s") && !remover.equalsIgnoreCase("sim")) {
			System.out.println("Tem a certeza que quer eliminar todos os alunos ?");
			System.out.print("[s/n]: ");

			remover = Ler.processarTecladoString();
		}
		if (remover.toLowerCase().equals("n") || remover.toLowerCase().equals("nao"))
			return;
		else if (remover.equalsIgnoreCase("s") || remover.equalsIgnoreCase("sim")) {
			System.out.println("A limpar todos os professores.");

			String prome;
			for (Professor _professor : Professor.getProfessores().values()) {
				if (_professor.getID() != 0) {
					try {
						prome = _professor.toString();
						Professor.Remove(_professor);
						System.out.println("Professor \"" + prome+ "\" removido com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}

	public static void mostrarHorario(Professor professor){
		ArrayList<ArrayList<Entity>> horario = professor.getHorario();

		for(String dia : Aula.ConversorDiaDaSemana){
			System.out.print("|\t\t " + dia + " \t\t");
		}
		System.out.println("|");

		Aula aula;
		for(int hora = 0; hora < Aula.ConversorHoras.size(); hora++){
			for(int diaDaSemana = 0; diaDaSemana < Aula.ConversorDiaDaSemana.size(); diaDaSemana++) {
				aula = Aula.getAulaFromID( horario.get(diaDaSemana).get(hora) );

				System.out.print("|\t");
				if(aula.getID() == 0)
					System.out.print("\t   (vazio)   \t");
				else
					System.out.print(aula);
				System.out.print("\t");
			}
			System.out.println("|");
		}
	}
}
