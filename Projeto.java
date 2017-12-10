import myinput.Ler;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Projeto {
	public static int exitop = 5;

	public static void printMenu(String singular, String plural){
		System.out.println(plural +":");
		System.out.println("0- Mostrar "+ plural);
		System.out.println("1- Criar "+ singular);
		System.out.println("2- Eliminar "+ singular);
		System.out.println("3- Selecionar "+ singular);
		System.out.println("4- Limpar todos os "+ plural);
		System.out.println("5- Voltar");
	}

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
		try {
			System.in.read();
		} catch (IOException e){}
	}
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
		try {
			System.in.read();
		} catch (IOException e){}
	}
<<<<<<<


=======

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
>>>>>>>
	
	//Fun��o Main
    public static void main(String[] args) {
		int valorIntroduzido=0;

		while(valorIntroduzido != 6) {
			valorIntroduzido = 0;

			System.out.println("1- Cursos");
			System.out.println("2- Turmas");
			System.out.println("3- Disciplinas");
			System.out.println("4- Professores");
			System.out.println("5- Alunos");
			System.out.println("6- Guardar e Sair");

			try {
				valorIntroduzido = Ler.processarTecladoInt();
			} catch (IOException e) {
				System.out.println("Por favor introduza um valor entre 1 e 6.");
			}


			switch (valorIntroduzido) {
				case 1:
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

						// proximos menus
						Entity nCurso;
						Curso curso;
						long cursoID;
						long profID;
						Entity profEnity;
						switch (valorIntroduzido){
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
								while (nome == "") {
									System.out.println("Insira o nome do Curso: ");
									try {
										nome = Ler.processarTecladoString();
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}
									if(nome == "")
										System.out.println("Insira um nome correto.");
								}
								curso.setNome(nome);
								System.out.println("Nome alterado.");

								// set diretor
								profID = 0;
								profEnity = Entity.Zero;
								while(profEnity.getID() == 0 && Professor.getProfessores().size() != 0){
									System.out.println("Insira o ID do Professor (0 para mostrar todos, -1 para cancelar): ");
									try {
										profID = Ler.processarTecladoLong();

										if(profID == 0){
											printTodosProfessores();
										} else if(profID != -1){
											profEnity = Professor.getProfessorFromID(profID);
										}
									} catch (IOException e) {
										System.out.println("Ocurreu um erro, insira novamente.");
									}


									if(profEnity.getID() == 0 && profID != 0 && profID != -1) {
										System.out.println("Professor não encontrado.");

									}else if(profEnity.getID() != 0) {
										System.out.println("Diretor definido.");
										curso.setDiretor(profEnity);

									}else if(profID == -1){
										System.out.println("Diretor não definido.");

									}
								}
								if(Professor.getProfessores().size() == 0)
									System.out.println("Não existem professores.");


								System.out.println("Curso \""+nome+"\" criado com sucesso.");
								break;
							case 2:
								System.out.println("Insira o ID do curso para eliminar (0 para mostrar todos, -1 para cancelar): ");

								cursoID = 0;
								nCurso = Entity.Zero;
								while(nCurso.getID() == 0 && Curso.getCursos().size() != 0) {
									try {
										cursoID = Ler.processarTecladoLong();

										if(cursoID == 0){
											printTodosCursos();
										} else if (cursoID != -1){
											curso = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								break;
							case 3:

								break;
							case 4:

								break;
							case 5:
                                                                
								break;
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
					break;
				case 2:
					printMenu("Turma","Turmas");

					valorIntroduzido = 2;
					break;
				case 3:
					printMenu("Disciplina","Disciplinas");

					
					
					
					
//-----------------------------------------------------------------------------------------------------------------------------------------------------
				case 3://Op�ao Disciplinas
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Disciplina", "Disciplinas");

						// ler a op��oo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que ser�o utilizadas no Menu abaixo
						Disciplina disciplina;
						
						Entity nDisciplina;
						long disciplinaID;
						
						long profID;
						Entity profEntity;
						
						String nome;
						int ano = 0;
						
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
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}


								break;
								
							case 3://Selecionar Disciplina
								
								//Perguntar qual a disciplina que ele quer alterar
								System.out.println("Insira o ID da Disciplina que predente selecionar (0 para mostrar todos, -1 para cancelar): ");

								disciplinaID = 0;
								nDisciplina = Entity.Zero;
								
								while(nDisciplina.getID() == 0 && Disciplina.getDisciplinas().size() != 0) {
									try {
										disciplinaID = Ler.processarTecladoLong();

										if(disciplinaID == 0){
											printTodasDisciplinas();
										} else if (disciplinaID != -1){
											disciplina = Disciplina.getDisciplinaFromID(disciplinaID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								System.out.println("Voce selecionou a disciplina " + disciplina.getNome());
								
								//Print do enu selecionar
								printMenuSelecionar();
								
								//Ler Valor para op�ao do menu
								try {
									valorIntroduzido = Ler.processarTecladoInt();
								} catch (IOException e) {
									System.out.println("Por favor introduza um valor entre 1 e 6.");
								}
								
								
								 switch(valorIntroduzido){
								 
								 		case 1://----------------------------------------------Mudar Nome------------------------------------------------------
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
									 
								 		
								 		case 2://----------------------------------------------Mudar ano------------------------------------------------------
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
								 		
								 		
								 		case 3://----------------------------------------------Inserir Aula------------------------------------------------------
								 			aulaID = 0;
								 			nAula = Entity.Zero;
								 			
								 			
								 		break;
									 
								 		
								 		case 4://----------------------------------------------Inserir Professor------------------------------------------------------
									 
								 		break;
									 
								 		
								 		case 5://----------------------------------------------Inserir Possivel sala---------------------------------------------------
									 
								 		break;
								 		
								 		case 6://----------------------------------------------Voltar------------------------------------------------------
								 			printMenu("Disciplina", "Disciplinas");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas as Disciplinas

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
<<<<<<<
				case 4://op�ao professores
					
					valorIntroduzido = -1;
					while (valorIntroduzido != exitop) {
						// Mostrar o menu
						printMenu("Professor", "Professores");

						// ler a op��oo do utilizador
						try {
							valorIntroduzido = Ler.processarTecladoInt();
						} catch (IOException e) {
							System.out.println("Por favor introduza um valor entre 1 e " + exitop + ".");
						}

					
						//Variaveis que ser�o utilizadas no Menu abaixo
						Professor professor;
						
						Entity nProfessores;
						long ProfessorID;
						
						
						switch (valorIntroduzido){
							case 0:// Mostrar tudo
								printTodosProfessores();
								break;
								
							case 1://criar Professor
								
								nProfessores = Professor.Create();
								professor = Professor.getProfessorFromID(nProfessores);

								
								
								
							case 2://Eliminar Professor
								

								break;
								
							case 3://Selecionar Professor
								
								//Perguntar qual o Prodfessor que o utilizador pretende alterar
								
								
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
								 			printMenu("Professor", "Professores");
								 		break;
								 
								 		default:
								 			System.out.println("Por favor introduza um valor entre 1 e 6.");
								 }

							break;
							
							case 4://Limpar Todas os Professores

							break;
						
							case 5://Voltar
								
							break;
						
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					}
					valorIntroduzido = 1;
=======
				case 4:
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
                                        long aulaID;
                                        long testeID;
                                        long alunoID;
                                        Entity profEntity;
                                        Entity aulaEntity;
                                        Entity testeEntity;
                                        Entity alunoEntity;
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
                                                while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                    System.out.println("Insira a data de nascimento no seguinte formato ano-mês-dia.");
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
                                        }
                                        
                                    }
/*				System.out.println("Curso \""+nome+"\" criado com sucesso.");
								break;
								
								
							case 2://Eliminar um Curso
								System.out.println("Insira o ID do curso para eliminar (0 para mostrar todos, -1 para cancelar): ");

								cursoID = 0;
								nCurso = Entity.Zero;
								while(nCurso.getID() == 0 && Curso.getCursos().size() != 0) {
									try {
										cursoID = Ler.processarTecladoLong();

										if(cursoID == 0){
											printTodosCursos();
										} else if (cursoID != -1){
											curso = Curso.getCursoFromID(cursoID);
										}
									} catch (IOException e) {
										System.out.println("Occureu um erro, inisra novamente.");
									}
								}

								break;
								
								
							case 3:

								break;
								
								
							case 4:

								break;
								
								
							case 5:
                                                                
								break;
								
								
							default:
								System.out.println("Por favor introduza um valor entre 1 e 6.");

						}
					*/
					valorIntroduzido = 1;
>>>>>>>
					break;
				case 5:
<<<<<<<
					printMenu("Aluno","Alunos");
=======
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
                                                    int ano=0,mes=0,dia=0;
                                                    Aluno aluno;
                                                    long turmID;
                                                    ZonedDateTime nascimento=null;
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
                                                            while(pNome=="" && uNome==""  ){
                                                                System.out.println("Insira o primeiro e o ultimo nome do aluno.");
                                                                try {
                                                                    pNome = Ler.processarTecladoString();
                                                                    uNome = Ler.processarTecladoString();
                                                                    System.out.println("Insira o dia.");
                                                                    dia=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o mês.");
                                                                    mes=Ler.processarTecladoInt();
                                                                    System.out.println("Insira o ano.");
                                                                    ano=Ler.processarTecladoInt();
                                                                } catch (IOException e) {
                                                                    System.out.println("Ocurreu um erro, insira novamente.");
                                                                }
                                                                if(pNome==""  || uNome=="" || (dia<=0 && dia >=31) || (mes<0 && mes >12) || (ano<=0 && ano>Integer.MAX_VALUE) )
                                                                    System.out.println("Insira um nome correto.");
                                                            }
                                                            aluno.setPrimeiroNome(pNome);
                                                            aluno.setUltimoNome(uNome);
                                                            aluno.setNascimento(nascimento);//dia???
                                                            aluno.setNascimento(nascimento.withDayOfMonth(mes));
                                                            aluno.setNascimento(nascimento.withDayOfYear(ano));
                                                            System.out.println("Nome alterado.");
                                                            
                                                            //set nascimento
                                                            ZoneId zoneid = ZoneId.systemDefault();
                                                            ZonedDateTime nascimento = ZonedDateTime.now();
                                                            while(nascimento.getYear() == ZonedDateTime.now().getYear()){
                                                                System.out.println("Insira a data de nascimento no seguinte formato ano-mês-dia.");
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
                                                    long alunoID=0;
                                                    Aluno aluno=null ;
                                                    Entity nAluno=Entity.Zero;
                                                    while(nAluno.getID() == 0 && Aluno.getAlunos().size()!=0){
                                                        try{
                                                            alunoID = Ler.processarTecladoLong();
                                                            if(alunoID ==0){
                                                                PrintTodosAlunos();
                                                            }else if(alunoID != -1){
                                                                aluno=Aluno.getAlunoFromID(nAluno);
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

				case 6:
					break;


				default:
					System.out.println("Por favor introduza um valor entre 1 e 6.");
			}
		}

		System.out.println("Goodbye");

	}
    
}
