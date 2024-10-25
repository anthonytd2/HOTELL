package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

  
    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    
    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
        atualizarDisponibilidade(reserva.getTipoQuarto(), false);
    }

   
    public void checkIn(int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            quarto.setDisponivel(false);
            System.out.println("Check-in realizado para o quarto " + numeroQuarto);
        } else {
            System.out.println("Quarto não disponível para check-in.");
        }
    }

   
    public void checkOut(int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null && !quarto.isDisponivel()) {
            quarto.setDisponivel(true);
            System.out.println("Check-out realizado para o quarto " + numeroQuarto);
        } else {
            System.out.println("Quarto já está disponível ou não encontrado.");
        }
    }

   
    private Quarto buscarQuarto(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }

  
    public void relatorioOcupacao() {
        System.out.println("\n--- Relatório de Ocupação ---");
        for (Quarto quarto : quartos) {
            String status = quarto.isDisponivel() ? "Disponível" : "Ocupado";
            System.out.println("Quarto " + quarto.getNumero() + " - " + quarto.getTipo() + " | " + status);
        }
    }

   
    public void historicoReservasPorHospede(String nomeHospede) {
        List<Reserva> reservasHospede = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                reservasHospede.add(reserva);
            }
        }

        if (reservasHospede.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada para o hóspede: " + nomeHospede);
        } else {
            System.out.println("\n--- Histórico de Reservas de " + nomeHospede + " ---");
            for (Reserva reserva : reservasHospede) {
                System.out.println(reserva);
            }
        }
    }

   
    private void atualizarDisponibilidade(String tipoQuarto, boolean disponivel) {
        for (Quarto quarto : quartos) {
            if (quarto.getTipo().equalsIgnoreCase(tipoQuarto) && quarto.isDisponivel() == !disponivel) {
                quarto.setDisponivel(disponivel);
                break;
            }
        }
    }
}
