import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    public BigDecimal salario;

    public String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return String.format("%s, ganha R$ %,.2f e exerce a função de %s", super.toString(), salario, funcao);
    }
}
