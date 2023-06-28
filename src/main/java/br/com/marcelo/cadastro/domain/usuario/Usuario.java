package br.com.marcelo.cadastro.domain.usuario;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private Integer anoNascimento;
    private String genero;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.anoNascimento = dados.anoNascimento();
        this.genero = dados.genero();
    }

    public Usuario(){}

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", anoNascimento=" + anoNascimento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    public void atualizaDados(DadosAlteracaoUsuario dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.anoNascimento = dados.anoNascimento();
        this.genero = dados.genero();
    }
}
