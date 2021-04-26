package projetoV01;

import java.util.List;

public class Estudante {
	private String nome;
    private String email;
    private int numero;
    private List<Matricula> matriculas;

    public Estudante(int numero, String nome, String email, List<Matricula> matriculas) {
        this.numero = numero;
        this.nome = nome;
        this.email = email;
        this.matriculas = matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.numero;
    }

    public List<Matricula> getMatriculas() {
        return this.matriculas;
    }

}
