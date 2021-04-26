package projetoV01;

import java.util.List;
import java.util.Scanner;

public class App {
	
	    public static void main(String[] args) throws Exception {
	        Faculdade faculdade = new Faculdade("Impacta");

	        faculdade.carregarDadosArquivo(
	            "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\3 Semestre\\Estrutura de Dados\\projetoV01/Diciplinas.txt", 
	            "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\3 Semestre\\Estrutura de Dados\\projetoV01/Estudantes.txt", 
	            "C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\3 Semestre\\Estrutura de Dados/Matriculas.txt"
	        );

	        Scanner scanner = new Scanner(System.in);

	        boolean systemStatus = true;
	        faculdade.getEstudantes();
	        faculdade.getDisciplinas();

	        while(systemStatus) {
	            System.out.println(
	                "Digite:\n1 - Para Listar os usuarios\n2 - Listar os códigos das disciplinas\n3 - Listar informações dos estudantes matriculados\n4 - Listar todas as informações das disciplinas em que um determinado estudante está matriculado\n5 - SAIR"
	            );
	    
	            int escolhaDoUsuario = scanner.nextInt();
	    
	            switch (escolhaDoUsuario){
	                case 1:
	                    List<Estudante> estudantes = faculdade.getEstudantes();

	                    for (Estudante estudante: estudantes) {
	                        System.out.println(estudante.getId() + " - " + estudante.getNome());
	                    }

	                break;
	    
	                case 2:
	                    List<Disciplina> disciplinas = faculdade.getDisciplinas();

	                    for (Disciplina disciplina: disciplinas) {
	                        System.out.println(disciplina.getCodigo());
	                    }
	                break;
	    
	                case 3:
	                    System.out.println("Digite o nome do curso: ");

	                    String codigo = scanner.nextLine();

	                    if (codigo.isEmpty()) {
	                        codigo = scanner.nextLine();
	                    }

	                    List<Matricula> matriculas = faculdade.getMatriculasByDisciplinaCodigo(codigo);

	                    for(Matricula matricula: matriculas) {
	                        System.out.println(
	                            matricula.getEstudante().getId() 
	                            + " - " + 
	                            matricula.getEstudante().getNome() 
	                            + " - " + 
	                            matricula.getEstudante().getEmail()
	                        );
	                    }

	                break;
	    
	                case 4:
	                    System.out.println("Digite o Id do Aluno: ");

	                    String numeroIdentificadorEstudante = scanner.nextLine();

	                    if (numeroIdentificadorEstudante.isEmpty()) {
	                        numeroIdentificadorEstudante = scanner.nextLine();
	                    }

	                    List<Matricula> matriculasUsuario = faculdade.getMatriculasByEstudanteId(
	                        Integer.parseInt(
	                            numeroIdentificadorEstudante
	                        )
	                    );

	                    for(Matricula matricula : matriculasUsuario) {
	                        System.out.println(
	                            matricula.getDisciplina().getCodigo() + " - " +
	                            matricula.getDisciplina().getCreditos()
	                        );
	                    }
	                break;

	                case 5:
	                    systemStatus = false;
	                break;
	    
	                default: 
	                    System.out.println("Escolha não permitida");
	                break;
	            }
	        }

	        scanner.close();
	    }
	}