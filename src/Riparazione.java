public class Riparazione {
    private String indirizzo;
    private int priorita;
    private Tecnico tecnico;

    public enum Stato {
        DAFARE(0), INCORSO(1), COMPLETATA(2);
        private int n;

        Stato(int n) {
            this.n = n;
        }

        public int toInt() {
            return n;
        }
    }

    ;
    private Stato stato;

    public Riparazione(String indirizzo, int priorita) {
        this.indirizzo = indirizzo;
        this.priorita = priorita;
        this.stato = Stato.DAFARE;
        this.tecnico = null;
    }

    public Riparazione(String indirizzo, int priorita, Tecnico tecnico) {
        this.indirizzo = indirizzo;
        this.priorita = priorita;
        this.tecnico = tecnico;
        this.stato = Stato.INCORSO;
    }

    public int getStato() {
        return stato.toInt();
    }

    public int getPriorita() {
        return priorita;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public String toString() {
        if(tecnico!=null)
            return "Riparazione indirizzo: " + indirizzo + " tecnico: " + tecnico + " Priorita': " + priorita + ", Stato: " + stato;
        else
            return "Riparazione indirizzo: " + indirizzo + " tecnico: Non assegnato, " + " Priorita': " + priorita + ", Stato: " + stato;
    }
}
