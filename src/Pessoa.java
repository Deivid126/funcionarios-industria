import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    public String nome;
    public LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate data_nascimento){
        this.nome = nome;
        this.dataNascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.dataNascimento = data_nascimento;
    }
    public int getIdade() {
        LocalDate now = LocalDate.now();
        int idade = now.getYear() - this.dataNascimento.getYear();
        if (now.getMonthValue() < this.dataNascimento.getMonthValue() ||
                (now.getMonthValue() == this.dataNascimento.getMonthValue() &&
                        now.getDayOfMonth() < this.dataNascimento.getDayOfMonth())) {
            idade--;
        }
        return idade;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataNascimento.format(formatter);
        return String.format("%s, nascido(a) em %s", nome, dataFormatada);
    }
}
