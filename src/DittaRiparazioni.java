import java.util.ArrayList;
import java.util.Arrays;

public class DittaRiparazioni {
    /*
    Progettare quindi una classe DittaRiparazioni, che contiene un insieme di tecnici, che gestisce le seguenti funzioni:

    mandare in ferie un insieme di tecnici (identificati per nome)

    marcare una riparazione come conclusa (può essere identificata dal nome del tecnico che la sta effettuando)
    assegnare una riparazione ad un tecnico
    ottenere la prossima riparazione con la maggior priorità
    ottenere la lista delle riparazioni in attesa
    aggiungere una nuova riparazione da fare
    aggiungere un tecnico alla ditta
     */
    private ArrayList<Tecnico> listTecnici;
    private ArrayList<Riparazione> listRip;
    private Tecnico[] arrTec;

    public DittaRiparazioni() {
        listTecnici = new ArrayList<>();
        listRip = new ArrayList<>();
        arrTec = new Tecnico[1];
    }

    //ottenere la lista delle riparazioni in attesa
    public void listaRipDaFare() {
        System.out.println("Elenco riparazioni da fare: ");
        for (Riparazione rip : listRip) {
            if (rip.getStato() == 0)
                System.out.println(rip);
        }
    }

    //aggiungere una nuova riparazione da fare
    public void addRiparazione(Riparazione riparazione) {
        listRip.add(riparazione);
    }

    public ArrayList<Tecnico> getListTecnici() {
        return listTecnici;
    }

    public ArrayList<Riparazione> getListRip() {
        return listRip;
    }

    public void addRiparazione() {
        Utilities.sc.nextLine();
        String indirizzo = "";
        System.out.println("Inserisci indirizzo Riparazione: ");
        indirizzo = Utilities.sc.nextLine();
        int priorita = 0;
        while (priorita < 1 || priorita > 5) {
            System.out.println("Inserisci priorita' riparazione (1-5): ");
            priorita = Utilities.sc.nextInt();
            //Utilities.sc.nextLine();
        }
        Riparazione rip = new Riparazione(indirizzo, priorita);
        listRip.add(rip);
    }
    //
    public boolean addTecnico(String nome){
        for(Tecnico t : listTecnici){
            if(t.getNome().equals(nome)){
                System.out.println("Nome gia' presente");
                return false;
            }
        }
        return listTecnici.add(new Tecnico(nome));

    }

    /*private boolean addTecnico(Tecnico tecnico) {//aggiungere un tecnico alla ditta
        return listTecnici.add(tecnico);
        //Tecnico[] tmp = arrTec.clone();
        /*arrTec = new Tecnico[arrTec.length + 1];
        arrTec[arrTec.length - 1] = tecnico;
    }*/

    //ottenere la prossima riparazione con la maggior priorità
    public Riparazione getMaxPrior() {
        int m = -1;
        Riparazione tmpRip = null;
        for (Riparazione rip : listRip) {
            if (rip.getPriorita() > m && rip.getStato() == 0) {
                m = rip.getPriorita();
                tmpRip = rip;
            }
        }
        return tmpRip;
    }

    //assegnare una riparazione ad un tecnico
    public void assegnaRip(Riparazione riparazione, Tecnico tecnico) {
        riparazione.setTecnico(tecnico);
        riparazione.setStato(Riparazione.Stato.INCORSO);
    }

    public void assegnaRip(Tecnico tecnico) {//se voglio creare una riparazione e assegnare il tecnico
        addRiparazione();
        Riparazione rip = listRip.get(listRip.size() - 1);
        assegnaRip(rip, tecnico);
        rip.setStato(Riparazione.Stato.INCORSO);
    }

    //
    //marcare una riparazione come conclusa (può essere identificata dal nome del tecnico che la sta effettuando)
    public boolean fineRiparazione(String nome) {
        for (Riparazione r : listRip) {
            if (r.getTecnico() != null && r.getTecnico().getNome().equals(nome)) {
                r.setStato(Riparazione.Stato.COMPLETATA);
                return true;
            }
        }
        return false;
    }
    /*public void mandaInFerie(Tecnico tecnico){
        tecnico.setInFerie(true);
    }*/
    public boolean fineRiparazione(Riparazione riparazione) {
        riparazione.setStato(Riparazione.Stato.COMPLETATA);
        return true;
    }
}
