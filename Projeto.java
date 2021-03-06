import myinput.Ler;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
public class Projeto {
	public static int exitop = 5;

	//Mostrar Menu principal	
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
		try {
			System.in.read();
		} catch (IOException e){}
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
		try {
			System.in.read();
		} catch (IOException e){}
	}
	
	
	
	//Mostrar Menu Disciplinas->Selecionar
	public static void printSelecionarDisciplina(){
		System.out.println("1- Mudar Nome");
		System.out.println("2- Mudar Ano");
		System.out.println("3- Mudar Aula");
		System.out.println("4- Inserir Professor");
		System.out.println("5- Inserir poss�vel sala");
		System.out.println("6- Voltar");
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
        public static void PrintTodosAlunos(){
          System.out.println("---");
		System.out.println("Todos os Alunos");
		System.out.println("---");
		for(Aluno alu : Aluno.getAlunos().values()){
			if(alu.getID() != 0){
				System.out.println(alu);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}
	
        //Mostrar todas as aulas
        public static void PrintTodasAulas(){
          System.out.println("---");
		System.out.println("Todas as Aulas");
		System.out.println("---");
		for(Aula aul : Aula.getAulas().values()){
			if(aul.getID() != 0){
				System.out.println(aul);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}        
        
        //Mostrar todos os testes
        public static void PrintTodosTestes(){
          System.out.println("---");
		System.out.println("Todos os Testes");
		System.out.println("---");
		for(Teste test : Teste.getTestes().values()){
			if(test.getID() != 0){
				System.out.println(test);
			}
		}
		System.out.println("---");
		try {
			System.in.read();
		} catch (IOException e){}
	}         
        
        //Mostrar menu Professor->Selecionar 
        public static void printSelecionarProfessor(){
                System.out.println("1- Inserir Aula");
		System.out.println("2- Mostrar horario");
		System.out.println("3- Criar teste");
		System.out.println("4- Selecionar teste");
		System.out.println("5- Voltar");
        }    
        
        //Mostrar menu Professor->Selecionar->Selecionar Teste
        public static void printSelecionarTeste(){
            	System.out.println("1- Mudar Nota");
		System.out.println("2- Eliminar Nota");
		System.out.println("3- Criar Nota");
		System.out.println("4- Mudar Data");
		System.out.println("5- Mudar aula");
		System.out.println("6- Voltar");
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
		try {
			System.in.read();
		} catch (IOException e){}
	} 
    
	//Fun��o Main
    public static void main(String[] args) {
		int valorIntroduzido=0;

		while(valorIntroduzido != 6) {

			System.out.println("1- Cursos");
			System.out.println("2- Turmas");
			System.out.println("3- Disciplinas");
			System.out.println("4- Professores");
			System.out.println("5- Alunos");
			System.out.println("6- Guardar e Sair");

			try {
				valorIntroduzido = Ler.processarTecladoInt();
			} catch (IOException | InputMismatchException e) {
				System.out.println("Ocurreu um erro, tente novamente.");
				valorIntroduzido = 0;
			}


			switch (valorIntroduzido) {
				case 1:
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) { // mostrar menu curso
						// Mostrar o menu
						printMenu("Curso", "Cursos");

						// ler a opção do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
						}

						// proximos menus
						Entity nCurso;
						Curso curso;
						long cursoID;
						long profID;
						long discID;
						Entity discEnt;
						Entity profEntity;
						Turma turma;
						int anoDeTurma;
						String stringInput;
						switch (valorIntroduzido){ // menu curso
							case 0:
								// Mostrar tudo
								printTodosCursos();
								break;
							case 1:
								// criar Curso
								nCurso = Curso.Create();
								curso = Curso.getCursoFromID(nCurso);

								// set nome
								String nome = "";
								while (nome.equals("")) {
									System.out.println("Insira o nome do Curso: ");
									try {
										nome = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocorreu um erro, insira novamente.");
									}
									if(nome.equals(""))
										System.out.println("Insira um nome correto.");
								}
								curso.setNome(nome);
								System.out.println("Nome alterado.");

								// set diretor
								profID = 0;
								profEntity = Entity.Zero;
								while(profEntity.getID() == 0 && Professor.getProfessores().size() != 0 && profID != -1){
									System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
									try {
										profID = Ler.processarTecladoLong();

										if(profID == 0){
											printTodosProfessores();
										} else if(profID != -1){
											profEntity = Professor.getProfessorFromID(profID);
										}
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}


									if(profEntity.getID() == 0 && profID != 0 && profID != -1) {
										System.out.println("Professor não encontrado.");

									}else if(profEntity.getID() != 0) {
										System.out.println("Diretor definido.");
										curso.setDiretor(profEntity);

									}else if(profID == -1){
										System.out.println("Diretor não definido.");

									}
								}
								if(Professor.getProfessores().size() == 0)
									System.out.println("Não existem professores.");


								System.out.println("Curso \""+nome+"\" criado com sucesso.");
								break;
								
								
							case 2://Eliminar um Curso
								System.out.println("Insira o ID do curso para eliminar (0 para mostrar todos, -1 para cancelar): ");

								cursoID = 0;
								nCurso = Entity.Zero;
								while(Curso.getCursos().size() != 0) {
									try {
										cursoID = Ler.processarTecladoLong();

										if(cursoID == 0){
											printTodosCursos();
										} else if (cursoID != -1){
											nCurso = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}

									if(		nCurso.getID() == 0 &&
											cursoID != 0 &&
											cursoID != -1){
										System.out.println("Curso não encontrado.");

									}else if(nCurso.getID() != 0){
										try{
											Curso.Remove(nCurso);
											System.out.println("Curso apagado.");
											break;
										} catch (IllegalArgumentException | NullPointerException e) {
											System.out.println(e.getMessage());
										}
									}else if(cursoID == -1){
										System.out.println("Operação cancelada.");
										break;
									}
								}

								break;
								
								
							case 3:

								cursoID = 0;
								curso = Curso.getCursoFromID(0);
								System.out.println(curso);
								while(cursoID != -1 &&
										curso.getID() == 0) {
									System.out.println("Insira o ID do curso (0 para mostrar todos, -1 para cancelar): ");
									try {
										cursoID = Ler.processarTecladoLong();

										if (cursoID == 0) {
											printTodosCursos();
										} else if (cursoID != -1) {
											curso = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
										cursoID = 0;
									}
								}
								if(Curso.getCursos().size() == 0) {
									System.out.println("Não existem cursos.");
									try {
										System.in.read();
									} catch (IOException e){}
									break;
								} else if(curso.getID() != 0) {
									// menu curso
									valorIntroduzido = -1;

									while(valorIntroduzido != 7) { // while para mostrar o menu
										System.out.println("Curso " + curso + "");
										System.out.println("1- Mudar Nome");
										System.out.println("2- Mudar Diretor");
										System.out.println("3- Inserir Disciplina");
										System.out.println("4- Remover uma Disciplina");
										System.out.println("5- Criar Turma");
										System.out.println("6- Mudar para " + (curso.getAtivo() ? "in" : "") + "activo");
										System.out.println("7- Voltar");

										try {
											valorIntroduzido = Ler.processarTecladoInt();
										} catch (IOException e){
											System.out.println("Ocurreu um erro, tente novamente.");
											valorIntroduzido = -1;
										}

										switch (valorIntroduzido){ // menu selecionar curso
											case 1:
												System.out.println("Enter para voltar ou insira um nome.");
												System.out.println("Nome atual: "+curso.getNome());

												stringInput = "";
												while(stringInput.equals("")) {
													try {
														stringInput = Ler.processarTecladoString();
													} catch (IOException e) {
														System.out.println("Ocurreu um erro, tente novamente.");
														stringInput = "";
													}
												}
												System.out.println("Nome mudade de \""+curso.getNome()+"\" para \""+stringInput+"\".");
												curso.setNome(stringInput);

												valorIntroduzido = 1;
												break;

											case 2:
												System.out.println("(0 para mostrar todos os professores, -1 para voltar)");
												System.out.println("Diretor atual: "+Professor.getProfessorFromID(curso.getDiretor()));

												profID = 0;
												profEntity = Entity.Zero;
												while(profEntity.getID() == 0 && Professor.getProfessores().size() != 0 && profID != -1){
													try {
														profID = Ler.processarTecladoLong();

														if(profID == 0){
															printTodosProfessores();
														} else if(profID != -1){
															profEntity = Professor.getProfessorFromID(profID);
														}
													} catch (IOException e) {
														System.out.println("Ocorreu um erro, insira novamente.");
														profID = 0;
														continue;
													}

													if(profEntity.getID() == 0 && profID != 0 && profID != -1) {
														System.out.println("Professor não encontrado.");

													}else if(profEntity.getID() != 0) {
														System.out.println("Diretor definido.");
														curso.setDiretor(profEntity);

													}else if(profID == -1){
														System.out.println("Operação cancelada.");
													}
												}
												if(Professor.getProfessores().size() == 0)
													System.out.println("Não existem professores.");
												break;

											case 3:
												System.out.println("Disciplinas já adicionadas:");
												for(Entity dis : curso.getDisciplinas()){
													System.out.println(Disciplina.getDisciplinaFromID(dis));
												}

												discID = 0;
												discEnt = Entity.Zero;
												while(Disciplina.getDisciplinas().size() != 0 && discID == 0 && discEnt.getID() == 0){
													System.out.println("(0 para mostrar todas as disciplinas, -1 para voltar)");
													System.out.println("Insira o ID da disciplina a inserir:");

													try {
														discID = Ler.processarTecladoLong();

														if (discID == 0){
															printTodasDisciplinas();
														} else if(discID != -1){
															discEnt = Disciplina.getDisciplinaFromID(discID);
														}
													} catch (IOException e){
														System.out.println("Ocorreu um erro, insira novamente");
														discID = 0;

													}
												}
												if (Disciplina.getDisciplinas().size() == 0){
													System.out.println("Não existem disciplinas.");
												} else if(discEnt.getID() != 0){
													try {
														curso.addDisciplina(discEnt);
													} catch (NullPointerException | IllegalArgumentException e){
														System.out.println(e.getMessage());
													}
												} else if(discID == -1){
													System.out.println("Operação cancelada");
												}

												break;
											case 4:
												System.out.println("Disciplinas já adicionadas:");
												for(Entity dis : curso.getDisciplinas()){
													System.out.println(Disciplina.getDisciplinaFromID(dis));
												}

												discID = 0;
												discEnt = Entity.Zero;
												while(Disciplina.getDisciplinas().size() != 0 && discID == 0 && discEnt.getID() == 0){
													System.out.println("(0 para mostrar todas as disciplinas, -1 para voltar)");
													System.out.println("Insira o ID da disciplina a apagar:");

													try {
														discID = Ler.processarTecladoLong();

														if (discID == 0){
															printTodasDisciplinas();
														} else if(discID != -1){
															discEnt = Disciplina.getDisciplinaFromID(discID);
														}
													} catch (IOException e){
														System.out.println("Ocorreu um erro, insira novamente");
														discID = 0;

													}
												}
												if (Disciplina.getDisciplinas().size() == 0){
													System.out.println("Não existem disciplinas.");
												} else if(discEnt.getID() != 0){
													try {
														curso.removeDisciplina(discEnt);
													} catch (NullPointerException | IllegalArgumentException e){
														System.out.println(e.getMessage());
													}
												} else if(discID == -1){
													System.out.println("Operação cancelada");
												}

												break;

											case 5:
												System.out.println("Criar nova turma");

												turma = Turma.getTurmaFromID(Turma.Create());
												turma.setCurso(curso);


												stringInput = "";
												while(stringInput.equals("")) {
													System.out.println("Insira o ano letivo:");
													try {
														stringInput = Ler.processarTecladoString();
													} catch (IOException e){
														System.out.println("Ocurreu um erro, tente novamente.");
														stringInput = "";
													}
												}
												turma.setAnoLetivo(stringInput);

												stringInput = "";
												while(stringInput.equals("")) {
													System.out.println("Insira o nome da turma:");
													try {
														stringInput = Ler.processarTecladoString();
													} catch (IOException e){
														System.out.println("Ocurreu um erro, tente novamente.");
														stringInput = "";
													}
												}
												turma.setAnoLetivo(stringInput);

												anoDeTurma = 0;
												while(anoDeTurma == 0) {
													System.out.println("Insira o ano da turma:");
													try {
														anoDeTurma = Ler.processarTecladoInt();
														if(anoDeTurma < 10 || anoDeTurma > 12){
															System.out.println("Ano tem que ser entre 10 e 12.");
															anoDeTurma = 0;
														}
													} catch (IOException e){
														System.out.println("Ocurreu um erro, tente novamente.");
														anoDeTurma = 0;
													}
												}
												turma.setAno(anoDeTurma);

												profID = 0;
												profEntity = Entity.Zero;
												while(profEntity.getID() == 0 && Professor.getProfessores().size() != 0 && profID != -1) {
													System.out.println("Insira o ID do professor (0 para mostrar todos, -1 para no definir):");
													try {
														profID = Ler.processarTecladoInt();
														if(profID == 0){
															printTodosProfessores();
														}else if(profID != -1){
															profEntity = Professor.getProfessorFromID(profID);
														}
													} catch (IOException e){
														System.out.println("Ocurreu um erro, tente novamente.");
														profID = 0;
													}
													if(profID != -1 && profEntity.getID() == 0)
														System.out.println("Professore não encontrado.");

												}
												if (Professor.getProfessores().size() == 0)
													System.out.println("Ainda não há professores.");
												try{
													turma.setDiretor(profEntity);
												} catch (IllegalArgumentException e){
												}catch (NullPointerException e){
													System.out.println(e.getMessage());
												}

												System.out.println("Turma criada com sucesso.");


												break;

											case 6:
												curso.setAtivo(!curso.getAtivo());
												break;

											case 7:
												break;

											default:
												System.out.println("Insira um numero entre 1 e 7");
										}
									}

									valorIntroduzido = 3;

								} else if(cursoID == -1){
									System.out.println("Operação cancelada.");
								}
								break;
								
								
							case 4:
								System.out.println("Tem a certeza que quer remover todos os Cursos [s/n]:");

								stringInput = "";
								while(	!stringInput.equalsIgnoreCase("n") && !stringInput.equalsIgnoreCase("nao") &&
										!stringInput.equalsIgnoreCase("s") && !stringInput.equalsIgnoreCase("sim")){
									try{
										stringInput = Ler.processarTecladoString();
									} catch (IOException e){
										stringInput = "";
										System.out.println("Ocurreu um erro, tente novamente.");
									}
								}
								if(stringInput.toLowerCase().equals("n") || stringInput.toLowerCase().equals("nao"))
									break;
								else if(stringInput.equalsIgnoreCase("s") || stringInput.equalsIgnoreCase("sim")){
									System.out.println("A limpar todos os cursos.");
									for(Curso _curso : Curso.getCursos().values()){
										if(_curso.getID() != 0){
											try {
												Curso.Remove(_curso);
												System.out.println("Curso \""+_curso+"\" removido com sucesso.");
											} catch (IllegalArgumentException | NullPointerException e){
												System.out.println(e.getMessage());
											}
										}
									}
								}
								break;
								
								
							case 5:

								break;
								
								
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				
				case 2://Opção Turmas
					
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Turma", "Turmas");

						// ler a op��oo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
                                                    System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que ser�o utilizadas no Menu abaixo
						Turma turma;
						Entity nTurma;
						long turmaID;
						long cursoID;
                                                long profID;
                                                Entity profEntity;
                                                Entity cursoEntity;
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodasTurmas();
								break;
								
							case 1://criar Turma
								nTurma = Turma.Create();
								turma = Turma.getTurmaFromID(nTurma);
                                                                //set ano letivo
                                                                String anoLetivo="", nome="";
                                                                while(anoLetivo=="" || nome==""){
                                                                    System.out.println("Insira o ano letivo no formato ano/anoseg e o nome da Turma.");
                                                                    try{
                                                                        anoLetivo = Ler.processarTecladoString();
                                                                        nome = Ler.processarTecladoString();
                                                                        if(anoLetivo=="" || nome == ""){
                                                                            System.out.println("Insira as informações corretas.");
                                                                        }
                                                                    } catch(IOException e){
                                                                       System.out.println("Ocorreu um erro, insira novamente.");
                                                                    }
                                                                }
                                                                turma.setAnoLetivo(anoLetivo);
                                                                turma.setNome(nome);
                                                                System.out.println("Ano letivo e nome alterados.");
                                                                
                                                                //set ano
                                                                int ano=0;
                                                                while(ano==0){
                                                                    System.out.println("Insira o ano da turma.");
                                                                    try{
                                                                        ano = Ler.processarTecladoInt();
                                                                    } catch(IOException e){
                                                                        System.out.println("Insira um ano correto.");
                                                                    }
                                                                }
                                                                turma.setAno(ano);
                                                                System.out.println("Ano alterado.");

								// set diretor
								profID = 0;
								profEntity = Entity.Zero;
								while(profEntity.getID() == 0 && Professor.getProfessores().size() != 0){
									System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
									try {
										profID = Ler.processarTecladoLong();

										if(profID == 0){
											printTodosProfessores();
										} else if(profID != -1){
											profEntity = Professor.getProfessorFromID(profID);
										}
									} catch (IOException e) {
										System.out.println("Ocorreu um erro, insira novamente.");
									}


									if(profEntity.getID() == 0 && profID != 0 && profID != -1) {
										System.out.println("Professor não encontrado.");

									}else if(profEntity.getID() != 0) {
										System.out.println("Diretor definido.");
										turma.setDiretor(profEntity);

									}else if(profID == -1){
										System.out.println("Diretor não definido.");
                                                                        }
                                                                }
                                                                
                                //set curso
								cursoID = 0;
								cursoEntity = Entity.Zero;
								while(cursoEntity.getID() == 0 && Curso.getCursos().size() != 0){
									System.out.println("Insira o ID do Curso (0 para mostrar todos, -1 para cancelar): ");
									try {
										cursoID = Ler.processarTecladoLong();

										if(cursoID == 0){
											printTodosCursos();
										} else if(profID != -1){
											cursoEntity = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Ocorreu um erro, insira novamente.");
									}


									if(cursoEntity.getID() == 0 && cursoID != 0 && cursoID != -1) {
										System.out.println("Curso não encontrado.");

									}else if(cursoEntity.getID() != 0) {
										System.out.println("Curso definido.");
										turma.setCurso(cursoEntity);

									}else if(cursoID == -1){
										System.out.println("Curso não definido.");
                                                                        }
                                                                }
								
							case 2://Eliminar Turma
								

								break;
								
							case 3://Selecionar Turma
								
								//Perguntar qual a Turma que o utilizador pretende alterar
								
								
								//Submenu das op�oes que o utilizador tem
								 switch(valorIntroduzido){
								 
								 		case 1://----------------------------------------------xxxxxxxx------------------------------------------------------

								 		break;
									 
								 		
								 		case 2://----------------------------------------------xxxxxxxxxx------------------------------------------------------
								 		
								 		break;
								 		
								 		
								 		case 3://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
								 			
								 		break;
									 
								 		
								 		case 4://----------------------------------------------xxxxxxxxxxxx------------------------------------------------------
									 
								 		break;
									 
								 		
								 		case 5://----------------------------------------------xxxxxxxxxxxxx---------------------------------------------------
									 
								 		break;
								 		
								 		case 6://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Turma", "Turmas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas as Turmas

							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;

					
					
					
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 3://Opcao Disciplinas
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Disciplina", "Disciplinas");

						// ler a opcao do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que serao utilizadas no Menu abaixo
						
						Disciplina disciplina;
						Entity nDisciplina;
						long disciplinaID;
						
						Professor professor;
						long profID;
						Entity nProf;
						
						String nome;
						int ano = 0;
						
						Aula aula;
						Entity nAula;
						long aulaID;
						
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodasDisciplinas();
								break;
								
							case 1:// criar Disciplina
								
								nDisciplina = Disciplina.Create();
								disciplina = Disciplina.getDisciplinaFromID(nDisciplina);

								//set nome da Disciplina
								nome = "";
								while (nome == "") {
									System.out.println("Insira o nome da Disciplina: ");
									try {
										nome = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}
									if(nome == "")
										System.out.println("Insira um nome correto.");
								}
								disciplina.setNome(nome);
								System.out.println("Nome alterado.");

								// set ano da Disciplina
								ano = 0;
								while(ano == 0){
									System.out.println("Insira o ano da Disciplina");
									try{
										ano = Ler.processarTecladoInt();
									} catch(IOException e){
										System.out.println("Ocorreu um erro, insira novamente.");
									}
									if(ano == 0)
										System.out.println("Insira um ano correto.");
								}
								disciplina.setAno(ano);
								System.out.println("Ano alterado");
							break;
								
							case 2://Eliminar Disciplina
								System.out.println("Insira o ID da Disciplina para eliminar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodosCursos();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}
								
								Disciplina.Remove(disciplina);
								break;
								
							case 3://Selecionar Disciplina
								
								//Perguntar qual a disciplina que ele quer alterar
								System.out.println("Insira o ID da Disciplina que predente selecionar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								
								
								//Procurar a Disciplina pretendida
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
											System.out.println("Voce selecionou a disciplina " + disciplina.getNome() + ".");
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								
							
								
								valorIntroduzido = -1;
								while(valorIntroduzido != exitop){
									//Print Menu Disciplina->Selecionar
									printSelecionarDisciplina();
									
									//Ler Valor para op�ao do menu
									try {
										valorIntroduzido = Ler.processarTecladoInt();
									} catch (IOException e) {
										System.out.println("Por favor introduza um valor entre 0 e" + exitop + ".");
									}
									
									switch(valorIntroduzido){
								 
								 		case 0://----------------------------------------------Mudar Nome------------------------------------------------------
								 			nome = "";
											while (nome == "") {
												System.out.println("Insira o nome da Disciplina: ");
												try {
													nome = Ler.processarTecladoString();
												} catch (IOException e) {
													System.out.println("Ocurreu um erro, insira novamente.");
												}
												if(nome == "")
													System.out.println("Insira um nome correto.");
											}
											
											disciplina.setNome(nome);
											System.out.println("Nome alterado.");
								 		break;
									 
								 		
								 		case 1://----------------------------------------------Mudar ano------------------------------------------------------
								 			ano = 0;
											while(ano == 0){
												System.out.println("Insira o ano da Disciplina");
												try{
													ano = Ler.processarTecladoInt();
												} catch(IOException e){
													System.out.println("Ocorreu um erro, insira novamente.");
												}
												if(ano == 0)
													System.out.println("Insira um ano correto.");
											}
								 			
								 			disciplina.setAno(ano);
								 			System.out.println("Ano alterado");
								 		break;
								 		
								 		
								 		case 2://----------------------------------------------Inserir Aula------------------------------------------------------
								 			/*Falta aqui esta*/
								 			nAula = Entity.Zero;
								 			aulaID=0;
                                             //Create(hora, DiaDaSemana, prof, nDisciplina, turma, sala);
								 			nAula = Aula.Create();
								 			aula = Aula.getAulaFromID(nAula);
								 			
								 			
								 			
								 			disciplina.addAula(nAula);
								 			
								 			
								 		break;
									 
								 		
								 		case 3://----------------------------------------------Inserir Professor------------------------------------------------------
								 			//criar professor
                                            nProf = Professor.Create();
                                            professor = Professor.getProfessorFromID(nProf);
                                            
                                            // set primeiro e ultimo nome
                                            String pNome="", uNome = "" ;
                                            
                                            while(pNome=="" || uNome=="" ){
                                                System.out.println("Insira o primeiro e o ultimo nome do professor.");
                                                try {
                                                    pNome = Ler.processarTecladoString();
                                                    uNome = Ler.processarTecladoString();
                                                } catch (IOException e) {
                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                }
                                                if(pNome==""  || uNome=="" )
                                                    System.out.println("Insira um nome correto.");
                                            }
                                            
                                            professor.setPrimeiroNome(pNome);
                                            professor.setUltimoNome(uNome);
                                            
                                            System.out.println("Nome alterado.");
                                            
                                            //set nascimento
                                            ZoneId zoneid = ZoneId.systemDefault();
                                            ZonedDateTime nascimento = ZonedDateTime.now();
                                            
                                            //Enquanto o ano do nascimento for diferente do ano atual
                                            while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                System.out.println("Insira a data de nascimento no seguinte formato ano->mes->dia.");
                                                
                                                try{
                                                    nascimento = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, 0, 0, zoneid);
                                                } catch (IOException e){
                                                    System.out.println("Introduza uma data correta.");
                                                }
                                            }
                                            
                                            professor.setNascimento(nascimento);
                                            System.out.println("Data de nascimento alterada.");
                                            
                                            disciplina.addProfessor(professor);
                                            System.out.println("Professor adicionado com sucesso.");
								 			
								 		break;
				
								 		case 4://----------------------------------------------Inserir Possivel sala---------------------------------------------------
								 			String nomeSala;
								 			
								 			while(nomeSala == ""){
                                                System.out.println("Insira a Sala desejada:");
                                                try {
                                                	nomeSala = Ler.processarTecladoString();
                                                } catch (IOException e) {
                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                }
                                                if(nomeSala == "")
                                                    System.out.println("Insira uma Sala correta:");
                                            }
								 			
								 			disciplina.addPossibleSala(nomeSala);
								 			System.out.println("Sala " + nomeSala + "adicionada com sucesso!");
								 		
								 		break;
								 		
								 		case 5://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Disciplina", "Disciplinas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
										}

									break;
								}
							case 4://Limpar Todas as Disciplinas
								String stringInput = "";
								System.out.println("Tem a certeza que quer remover todas as Disciplinas [s/n]:");

								while(	!stringInput.equalsIgnoreCase("n") && !stringInput.equalsIgnoreCase("nao") &&
										!stringInput.equalsIgnoreCase("s") && !stringInput.equalsIgnoreCase("sim")){
									try{
										stringInput = Ler.processarTecladoString();
									} catch (IOException e){
										stringInput = "";
										System.out.println("Ocurreu um erro, tente novamente.");
									}
								}
								if(stringInput.toLowerCase().equals("n") || stringInput.toLowerCase().equals("nao"))
									break;
								else if(stringInput.equalsIgnoreCase("s") || stringInput.equalsIgnoreCase("sim")){
									System.out.println("A limpar todas as Disciplinas.");
									for(Disciplina _disciplina : Disciplina.getDisciplinas().values()){
										if(_disciplina.getID() != 0){
											try {
												Disciplina.Remove(_disciplina);
												System.out.println("Disciplina \"" + _disciplina + "\" removida com sucesso.");
											} catch (IllegalArgumentException | NullPointerException e){
												System.out.println(e.getMessage());
											}
										}
									}
								}
								break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;

					
					
					
//-------------------------------------------------------------------------------------------------------------------------------------------------------------       
				case 4:
                                    valorIntroduzido = -1;
                                    while(valorIntroduzido != exitop){
                                        //Mostrar menu
                                        printMenu("Professor","Professores");
                                        
                                        //ler a opção do utilizador
                                        try{
                                            valorIntroduzido = Ler.processarTecladoInt();
                                        } catch (IOException e){
                                            System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                        }
                                        
                                        //proximos menus
                                        Entity nProfessor;
                                        Professor professor;
                                        long profID;
                                        
                                        switch(valorIntroduzido){
                                            case 0:
                                                //Mostrar tudo
                                                printTodosProfessores();
                                                break;
                                            case 1:
                                                //criar professor
                                                nProfessor=Professor.Create();
                                                professor = Professor.getProfessorFromID(nProfessor);
                                                
                                                // set primeiro e último nome
						String pNome="", uNome = "" ;
						while(pNome=="" || uNome=="" ){
                                                    System.out.println("Insira o primeiro e o ultimo nome do professor.");
                                                    try {
                                                        pNome = Ler.processarTecladoString();
                                                        uNome = Ler.processarTecladoString();
                                                    } catch (IOException e) {
                                                        System.out.println("Ocurreu um erro, insira novamente.");
                                                    }
                                                    if(pNome==""  || uNome=="" )
                                                        System.out.println("Insira um nome correto.");
                                                }
                                                professor.setPrimeiroNome(pNome);
                                                professor.setUltimoNome(uNome);
                                                System.out.println("Nome alterado.");
                                                
                                                //set nascimento
                                                ZoneId zoneid = ZoneId.systemDefault();
                                                ZonedDateTime nascimento = ZonedDateTime.now();
                                                //Enquanto o ano do nascimento for diferente do ano atual
                                                while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                    System.out.println("Insira a data de nascimento no seguinte formato ano->mês->dia.");
                                                    try{
                                                        nascimento = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, 0, 0, zoneid);
                                                    } catch (IOException e){
                                                        System.out.println("Introduza uma data correta.");
                                                    }
                                                }
                                                professor.setNascimento(nascimento);
                                                System.out.println("Data de nascimento alterada.");
                                                System.out.println("Professor: " +pNome+" "+uNome+" criado com sucesso.");
                                                break;
                                            
                                                
                                            case 2://Eliminar um Professor
                                                    System.out.println("Insira o ID do Professor para eliminar (0 para mostrar todos, -1 para cancelar): ");
                                                    
                                                    profID=0;
                                                    nProfessor=Entity.Zero;
                                                    while(nProfessor.getID() == 0 && Professor.getProfessores().size() != 0){
                                                        try{
                                                            profID = Ler.processarTecladoLong();
                                                            
                                                            if(profID == 0){
                                                                printTodosProfessores();
                                                            }
                                                            else if (profID != -1){
                                                                professor = Professor.getProfessorFromID(profID);
                                                                Professor.Remove(professor);
                                                            }
                                                        } catch (IOException e){
                                                            System.out.println("Ocorreu um erro, insira novamente.");
                                                        }    
                                                    }
                                                    break;
                                                    
                                            case 3://Selecionar Professor
                                                System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
                                                    
                                                profID=0;
                                                nProfessor=Entity.Zero;
                                                while(nProfessor.getID()==0 && Professor.getProfessores().size()!=0){
                                                     try{
                                                         profID = Ler.processarTecladoLong();
                                                    
                                                         if(profID == 0){
                                                            printTodosProfessores();
                                                        }
                                                        else if(profID!=-1){
                                                           professor = Professor.getProfessorFromID(profID);
                                                           
                                                           System.out.println("Selecionou o professor "+professor.getNome()+".");
                                                        }
                                                    } catch (IOException e){
                                                         System.out.println("Ocorreu um erro, insira novamente.");
                                                    } 
                                                   
                                                   valorIntroduzido=-1;
                                                   while(valorIntroduzido != exitop){
                                                        //Print do Menu Selecionar
                                                        printSelecionarProfessor();   
                                                        //ler valor do utilizador
                                                        try{
                                                            valorIntroduzido = Ler.processarTecladoInt();
                                                        } catch(IOException e){
                                                            System.out.println("Por favor introduza um valor entre 1 e"+exitop+".");
                                                        }
                                                        //proximos menus
                                                        Entity aulaEntity;
                                                        Aula aula;
                                                        long aulaID;
                                                        Entity nTeste;
                                                        Teste teste;
                                                        long testeID;
                                                        
                                                        switch(valorIntroduzido){
                                                            case 1://adicionar aula
                                                                aulaID=0;
                                                                aulaEntity = Entity.Zero;
                                                                while(aulaEntity.getID()==0){
                                                                    System.out.println("Insira o ID da aula (0 para mostrar todos, -1 para cancelar): ");
                                                                    try{
                                                                        aulaID = Ler.processarTecladoLong();
                                                                        
                                                                        if(aulaID == 0){
                                                                            PrintTodasAulas();
                                                                        } else if(aulaID != -1){
                                                                            aulaEntity = Aula.getAulaFromID(aulaID);
                                                                            Professor.getProfessorFromID(profID).addAula(aulaEntity);
                                                                        }
                                                                    } catch(IOException e){
                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                    }
                                                                }
                                                                break;
                                                            case 2://mostrar horario
                                                                String wtf; //FALTA FAZER HORARIOOO
                                                                ArrayList<ArrayList<Entity>> horario = Professor.getProfessorFromID(profID).getHorario();
                                                                for(int i=0;i<5;i++){
                                                                    System.out.println("\n"+horario.get(i).toString());
                                                                    for(int j=0;j<5;j++){
                                                                        System.out.print(horario.get(i).get(j));
                                                                    }
                                                                }
                                                                break;
                                                            case 3://Criar teste
                                                                nTeste = Teste.Create();
                                                                teste = Teste.getTesteFromID(nTeste);
                                                                
                                                                //set aula
                                                                aulaID=0;
                                                                aulaEntity = Entity.Zero;
                                                                while(aulaEntity.getID()==0 && Aula.getAulas().size() != 0){
                                                                    System.out.println("Insira o ID da aula (0 para mostrar todas, -1 para cancelar): ");
                                                                    try{
                                                                        aulaID = Ler.processarTecladoLong();
                                                                        
                                                                        if(aulaID == 0){
                                                                            PrintTodasAulas();
                                                                        } else if( aulaID != -1){
                                                                            aulaEntity = Aula.getAulaFromID(aulaID);
                                                                        }
                                                                    } catch (IOException e){
                                                                        System.out.println("Ocorreu um erro, introduza novamente.");
                                                                    }
                                                                }
                                                                teste.setAula(aulaEntity);
                                                                System.out.println("Aula introduzida.");
                                                                
                                                                //set data
                                                                zoneid = ZoneId.systemDefault();
                                                                ZonedDateTime data = ZonedDateTime.now();
                                                                //Enquanto o dia do ano for diferente do dia do ano atual
                                                                while(data.getDayOfYear()== ZonedDateTime.now().getDayOfYear()){
                                                                    System.out.println("Insira a data no seguinte formato ano->mês->dia->hora->minuto.");
                                                                    try{
                                                                        data = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, zoneid);
                                                                    } catch (IOException e){
                                                                        System.out.println("Introduza uma data correta.");
                                                                    }
                                                                }
                                                                teste.setData(data);
                                                                System.out.println("Data introduzida.");
                                                                Professor.getProfessorFromID(profID).addTeste(teste);
                                                                break;
                                                            case 4://Selecionar teste
                                                                System.out.println("Insira o ID do teste (0 para mostrar todos, -1 para cancelar): ");
                                                                
                                                                testeID=0;
                                                                nTeste=Entity.Zero;
                                                                while(nTeste.getID()==0 && Teste.getTestes().size() !=0){
                                                                    try{
                                                                        testeID = Ler.processarTecladoLong();
                                                                        
                                                                        if(testeID == 0){
                                                                            PrintTodosTestes();
                                                                        } else if(testeID != -1){
                                                                            teste = Teste.getTesteFromID(testeID);
                                                                        }
                                                                    } catch (IOException e){
                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                    }
                                                                    
                                                                    valorIntroduzido=-1;
                                                                    while(valorIntroduzido != exitop){
                                                                        //print do menu selecionar 
                                                                        printSelecionarTeste();
                                                                        //ler valor do utilizador
                                                                        try{
                                                                            valorIntroduzido = Ler.processarTecladoInt();
                                                                        } catch (IOException e){
                                                                            System.out.println("Por favor introduza um valor entre 1 e"+exitop+".");
                                                                        }
                                                                        //proximos menus 
                                                                        Entity alunoEntity;
                                                                        Aluno aluno;
                                                                        long alunoID;
                                                                        Entity nNota;
                                                                        Nota nota;
                                                                        long notaID;
                                                                        
                                                                        switch(valorIntroduzido){
                                                                            case 1://Alterar Nota
                                                                                nNota = Nota.Create();
                                                                                nota = Nota.getNotaFromID(nNota);
                                                                                
                                                                                //set aluno
                                                                                alunoID=0;
                                                                                alunoEntity=Entity.Zero;
                                                                                while(alunoEntity.getID()==0){
                                                                                        System.out.println("Insira o ID do aluno (0 para mostrar todos, -1 para cancelar): ");
                                                                                    try{
                                                                                        alunoID = Ler.processarTecladoLong();
                                                                        
                                                                                        if(alunoID == 0){
                                                                                            PrintTodosAlunos();
                                                                                        } else if(alunoID != -1 && Aluno.getAlunoFromID(alunoID).getID()!=0){
                                                                                            alunoEntity = Aluno.getAlunoFromID(alunoID);
                                                                                        }
                                                                                    } catch(IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira um aluno existente.");
                                                                                    }
                                                                                }
                                                                                nota.setAluno(alunoEntity);
                                                                                System.out.println("Aluno encontrado.");
                                                                                
                                                                                //set valor
                                                                                double valor = -1;
                                                                                while(valor<0 || valor>20){
                                                                                    System.out.println("Insira o valor da nova nota do aluno.");
                                                                                    try{
                                                                                        valor = Ler.processarTecladoDouble();
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza um valor entre 0 e 20.");
                                                                                    }
                                                                                }
                                                                                nota.setValor(valor);
                                                                                
                                                                                Teste.getTesteFromID(testeID).getNotas().replace(alunoEntity,nota);
                                                                            break;
                                                                            
                                                                            case 2://Eliminar Nota
                                                                                System.out.println("Insira o ID do Teste para eliminar (0 para mostrar todos, -1 para cancelar): ");
                                                                                
                                                                                notaID=0;
                                                                                nNota=Entity.Zero;
                                                                                while(nNota.getID()==0 && Nota.getNotas().size()!=0){
                                                                                    try{
                                                                                        notaID = Ler.processarTecladoLong();
                                                                                        if(notaID ==0){
                                                                                           PrintTodasAulas();
                                                                                        } else if(notaID != -1){
                                                                                            nota = Nota.getNotaFromID(notaID);
                                                                                            Nota.Remove(nota);
                                                                                        }
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                        }                           }
                                                                            break;
                                                                               
                                                                            case 3://Criar nota
                                                                                nNota = Nota.Create();
                                                                                nota = Nota.getNotaFromID(nNota);
                                                                                
                                                                                //set aluno
                                                                                alunoID=0;
                                                                                alunoEntity=Entity.Zero;
                                                                                while(alunoEntity.getID()==0){
                                                                                        System.out.println("Insira o ID do aluno (0 para mostrar todos, -1 para cancelar): ");
                                                                                    try{
                                                                                        alunoID = Ler.processarTecladoLong();
                                                                        
                                                                                        if(alunoID == 0){
                                                                                            PrintTodosAlunos();
                                                                                        } else if(alunoID != -1){
                                                                                            alunoEntity = Aluno.getAlunoFromID(alunoID);
                                                                                        }
                                                                                    } catch(IOException e){
                                                                                        System.out.println("Ocorreu um erro, insira novamente.");
                                                                                    }
                                                                                }
                                                                                nota.setAluno(alunoEntity);
                                                                                System.out.println("Aluno introduzido.");
                                                                                
                                                                                //set valor
                                                                                valor = -1;
                                                                                while(valor<0 || valor>20){
                                                                                    System.out.println("Insira o valor da nota do aluno.");
                                                                                    try{
                                                                                        valor = Ler.processarTecladoDouble();
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza um valor entre 0 e 20.");
                                                                                    }
                                                                                }
                                                                                nota.setValor(valor);
                                                                                nota.setTeste(Teste.getTesteFromID(testeID));
                                                                            break;
                                                                            
                                                                            case 4://Mudar data
                                                                                zoneid = ZoneId.systemDefault();
                                                                                data = ZonedDateTime.now();
                                                                                //Enquanto o dia do ano for diferente do dia do ano atual
                                                                                while(data.getDayOfYear()== ZonedDateTime.now().getDayOfYear()){
                                                                                    System.out.println("Insira a data no seguinte formato ano->mês->dia->hora->minuto.");
                                                                                    try{
                                                                                        data = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, zoneid);
                                                                                    } catch (IOException e){
                                                                                        System.out.println("Introduza uma data correta.");
                                                                                     }               
                                                                                }
                                                                                Teste.getTesteFromID(testeID).setData(data);
                                                                            break;
                                                                            
                                                                            case 5://Voltar
                                                                                break;
                                                                        
                                                                            default:    System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");

                                                                        }
                                                                        
                                                                    }
                                                                }
                                                                
                                                                break;
                                                            case 5://Voltar
                                                                break;
                                                                
                                                            default:
								System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");

                                                        }
                                                   }
                                                    
                                                
                                        }   
                                    }
					break;
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 5:

					printMenu("Aluno","Alunos");
                                        switch (valorIntroduzido) {
                                            case 1:
                                                valorIntroduzido=-1;
                                                while(valorIntroduzido!=exitop){
                                                    printMenu("Aluno","Alunos");
                                                    
                                                    try{
                                                        valorIntroduzido=Ler.processarTecladoInt();
                                                    }catch(IOException e){
                                                        System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                                    }
                                                    
                                                    Entity nAluno;
                                                    Aluno aluno;
                                                    String pNome="",uNome="";
                                                    
                                                    switch(valorIntroduzido){
                                                        case 0:
                                                            PrintTodosAlunos();
                                                            break;
                                                        case 1:
                                                            //criar alunos
                                                            nAluno = Aluno.Create();
                                                            aluno = Aluno.getAlunoFromID(nAluno);
                                                            
                                                            //set nomes
                                                            while(pNome=="" || uNome=="" ){
                                                                System.out.println("Insira o primeiro e o ultimo nome do aluno.");
                                                                try {
                                                                    pNome = Ler.processarTecladoString();
                                                                    uNome = Ler.processarTecladoString();
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                                }
                                                                if(pNome==""  || uNome=="" )
                                                                    System.out.println("Insira um nome correto.");
                                                            }
                                                            aluno.setPrimeiroNome(pNome);
                                                            aluno.setUltimoNome(uNome);
                                                            System.out.println("Nome alterado.");
                                                            
                                                            //set nascimento
                                                            ZoneId zoneid = ZoneId.systemDefault();
                                                            ZonedDateTime nascimento = ZonedDateTime.now();
                                                            while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                                System.out.println("Insira a data de nascimento no seguinte formato ano->mês->dia.");
                                                                try{
                                                                    nascimento = ZonedDateTime.of(Ler.processarTecladoInt(), Ler.processarTecladoInt(), Ler.processarTecladoInt(), 0, 0, 0, 0, zoneid);
                                                                } catch (IOException e){
                                                                    System.out.println("Introduza uma data correta.");
                                                                }
                                                            }
                                                            aluno.setNascimento(nascimento);
                                                            System.out.println("Data de nascimento alterada.");
                                                            
                                                            
                                                            //set turma
                                                            Entity turma=Entity.Zero;
                                                            long turmaID=0;
                                                            while(turma.getID()==0){
                                                                System.out.println("Insira o ID da turma(0 para mostrar todos, -1 para cancelar).");
                                                                try {
                                                                    turmaID = Ler.processarTecladoLong();
                                                                    
                                                                    if(turmaID==0){
                                                                        PrintTodosAlunos();
                                                                    }else if(turmaID!=-1){
                                                                        turma = Turma.getTurmaFromID(turma);
                                                                    }
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocorreu um erro, insira novamente.");
                                                                }
                                                            }
                                                                if(Turma.getTurmas().size() == 0)
                                                                    System.out.println("Não existem turmas.");
                                                                System.out.println("Aluno \""+pNome+uNome+"\" criado com sucesso.");
								break;

                                                        
                                                        case 3:
                                                            //set nascimento/??????????????NAO SEI COMO FAZER ISTO
                                                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd(ano/mes/dia)");
                                                            while(ZonedDateTime.now()!=null){
                                                                try{
                                                                    System.out.println("Insira o dia que quer alterar");
                                                                    dia=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o mês que quer alterar");
                                                                    mes=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o ano que quer alterar");
                                                                    ano=Ler.processarTecladoInt();
                                                                    if((dia<=0 && dia >=31) && (mes<0 && mes >12) && (ano<=0 && ano>Integer.MAX_VALUE))
                                                                        System.out.println("Nao é possivel inserir esses valores(dia esta compreendido entre 0 e 31, mês entre 0 e 12 e ano entre 0 e Integer.MAX_VALUE )");
                                                                    else
                                                                        System.out.println("Data mudada.");
                                                                }catch(IOException | NullPointerException e){
                                                                    e.getMessage();
                                                                    System.out.println("Insira novamente os valores");
                                                                }
                                                            }

                                                    }
                                                }
                                            case 2:
                                                    //Eliminar um aluno
                                                    System.out.println("Insira o ID do aluno para eliminar(0 para mostrar todos, -1 para cancelar).");
                                                    Aluno aluno;      
                                                    long alunoID=0;
                                                    Entity nAluno=Entity.Zero;
                                                    while(nAluno.getID() == 0 && Aluno.getAlunos().size()!=0){
                                                        try{
                                                            alunoID = Ler.processarTecladoLong();
                                                            if(alunoID ==0){
                                                                PrintTodosAlunos();
                                                            }else if(alunoID != -1){
                                                                aluno=Aluno.getAlunoFromID(alunoID);//extends entity ???
                                                            }
                                                        }catch (IOException e) {
                                                        	System.out.println("Occureu um erro, inisra novamente.");
                                                        }
                                                       }
                                            case 3:
                                                    valorIntroduzido = -1;
                                                while (valorIntroduzido != exitop) {
                                                    // Mostrar o menu
                                                    printMenu("Curso", "Cursos");

                                                    // ler a opção do utilizador
                                                    try {
                                                    	valorIntroduzido = Ler.processarTecladoInt();
                                                    } catch (IOException e) {
                                                    	System.out.println("Por favor introduza um valor entre 1 e "+exitop+".");
                                                    }
                                                    int x;
                                                    int turmaID;
                                                    Entity mudarTurma=Entity.Zero;
                                                    Entity mudarCurso=Entity.Zero;
                                                    boolean ativo;
                                                    Aluno alu=null;
                                                    switch (valorIntroduzido){
                                                    	case 0:
                                                    		// Mostrar tudo
                                                    		printTodosCursos();
                                                    	break;
                                                        case 1:
                                                            System.out.println("Insira o ano que deseja alterar.");
                                                            try{          
                                                                x=Ler.processarTecladoInt();
                                                                if(x<=10 || x>=12){
                                                                    alu.setAno(x);
                                                                    System.out.println("Mudou o ano.");
                                                                }
                                                            }catch(IOException e){
                                                                System.out.println("Insira um valor entre 10 e 12 inclusive.");
                                                            }
                                                        case 2:
                                                            System.out.println("Insira a turma que seja alterar.");
                                                            try{          
                                                                Turma.getTurmaFromID(mudarTurma);
                                                                Aluno.getAlunoFromID(alu).setTurma(mudarTurma);
                                                                System.out.println("Mudou a turma"); 
                                                            }catch(NullPointerException e){
                                                                e.getMessage();
                                                                System.out.println("A turma que quer mudar nao existe.");
                                                            }
                                                        case 3:
                                                            System.out.println("Insira o curso que seja alterar.");
                                                            try{          
                                                                Curso.getCursoFromID(mudarCurso);
                                                                Aluno.getAlunoFromID(alu).setCurso(mudarCurso);
                                                                System.out.println("Mudou o curso"); 
                                                            }catch(NullPointerException e){
                                                                e.getMessage();
                                                                System.out.println("O curso que quer mudar nao existe.");
                                                            }
                                                        case 4:
                                                            System.out.println("Diga se quer o aluno ativo ou não(true or false)");
                                                            try{
                                                                ativo=Ler.processarTecladoBoolean();
                                                                System.out.println("Diga qual o aluno.");
                                                                alunoID=Ler.processarTecladoLong();
                                                                if(ativo==true){
                                                                    alu.setActive(ativo);
                                                                    System.out.println("Aluno ativo");
                                                                }else if(ativo==false){
                                                                    alu.setActive(ativo);
                                                                    System.out.println("Aluno inativo");
                                                                }
                                                            }catch(IOException e){
                                                                e.getMessage();
                                                                System.out.println("");
                                                            }
                                                        case 5:
                                                            System.out.println("Atividade:");
                                                            for (Map.Entry<ZonedDateTime, String> actividade : alu.getNascimento())
                                                                System.out.println(actividade.getKey() +": "+ actividade.getValue());
					valorIntroduzido = 5;
					break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 6:
					break;

//-----------------------------------------------------------------------------------------------------------------------------------------------------
				default:
					System.out.println("Por favor introduza um valor entre 1 e 6.");
			}
		}

		System.out.println("Goodbye");

	}
    
}
