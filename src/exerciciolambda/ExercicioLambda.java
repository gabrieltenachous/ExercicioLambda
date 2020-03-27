package exerciciolambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ExercicioLambda {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        System.out.println("Entre com o caminho:");
        String path = scanf.next();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.println("Entre com o salario");
            double salary = scanf.nextDouble();
            // Entrar com o salario e mostrara
            //o email da pessoa em ordem alfabetica
            List<String> emails = list.stream().
                    filter(x -> x.getSalario() > salary)
                    .map(x -> x.getEmail())
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println("Email da pessoa com salario maior de: " + String.format("%.2f", salary) + ":");
            emails.forEach(System.out::println);

            double somatoriaM = list.stream()
                    .filter(x -> x.getName().charAt(0) == 'M')
                    .map(x -> x.getSalario())
                    .reduce(0.0, (x,y) -> x+y);
            
            System.out.println("Somatoria de todas as palavras que começam com 'M':"+ somatoriaM);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
