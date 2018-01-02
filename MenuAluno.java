import myinput.Ler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MenuAluno {
	public static void MainMenu() {
		int valorIntroduzido = 0;
		while (valorIntroduzido != Menus.MenuExitOp) {
			Menus.printMenu("Aluno", "Alunos");
			valorIntroduzido = Ler.processarTecladoInt();

			if (valorIntroduzido == 0)/*mostrar todos os alunos*/ {
				Menus.printTodosAlunos();
			} else if (valorIntroduzido == 1)/*Criar Aluno*/ {
				criarAluno();
			} else if (valorIntroduzido == 2)/*Eliminar Aluno*/ {
				eliminarAluno();
			} else if (valorIntroduzido == 3)/*selecionar aluno*/ {
				selecionarAluno();
			} else if (valorIntroduzido == 4)/*limpar todos os alunos*/{
				eliminarTodosAluno();
			} else if(valorIntroduzido != 5)/*nenhuma da opções*/
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");
			// 5 = menuExitOp
		}
	}

	public static void criarAluno() {
		Aluno nAluno = Aluno.getAlunoFromID(Aluno.Create());

		System.out.println("A criar aluno " + (Entity) nAluno + ".");

		// set nome
		String nome = "";
		while (nome.equals("")) {
			System.out.println("Digite o primeiro nome do Aluno: ");
			nome = Ler.processarTecladoString();
		}
		nAluno.setPrimeiroNome(nome);
		nome = "";
		while (nome.equals("")) {
			System.out.println("Digite o ultimo nome do Aluno: ");
			nome = Ler.processarTecladoString();
		}
		nAluno.setUltimoNome(nome);

		// set nascimento
		int year = 0;
		int month = 0;
		int day = 0;
		while (year == 0) {
			System.out.println("Digite o ano em que o Aluno nasceu: ");
			year = Ler.processarTecladoInt();

			if (!(year <= ZonedDateTime.now().getYear() && year >= 0)) {
				System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getYear());
				year = 0;
			}
		}
		while (month == 0) {
			System.out.println("Digite o mes em que o Aluno nasceu: ");
			month = Ler.processarTecladoInt();

			if (!(month <= 12 && month >= 0)) {
				System.out.println("Mes tem que ser entre 1 e 12");
				month = 0;
			}
		}
		while (day == 0) {
			System.out.println("Digite o dia em que o Aluno nasceu: ");
			day = Ler.processarTecladoInt();

			//try to get max day of month in given year
			if (!(day <= 31 && day >= 0)) {
				System.out.println("Dia tem que ser entre 1 e 31");
				day = 0;
			}
		}
		// ver se este zone id está certo
		nAluno.setNascimento(ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));

		System.out.println("Aluno \"" + nAluno + "\" criado com sucesso.");


	}
	public static void eliminarAluno() {
		long alunoID = 0;
		Entity alunoE = Entity.Zero;
                while (
                        alunoE.getID() == 0 && 
                        Aluno.size() != 0) {
			System.out.println("Digite o ID do Aluno que quer eliminar(0 para mostrar todos os Alunos, -1 para cancelar): ");
			alunoID = Ler.processarTecladoLong();
			alunoE = Aluno.getAlunoFromID(alunoID);
                        System.out.println(alunoE);

			if (alunoID == 0)
				Menus.printTodosAlunos();
                        else if (alunoE.getID() == 0)
				System.out.println("Aluno \"" + alunoID + "\" não existe.");
			if (alunoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if (Aluno.size() == 0)
			System.out.println("Ainda não existem Alunos.");
                else if (alunoID != -1) {
			try {
				Aluno.Remove(alunoE);
				System.out.println("Aluno \"" + alunoID + " removido com sucesso.");
			} catch (IllegalArgumentException | NullPointerException e) {
				System.out.println("Erro ao remover o aluno: ");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarAluno() {
		long alunoID = 0;
		Aluno aluno = Aluno.getAlunoFromID(Entity.Zero);
		while (aluno.getID() == 0 && aluno.size() != 0) {
			System.out.println("Digite o ID do aluno(0 para mostrar todos os Alunos, -1 para cancelar): ");
			alunoID = Ler.processarTecladoLong();
			aluno = Aluno.getAlunoFromID(alunoID);

			if (alunoID == 0)
				Menus.printTodosAlunos();
			else if (aluno.getID() == 0)
				System.out.println("Aluno  \"" + alunoID + "\" não existe.");
			if (alunoID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}
		}
		if (Aluno.size() == 0)
			System.out.println("Ainda não existem Alunos.");
		else if (alunoID != -1) {
			int valorIntroduzido = -1;

			while (valorIntroduzido != 9) {
				System.out.println("Aluno " + aluno);
				System.out.println("1- Mostrar horario");
				System.out.println("2- Mostrar horario");
				System.out.println("3- Mudar Nome");
				System.out.println("4- Mudar Nascimento");
				System.out.println("5- Mudar Ano");
				System.out.println("6- Mudar Turma");
				System.out.println("7- Mudar Curso");
				System.out.println("8- Mudar para " + (aluno.getActive() ? "in" : "") + "activo");
				System.out.println("9- Voltar");

				valorIntroduzido = Ler.processarTecladoInt();

				if (valorIntroduzido == 1){
					Turma turma = Turma.getTurmaFromID(aluno.getTurma());
					long aulaID = 0;
					Aula aulaE = Aula.getAulaFromID(Entity.Zero);
					while(aulaE.getID() == 0 && turma.getAulas().size() != 0){
						System.out.println("Digite o ID da Aula(0 para mostrar todas as aulas, -1 para cancelar): ");
						aulaID = Ler.processarTecladoLong();
						aulaE = Aula.getAulaFromID(aulaID);

						if(aulaID == 0)
							Menus.printTodosCursos();
						else if(aulaID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if(aulaE.getID() == 0 || !turma.getAulas().contains(aulaE)) {
							System.out.println("Aula \""+aulaID+"\" não existe ou não faz parte da turma do aluno.");
						}

					}
					if(turma.getAulas().size() == 0)
						System.out.println("Ainda não existem Aulas.");
					else if(aulaID != -1){
						System.out.println(Aula.getAulaFromID(aulaE).fullDescription());
					}
				}
				else if (valorIntroduzido == 2) /*Mostrar horario*/{
					MenuTurma.mostrarHorario(Turma.getTurmaFromID(aluno.getTurma()));
				}
				else if (valorIntroduzido == 3)/*Mudar nome*/ {
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
					else
						System.out.println("Nome do Aluno foi alterado com sucesso.");

					aluno.setUltimoNome(nome);

				}
				else if (valorIntroduzido == 4)/*Mudar nascimento*/ {
					int year = 0;
					int month = 0;
					int day = 0;
					while (year == 0) {
						System.out.println("Digite o ano em que o Aluno nasceu (0 para cancelar): ");
						year = Ler.processarTecladoInt();

						if (year == 0) {
							System.out.println("Operação cancelada.");
						} else if (!(year <= ZonedDateTime.now().getYear() && year > 0)) {
							System.out.println("Ano tem que ser entre 1 e " + ZonedDateTime.now().getYear());
							year = 0;
						}
					}
					while (month == 0 && year != 0) {
						System.out.println("Digite o mes em que o Aluno nasceu (0 para cancelar): ");
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
						aluno.setNascimento(ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("Europe/Lisbon")));
						System.out.println("Nascimento alterado com sucesso.");
					}

				}
				else if (valorIntroduzido == 5)/*Mudar ano*/ {
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
				else if (valorIntroduzido == 6)/*mudar turma*/ {
					long turmaID = 0;
					Turma turmaE = Turma.getTurmaFromID(Entity.Zero);
					while (turmaE.getID() == 0 && Turma.size() != 0) {
						System.out.println("Digite o ID do Curso(0 para mostrar todos os cursos, -1 para cancelar): ");
						turmaID = Ler.processarTecladoLong();
						turmaE = Turma.getTurmaFromID(turmaID);

						if (turmaID == 0)
							Menus.printTodosCursos();
                                                else if (turmaID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if (turmaE.getID() == 0) {
							System.out.println("Turma \"" + turmaID + "\" não existe.");
						}

					}
					if (Turma.size() == 0)
						System.out.println("Ainda não existem turmas.");
                                        else if (turmaID != -1) {
						try {
							aluno.setTurma(turmaE);
							System.out.println("Curso definido como \"" + turmaE +"\".");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
				else if (valorIntroduzido == 7)/*Mudar curso*/ {
					long cursoID = 0;
					Curso cursoE = Curso.getCursoFromID(Entity.Zero);
					while (cursoE.getID() == 0 && Curso.size() != 0) {
						System.out.println("Digite o ID do Curso(0 para mostrar todos os cursos, -1 para cancelar): ");
						cursoID = Ler.processarTecladoLong();
						cursoE = Curso.getCursoFromID(cursoID);

						if (cursoID == 0)
							Menus.printTodosCursos();
                                                else if (cursoID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if (cursoE.getID() == 0) {
							System.out.println("Curso \"" + cursoID + "\" não existe.");
						}

					}
					if (Curso.size() == 0)
						System.out.println("Ainda não existem cursos.");
                                        else if (cursoID != -1) {
						try {
							aluno.setCurso(cursoE);
							System.out.println("Curso definido como \"" + cursoE +"\".");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
				else if (valorIntroduzido == 8) /*mudar active*/ {
					aluno.setActive(aluno.getActive());
				}
				else if (valorIntroduzido != 9)
					System.out.println("Introduza um numero entre 1 e 7.");
			}
		}
	}
	public static void eliminarTodosAluno() {
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
			System.out.println("A limpar todos os alunos.");

			String alunome;
			for (Aluno _aluno : Aluno.getAlunos().values()) {
				if (_aluno.getID() != 0) {
					try {
						alunome = _aluno.toString();
						Aluno.Remove(_aluno);
						System.out.println("Aluno \"" + alunome+ "\" removido com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
