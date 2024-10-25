package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private String nomeHospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroQuartos;
    private String tipoQuarto;

    public Reserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, 
                   int numeroQuartos, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartos = numeroQuartos;
        this.tipoQuarto = tipoQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    
    public long getPeriodoOcupacao() {
        return ChronoUnit.DAYS.between(dataCheckIn, dataCheckOut);
    }

    
    public String toString() {
        return "Reserva de " + nomeHospede + ": " + numeroQuartos + " quarto(s) tipo " + tipoQuarto +
               " | Check-in: " + dataCheckIn + " | Check-out: " + dataCheckOut +
               " | Período: " + getPeriodoOcupacao() + " dia(s)";
    }
}
