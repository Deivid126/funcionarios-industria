import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        //Inserir os Funcionarios
        List<Funcionario> funcionarios = inserir();

        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }
        System.out.println("\n");

        //Remove João
        funcionarios.remove(1);

        //Aumento de 10% para todos
        List<Funcionario> funcionarios10 = aumenta10(funcionarios);

        for (Funcionario f : funcionarios10) {
            System.out.println(f.toString());
        }
        System.out.println("\n");

        //Agrupa por Função
        agruparFuncionariosPorFuncao(funcionarios10);

        System.out.println("\n");

        //Agrupa por Data de nascimento
        datanascimento(funcionarios10);

        System.out.println("\n");

        //Funcionario mais velho
        maisvelho(funcionarios10);

        System.out.println("\n");

        //Ordem Alfabetica
        ordemAlfabetica(funcionarios10);

        System.out.println("\n");

        //Total de Salários
        TotalSalarios(funcionarios10);

        System.out.println("\n");
        //Salarios Minimos de Cada um
        SalariosMinimos(funcionarios10);





    }

    public static List<Funcionario> inserir(){
        List<Funcionario> funcionarios = new ArrayList();
        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000,10,18), BigDecimal.valueOf(2009.4),"Operador");
        funcionarios.add(maria);
        Funcionario joao = new Funcionario("João", LocalDate.of(1990,5,12), BigDecimal.valueOf(2284.38),"Operador");
        funcionarios.add(joao);
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961,5,2), BigDecimal.valueOf(9836.14),"Coordenador");
        funcionarios.add(caio);
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988,10,14), BigDecimal.valueOf(19119.88),"Diretor");
        funcionarios.add(miguel);
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995,1,5), BigDecimal.valueOf(2234.68),"Recepcionista");
        funcionarios.add(alice);
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999,11,19), BigDecimal.valueOf(1582.72),"Operador");
        funcionarios.add(heitor);
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993,3,31), BigDecimal.valueOf(4071.84),"Contador");
        funcionarios.add(arthur);
        Funcionario laura= new Funcionario("Laura", LocalDate.of(1994,7,8), BigDecimal.valueOf(3017.45),"Gerente");
        funcionarios.add(laura);
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003,5,24), BigDecimal.valueOf(1606.85),"Eletricista");
        funcionarios.add(heloisa);
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996,9,2), BigDecimal.valueOf(2799.93),"Gerente");
        funcionarios.add(helena);

        return funcionarios;
    }

    public static List<Funcionario> aumenta10(List<Funcionario> funcionarios){
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }
        return funcionarios;
    }

    public static void  agruparFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario f : funcionarios) {
            String funcao = f.getFuncao();
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<Funcionario>());
            }
            funcionariosPorFuncao.get(funcao).add(f);
        }
        for (String funcao : funcionariosPorFuncao.keySet()) {
            System.out.println("Funcionários da função " + funcao + ":");
            List<Funcionario> listaFuncionarios = funcionariosPorFuncao.get(funcao);
            for (Funcionario f : listaFuncionarios) {
                System.out.println(f.toString());
            }
            System.out.println();
        }
    }

    public static void datanascimento(List<Funcionario> funcionarios){
        System.out.println("Funcionários que fazem aniversário em outubro ou dezembro:");
        for (Funcionario funcionario : funcionarios) {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            int mesAniversario = dataNascimento.getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12) {
                String nome = funcionario.getNome();
                System.out.printf("%s - Aniversário: %s\n", nome, dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }

    public static void maisvelho(List<Funcionario> funcionarios){
        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdade() > maisVelho.getIdade()) {
                maisVelho = funcionario;
            }
        }
        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", Idade: " + maisVelho.getIdade() + " Anos");
    }

    public static void ordemAlfabetica(List<Funcionario> funcionarios){
        Collections.sort(funcionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getNome().compareTo(f2.getNome());
            }
        });

        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }
    }
    public static void TotalSalarios(List<Funcionario> funcionarios){
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.println(String.format("Total dos salários: R$ %,.2f ",totalSalarios));
    }
    public static void SalariosMinimos(List<Funcionario> funcionarios){
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        Map<String, BigDecimal> salariosMinimos = new HashMap<>();

        for(Funcionario f : funcionarios) {
            BigDecimal salario = f.getSalario();
            BigDecimal salariosMinimosFuncionario = salario.divide(salarioMinimo,2, RoundingMode.HALF_UP);
            salariosMinimos.put(f.getNome(), salariosMinimosFuncionario);
        }

        System.out.println("Salários em salários mínimos: " + salariosMinimos);
    }

}