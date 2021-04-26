package projetoV01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Faculdade {
	private String nomeFaculdadeEsperado;

    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    private String nomeArquivoDisciplinas;
    private String nomeArquivoEstudantes;
    private String nomeArquivoMatriculas;

    public Faculdade(String nomeFaculdadeEsperado) {
        this.nomeFaculdadeEsperado = nomeFaculdadeEsperado;
    }

    public String getNome() {
        return this.nomeFaculdadeEsperado;
    }

    public void carregarDadosArquivo(
        String nomeArquivoDisciplinas, 
        String nomeArquivoEstudantes, 
        String nomeArquivoMatriculas
    ) {
        this.nomeArquivoDisciplinas = nomeArquivoDisciplinas;
        this.nomeArquivoEstudantes = nomeArquivoEstudantes;
        this.nomeArquivoMatriculas = nomeArquivoMatriculas;
    }

    public List<Estudante> getEstudantes() {
        try {
            BufferedReader estudantes = new BufferedReader(
                new FileReader(this.nomeArquivoEstudantes)
            );

            String estudanteFile;

            while((estudanteFile = estudantes.readLine()) != null) {
                String[] estudanteData = estudanteFile.split(":");

                List<Matricula> matriculasEstudante = this.getMatriculasByEstudanteId(
                    Integer.parseInt(estudanteData[0])
                );

                this.estudantes.add(
                    new Estudante(
                        Integer.parseInt(estudanteData[0]),
                        estudanteData[1],
                        estudanteData[2],
                        matriculasEstudante
                    )
                );
            }

            estudantes.close();
            
            return this.estudantes;
        } catch (Exception e) {
            return this.estudantes;
        }
    }


    public Estudante getEstudanteById(int id) {
        try {
            for(Estudante estudante: this.estudantes) {
                if(estudante.getId() == id){
                    return estudante;
                }
            }
            
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Disciplina getDisciplinaById(String id){
        try {
            for(Disciplina disciplina: this.disciplinas) {
                if(disciplina.getCodigo().equals(id)){
                    return disciplina;
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Disciplina> getDisciplinas() {
        try {
            BufferedReader disciplinas = new BufferedReader(
                new FileReader(this.nomeArquivoDisciplinas)
            );

            String disciplinaFile;

            while((disciplinaFile = disciplinas.readLine()) != null) {
                String[] disciplinaData = disciplinaFile.split(":");

                List<Matricula> matriculas = this.getMatriculasByDisciplinaCodigo(
                    disciplinaData[0]
                );

                this.disciplinas.add(
                    new Disciplina(
                        disciplinaData[0],
                        Integer.parseInt(disciplinaData[1]),
                        matriculas
                    )
                );
            }

            disciplinas.close();
            
            return this.disciplinas;
        } catch (Exception e) {
            return this.disciplinas;
        }
    }

    public List<Matricula> getMatriculasByEstudanteId(int estudanteNumero) {
         List<Matricula> matriculas = new ArrayList<Matricula>();


        try {
            BufferedReader matriculasOnFile = new BufferedReader(
                new FileReader(this.nomeArquivoMatriculas)
            );

            String matriculaFile;

            while((matriculaFile = matriculasOnFile.readLine()) != null) {
                String[] matriculaData = matriculaFile.split(":");
                
                if(Integer.parseInt(matriculaData[0]) == estudanteNumero){

                    Estudante estudante = this.getEstudanteById(estudanteNumero);


                    Disciplina disciplina = this.getDisciplinaById(matriculaData[1]);

                    matriculas.add(
                        new Matricula(
                            estudante,
                            disciplina
                        )
                    );                    
                }
            }

            matriculasOnFile.close();
            
            return matriculas;
        } catch (Exception e) {
            return matriculas;
        }
    }

    public List<Matricula> getMatriculasByDisciplinaCodigo(String codigoDisciplina) {
        List<Matricula> matriculas = new ArrayList<Matricula>();

        try {
            BufferedReader matriculasOnFile = new BufferedReader(
                new FileReader(this.nomeArquivoMatriculas)
            );

            String matriculaFile;

            
            while((matriculaFile = matriculasOnFile.readLine()) != null) {
                String[] matriculaData = matriculaFile.split(":");

                if(matriculaData[1].equals(codigoDisciplina)){
                    Estudante estudante = this.getEstudanteById(
                        Integer.parseInt(matriculaData[0])
                    );

                    Disciplina disciplina = this.getDisciplinaById(matriculaData[1]);

                    matriculas.add(
                        new Matricula(
                            estudante,
                            disciplina
                        )
                    );                  
                }
            }

            matriculasOnFile.close();
            
            return matriculas;
        } catch (Exception e) {
            return matriculas;
        }
   }


}

