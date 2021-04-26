package projetoV01;

public class Matricula {
	private Estudante estudante;
    private Disciplina disciplina;

    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public Estudante getEstudante() {
        return this.estudante;
    }
}


