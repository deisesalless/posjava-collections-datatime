package br.com.posjava.datatime;

import br.com.posjava.collections.Employee;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Application {
    public Application() {
        test();
    }

    public void test() {
        final var employees = createEmployees();

        // Data completa no formato full
        // [dia da semana, dia do mês, mês, ano, hora, minuto, segundo, fuso horário]
        final var currentDate1 = new Date();
        System.out.println("Data atual com Date: " + currentDate1);

        // Data em formato enxuto yyyy-MM-dd
        final var currentDate2 = LocalDate.now();
        System.out.println("Data atual com LocalDate: " + currentDate2);

        // Data completa com time zone
        final var currentDate3 = ZonedDateTime.now();
        System.out.println("Data atual com ZonedDateTime: " + currentDate3);

        final var currentDate4 = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Fuso horário do Brasil(" + currentDate4.getZone() + "): " + currentDate4.getOffset());

        final var currentDate5 = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        System.out.println("Fuso horário da Espanha(" + currentDate5.getZone() + "): " + currentDate5.getOffset());

        // Adicionando 4 dias na data atual
        final var newDate1 = LocalDate.now().plusDays(4);
        System.out.println("Data atual mais 4 dias: " + newDate1);

        // Adicionando 4 dias na data atual e alterando o mês para abril e a hora para 00:05
        final var newDate2 = LocalDate.now().plusDays(4).withMonth(4).atTime(0,5);
        System.out.println("Data atual alterada: " + newDate2);

        // Retorna uma data em formato full
        final var specificDate = new GregorianCalendar(2021, Calendar.JANUARY, 25).getTime();
        System.out.println("Data específica com GregorianCalendar: " + specificDate);

        final var enumMonth = LocalDate.now().getMonth();
        System.out.println("Mês atual em enum: " + enumMonth + " - " + enumMonth.getValue());

        // Horario atual com horas e minutos - truncatedTo eu determino o delimitador, então ele mostra até o minuto
        final var actualTime = LocalTime.now();
        System.out.println("Hora atual: " + actualTime.truncatedTo(ChronoUnit.MINUTES));

        // Combinando data e hora
        final var combinedDateTime = LocalDateTime.of(currentDate2, actualTime);
        System.out.println("Data e hora combinadas: " + combinedDateTime);

        // Descobrir a diferença entre duas datas em dias
        final var pastDate = LocalDate.of(1995, 8, 31);
        final var daysBetween = ChronoUnit.DAYS.between(pastDate, LocalDate.now());
        System.out.println("Se passaram " + daysBetween + " dias desde " + pastDate);

        // Descobrir a diferença entre duas datas em anos
        final var yearsBetween = ChronoUnit.YEARS.between(pastDate, LocalDate.now());
        System.out.println("Se passaram " + yearsBetween + " anos desde " + pastDate);

        // Descobrir a diferença entre duas datas em meses
        final var monthsBetween = ChronoUnit.MONTHS.between(pastDate, LocalDate.now());
        System.out.println("Se passaram " + monthsBetween + " meses desde " + pastDate);

        // Descobrir a diferença entre duas datas anos, meses e dias
        final var periodBetween = Period.between(pastDate, LocalDate.now());
        System.out.println("Se passaram " + periodBetween.getYears() + " anos, " + periodBetween.getMonths() +
                " meses e " + periodBetween.getDays() + " dias desde " + pastDate);

        // Usando a API antiga
        final var calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 10); // Adiciona 10 horas na data atual
        System.out.println("Data atual mais 10 horas com Calendar: " + calendar.getTime());

        // Usando a API nova + truncatedTo para limitar a exibição até os segundos
        final var future = LocalDateTime.now().plusHours(10);
        System.out.println("Data atual mais 10 horas com LocalDateTime: " + future.truncatedTo(ChronoUnit.SECONDS));

        // Disponivel desde o Java 1 - API antiga - não é thread safe
        final var formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final var formattedDate = formatter.format(new Date());
        System.out.println("Data formatada com SimpleDateFormat: " + formattedDate);

        // Disponivel desde o Java 8 - API moderna - thread safe
        final var formatter2 =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate2 = formatter2.format(LocalDateTime.now());
        System.out.println("Data formatada com DateTimeFormatter: " + formattedDate2);

        // Convertendo String para LocalDate
        // Precisa passar como argumento a data em String e o formatador utilizado
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDate2, formatter2);
        System.out.println("String convertida para LocalDateTime: " + localDateTime);

        final var nowTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        System.out.println("Hora atual formatada: " + nowTime);

        // Instant - representa um instante na linha do tempo (data e hora) com precisão de nanossegundos
        // Muito seguro quando preciso utilizar em Time Zones ou aplicações muito robustas
        // No banco é gravado como Long, então é mais leve para guardar
        // Porém para consumir é necessário converter para LocalDateTime principalmente se for exibir para o usuário
        final var instant = Instant.now();
        System.out.println("Instante atual: " + instant);
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
