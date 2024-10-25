package hotel;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Sistema de Gerenciamento de Hotel ---");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Relatório de Ocupação");
            System.out.println("6. Histórico de Reservas por Hóspede");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Tipo do quarto: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(new Quarto(numero, tipo, preco));
                    break;
                case 2:
                    scanner.nextLine();  
                    System.out.print("Nome do hóspede: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
                    System.out.print("Data de check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());
                    System.out.print("Número de quartos: ");
                    int numQuartos = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Tipo de quarto: ");
                    String tipoReserva = scanner.nextLine();
                    hotel.cadastrarReserva(new Reserva(nome, checkIn, checkOut, numQuartos, tipoReserva));
                    break;
                case 3:
                    System.out.print("Número do quarto para check-in: ");
                    int numCheckIn = scanner.nextInt();
                    hotel.checkIn(numCheckIn);
                    break;
                case 4:
                    System.out.print("Número do quarto para check-out: ");
                    int numCheckOut = scanner.nextInt();
                    hotel.checkOut(numCheckOut);
                    break;
                case 5:
                    hotel.relatorioOcupacao();
                    break;
                case 6:
                    scanner.nextLine();  
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    hotel.historicoReservasPorHospede(nomeHospede);
                    break;
                case 7:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

