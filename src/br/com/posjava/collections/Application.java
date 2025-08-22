package br.com.posjava.collections;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Application {

    public Application() {
        test();
    }

    public void test() {
        final var employees = createEmployees();

        // Exibe os elementos na ordem inversa de inserção,
        // sem modificar a lista original (somente a iteração é invertida)
//        employees.reversed().forEach(System.out::println);

        // Filtra os funcionários que trabalham no departamento de Faturamento
//        employees.stream()
//                .filter(employee -> employee.department().equals("Faturamento"))
//                .forEach(System.out::println);

//        final var total = employees.stream()
//                .filter(employee -> employee.department().equals("Faturamento"))
//                .count();
//        System.out.println("Total de funcionários no departamento de Faturamento: " + total);

        // Filtra os funcionários que trabalham no departamento de Faturamento com salário maior que 3000
//        employees.stream()
//                .filter(employee -> employee.department().equals("Faturamento")
//                        && employee.salary().compareTo(new BigDecimal(3000)) > 0)
//                .forEach(System.out::println);

        // Soma o total de salários dos funcionários
        // Reduce é uma operação terminal que reduz os elementos da stream a um único valor
        // Resumindo: o reduce pega uma lista de coisas e vai juntando tudo em um só resultado
        // Caso um dos salários seja nulo vai retornar BigDecimal.ZERO
        final var salariesTotal = employees.stream()
                .map(employee -> employee.salary() == null ? BigDecimal.ZERO : employee.salary())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total de salários: " + salariesTotal);

        // Outra forma de fazer a mesma coisa, mas sem o operador ternário
        final var salariesTotal2 = employees.stream()
                .map(Employee::salary)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total de salários (outra forma de fazer): " + salariesTotal2);

        // Soma o total de salários dos funcionários do departamento de RH
        // Aqui já estou considerando que o salário não é nulo
        final var salariesRHTotal = employees.stream()
                .filter(employee -> employee.department().equals("RH"))
                .map(Employee::salary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total de salários do RH: " + salariesRHTotal);

        // Verifica se existe algum funcionário no departamento de Informática
        final var containsEmployeeInformatica = employees.stream()
                .anyMatch(employee -> employee.department().equals("Informática"));
        System.out.println("Existe funcionário no departamento de Informática? " + containsEmployeeInformatica);

        // Cria uma nova lista somente com os funcionários do departamento de Contabilidade
        final var employeeContabilidade = employees.stream().filter(employee -> employee.department().equals("Contabilidade"))
                .toList();
        employeeContabilidade.forEach(System.out::println);

        final var quantityZecas = employees.stream()
                .filter(employee -> employee.name().equals("Zeca"))
                .count();
        System.out.println("Quantidade de Zecas: " + quantityZecas);

        // Cria uma nova lista somente com os funcionários chamados Zeca, mas sem repetição
        // Outra forma de criar lista usando Collectors.toList()
        final var justOneZeca = employees.stream()
                .filter(employee -> employee.name().equals("Zeca"))
                .distinct().collect(Collectors.toList());
        justOneZeca.forEach(System.out::println);

        // parei aos 31:04 do vídeo 1
    }

    private List<Employee> createEmployees() {
        final List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Daniel", LocalDate.of(2023, 11, 18), null, "Informática"));
        employees.add(new Employee("Zeca", LocalDate.of(2011, 3, 28), new BigDecimal(8600), "Contabilidade"));
        employees.add(new Employee("Vinicius", LocalDate.of(2000, 6, 10), new BigDecimal(9200), "RH"));
        employees.add(new Employee("Henrique", LocalDate.of(2013, 2, 14), new BigDecimal(4000), "Faturamento"));
        employees.add(new Employee("João", LocalDate.of(2022, 11, 5), new BigDecimal(3500), "Faturamento"));
        employees.add(new Employee("Carla", LocalDate.of(2005, 1, 10), new BigDecimal(1500), "Informática"));
        employees.add(new Employee("Zeca", LocalDate.of(2010, 11, 7), new BigDecimal(1500), "Informática"));
        employees.add(new Employee("Thiago", LocalDate.of(2019, 1, 7), new BigDecimal(2500), "RH"));
        employees.add(new Employee("Alice", LocalDate.of(2017, 3, 30), new BigDecimal(4500), "Contabilidade"));
        employees.add(new Employee("Yasmin", LocalDate.of(2010, 12, 30), new BigDecimal(4500), "Informática"));
        employees.add(new Employee("Vinicius", LocalDate.of(2008, 5, 28), new BigDecimal(2500), "Faturamento"));
        employees.add(new Employee("Mariana", LocalDate.of(2022, 11, 25), new BigDecimal(1500), "Informática"));
        employees.add(new Employee("Zeca", LocalDate.of(2018, 11, 2), new BigDecimal(4000), "Contabilidade"));
        employees.add(new Employee("Nicolas", LocalDate.of(2016, 10, 17), new BigDecimal(2500), "Faturamento"));
        employees.add(new Employee("Lucas", LocalDate.of(2014, 11, 21), new BigDecimal(4000), "Faturamento"));
        employees.add(new Employee("Karen", LocalDate.of(2018, 8, 12), new BigDecimal(4000), "Faturamento"));
        employees.add(new Employee("Karen", LocalDate.of(2008, 2, 26), new BigDecimal(3500), "Informática"));
        employees.add(new Employee("Mariana", LocalDate.of(2001, 3, 30), new BigDecimal(3000), "RH"));
        employees.add(new Employee("William", LocalDate.of(2002, 10, 28), new BigDecimal(2000), "Contabilidade"));
        employees.add(new Employee("Eduarda", LocalDate.of(2003, 2, 25), new BigDecimal(2500), "RH"));

        return employees;
    }

    public static void main(String[] args) {
        new Application();
    }
}