package br.com.posjava.datatime;

import br.com.posjava.collections.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public Application() {
        test();
    }

    public void test() {
        final var employees = createEmployees();
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
