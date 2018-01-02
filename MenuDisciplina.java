import myinput.Ler;


public class MenuDisciplina{
	public static void MainMenu() {
		int valorIntroduzido = 0;
		while (valorIntroduzido != Menus.MenuExitOp) {
			Menus.printMenu("Disciplina", "Disciplinas");
			valorIntroduzido = Ler.processarTecladoInt();

			if (valorIntroduzido == 0)/*mostrar todos os disciplinas*/ {
				Menus.printTodasDisciplinas();
			} else if (valorIntroduzido == 1)/*Criar disciplinas*/ {
				criarDisciplina();
			} else if (valorIntroduzido == 2)/*Eliminar disciplinas*/ {
				eliminarDisciplina();
			} else if (valorIntroduzido == 3)/*selecionar disciplina*/ {
				selecionarDisciplina();
			} else if (valorIntroduzido == 4)/*limpar todos os disciplinas*/{
				eliminarTodosDiscplina();
			} else if(valorIntroduzido != 5)/*nenhuma da opções*/
				System.out.println("Introduza um numero entre 1 e "+ (Menus.MainMenuExitOp-1) +".");
			// 5 = menuExitOp
		}
	}

	public static void criarDisciplina() {
		Disciplina nDisciplina = Disciplina.getDisciplinaFromID(Disciplina.Create());

		System.out.println("A criar Disciplina " + (Entity) nDisciplina + ".");

		// set nome
		String nome = "";
		while (nome.equals("")) {
			System.out.println("Digite o nome da disciplina: ");
			nome = Ler.processarTecladoString();
		}
		nDisciplina.setNome(nome);

		// set ano
		int ano = 0;
		while(ano == 0){
			System.out.println("Digite o ano da disciplina: ");

			ano = Ler.processarTecladoInt();

			if(ano < 10 || ano > 12){
				System.out.println("Ano tem que ser entre 10 e 12.");
				ano = 0;
			}
		}
		nDisciplina.setAno(ano);

		System.out.println("Disciplina \"" + nome+ "\" criada com sucesso.");
	}
	public static void eliminarDisciplina() {
		long discID = 0;
		Entity discE = Entity.Zero;
		while (discE.getID() == 0 && Disciplina.size() != 0) {
			System.out.println("Digite o ID da Disciplina que quer eliminar(0 para mostrar 1disciplinas, -1 para cancelar): ");
			discID = Ler.processarTecladoLong();
			discE = Aluno.getAlunoFromID(discID);

			if (discID == 0)
				Menus.printTodasDisciplinas();
                        else if (discE.getID() == 0)
				System.out.println("Disciplina \"" + discID + "\" não existe.");
			if (discID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if (Disciplina.size() == 0)
			System.out.println("Ainda não existem Disciplinas.");
                else if (discID != -1) {
			try {
				Disciplina.Remove(discE);
				System.out.println("Disciplina \"" + discID + " removida com sucesso.");
			} catch (IllegalArgumentException | NullPointerException e) {
				System.out.println("Erro ao remover o curso: ");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void selecionarDisciplina() {
		long discID = 0;
		Disciplina disc = Disciplina.getDisciplinaFromID(Entity.Zero);
		while (disc.getID() == 0 && Disciplina.size() != 0) {
			System.out.println("Digite o ID da Disciplina(0 para mostrar todos os Cursos, -1 para cancelar): ");
			discID = Ler.processarTecladoLong();
			disc = Disciplina.getDisciplinaFromID(discID);

			if (discID == 0)
				Menus.printTodasDisciplinas();
			else if (disc.getID() == 0)
				System.out.println("Disciplina  \"" + discID + "\" não existe.");
			if (discID == -1) {
				System.out.println("Operação cancelada.");
				break;
			}

		}
		if (Disciplina.size() == 0)
			System.out.println("Ainda não existem Disciplina.");
		else if (discID != -1) {
			int valorIntroduzido = -1;

			while (valorIntroduzido != 9) {
				System.out.println("Disciplina " + disc);
				System.out.println("1- Mudar Nome");
				System.out.println("2- Mudar Ano");
				System.out.println("3- Mostrar Professors");
				System.out.println("4- Inserir Professor");
				System.out.println("5- Remover Professor");
				System.out.println("6- Mostrar salas");
				System.out.println("7- Inserir sala");
				System.out.println("8- Remover sala");
				System.out.println("9- Voltar");

				valorIntroduzido = Ler.processarTecladoInt();

				if (valorIntroduzido == 1)/*Mudar nome*/ {
					String nome = "";
					System.out.println("Digite o nome da Disciplina: ");
					nome = Ler.processarTecladoString();

					if (nome.equalsIgnoreCase(""))
						nome = disc.getNome();
					else
						System.out.println("Nome do Aluno foi alterado com sucesso.");

					disc.setNome(nome);
				}
				else if (valorIntroduzido == 2)/*Mudar ano*/ {
					int ano = 0;
					while(ano == 0){
						System.out.println("Digite o ano da disciplina: ");

						ano = Ler.processarTecladoInt();

						if(ano < 10 || ano > 12){
							System.out.println("Ano tem que ser entre 10 e 12.");
							ano = 0;
						}
					}
					disc.setAno(ano);
				}
				else if (valorIntroduzido == 3)/*Mostrar Professores*/{
					System.out.println("---");
					System.out.println("Professores de " + disc);
					System.out.println("---");
					for(Entity profE : disc.getProfessores()){
						Professor prof = Professor.getProfessorFromID(profE);
						if(prof.getID() != 0){
							System.out.println(prof);
						}
					}
					System.out.println("---");
				}
				else if (valorIntroduzido == 4)/*inserir professor*/ {
					long profID = 0;
					Professor profE = Professor.getProfessorFromID(Entity.Zero);
					while (profE.getID() == 0 && Professor.size() != 0) {
						System.out.println("Digite o ID do Professor(0 para mostrar todos os professores, -1 para cancelar): ");
						profID = Ler.processarTecladoLong();
						profE = Professor.getProfessorFromID(profID);

						if (profID == 0)
							Menus.printTodosProfessores();
						else if (profE.getID() == 0)
							System.out.println("Professor \"" + profID + "\" não existe.");
						if (profID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}

					}
					if (Professor.size() == 0)
						System.out.println("Ainda não existem Professores.");
					else if (profID != -1) {
						try {
							disc.addProfessor(profE);
							System.out.println("Professore \""+profE+"\" adicionado.");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
				else if (valorIntroduzido == 5)/*remover professor*/ {
					long profID = 0;
					Professor profE = Professor.getProfessorFromID(Entity.Zero);
					while (profID != -1 && disc.getProfessores().size() != 0) {
						System.out.println("Digite o ID do Professorque quer remover(0 para mostrar todos os adicionados, -1 para cancelar): ");
						profID = Ler.processarTecladoLong();
						profE = Professor.getProfessorFromID(profID);

						if (profID == 0)
							System.out.println("Professores atuais: ");
							for(Entity prof : disc.getProfessores()){
								if(prof.getID() != 0)
									System.out.println(Professor.getProfessorFromID(prof));
							}
						if (profID == -1) {
							System.out.println("Operação cancelada.");
							break;
						}
						if (profE.getID() == 0) {
							System.out.println("Professor \"" + profID + "\" não existe.");
						}
					}
					if (disc.getProfessores().size() == 0)
						System.out.println("Ainda não foram adicionados Professores.");
					if (profID != -1) {
						try {
							disc.removeProfessor(profE);
							System.out.println("Professore \""+profE+"\" removido.");
						} catch (IllegalArgumentException | NullPointerException e) {
							System.out.println("Ocurreu um erro.");
							System.out.println(e.getMessage());
						}

					}
				}
				else if (valorIntroduzido == 6)/*mostrar salas*/ {
					System.out.println("---");
					System.out.println("Salas de " + disc);
					System.out.println("---");
					for(String sala : disc.getPossibleSalas()){
						System.out.println(sala);
					}
					System.out.println("---");
				}
				else if (valorIntroduzido == 7)/*inserir sala*/ {
					String sala = "";

					while(sala.equalsIgnoreCase("")) {
						System.out.println("Digite uma sala da Disciplina: ");
						sala = Ler.processarTecladoString();
					}

					try {
						disc.addPossibleSala(sala);
						System.out.println("Sala \""+ sala +"\" adicionada com sucesso.");
					} catch (IllegalArgumentException e){
						System.out.println(e.getMessage());
					}
				}
				else if (valorIntroduzido == 8)/*remover sala*/ {
					String sala = "";

					while(sala.equalsIgnoreCase("")) {
						System.out.println("Salas inseridas: ");
						for (String salas : disc.getPossibleSalas()) {
							System.out.println(salas);
						}

						System.out.println("Digite uma sala da Disciplina para remover (enter para cancelar): ");
						sala = Ler.processarTecladoString();

						if (sala.equalsIgnoreCase("")) {
							System.out.println("Operação cancelada.");
							break;
						}

						if(!disc.getPossibleSalas().contains(sala)){
							System.out.println("A sala \""+ sala +"\" ainda não foi inserida.");
							sala = "";
						}
					}

					System.out.println("Sala \""+ sala +"\" inserida com sucesso.");

					disc.removerPossibleSala(sala);
				}
				else if (valorIntroduzido != 9)
					System.out.println("Introduza um numero entre 1 e 7.");
			}
		}
	}
	public static void eliminarTodosDiscplina() {
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
			System.out.println("A limpar todos as Disciplinas.");

			String disnome;
			for (Disciplina _disciplina : Disciplina.getDisciplinas().values()) {
				if (_disciplina.getID() != 0) {
					try {
						disnome = _disciplina.toString();
						Disciplina.Remove(_disciplina);
						System.out.println("Disciplina \"" + disnome + "\" removida com sucesso.");
					} catch (IllegalArgumentException | NullPointerException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}

