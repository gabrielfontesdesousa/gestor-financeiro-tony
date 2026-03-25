package gerenciador.financeiro;

public class Categoria {
    private String nome;
    private String desc;

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Categoria(String nome, String desc) {
        this.nome = nome;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
