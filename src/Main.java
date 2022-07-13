import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    /*Ditta di Riparazioni
Una ditta di riparazioni di caldaie vuole gestire gli interventi a domicilio. Progettare una classe Riparazione,
che contiene l'indirizzo a cui recarsi, la priorità dell'intervento (es. un intero). Progettare una classe Tecnico,
che rappresenta il tecnico che si occuperà della riparazione.

Progettare quindi una classe DittaRiparazioni, che contiene un insieme di tecnici, che gestisce le seguenti funzioni:
aggiungere una nuova riparazione da fare
ottenere la lista delle riparazioni in attesa
ottenere la prossima riparazione con la maggior priorità
assegnare una riparazione ad un tecnico
marcare una riparazione come conclusa (può essere identificata dal nome del tecnico che la sta effettuando)
aggiungere un tecnico alla ditta
mandare in ferie un insieme di tecnici (identificati per nome)
note:

dato che i tencici sono identificati per nome, non devono poter esistere due tecnici con lo stesso nome
non bisogna assegnare la stessa riparazione a due tecnici
*/
    public static void main(String[] args) {
        DittaRiparazioni ditta = new DittaRiparazioni();
        boolean flag = true;
        int scelta;
        while (flag) {
            scelta = 0;
            while (scelta < 1 || scelta > 8) {
                System.out.println("Menu:");
                System.out.println("1. Inserisci un tecnico\n2. Inserisci una riparazione da fare\n3. Elenco Riparazioni da fare");
                System.out.println("4. Assega riparazione\n5. Riparazione con maggior priorita'\n6. Marca riparazione conclusa");
                System.out.println("7. Manda in ferie dei tecnici\n8. Esci");
                scelta = Utilities.sc.nextInt();
            }
            switch (scelta) {
                case 1:
                    boolean find = false;
                    Utilities.sc.nextLine();
                    while (!find) {
                        System.out.println("Inserire nome tecnico");
                        String nome = Utilities.sc.nextLine();
                        find = ditta.addTecnico(nome);
                    }
                    break;
                case 4:
                    int n = 0/*, count = 1*/;
                    Tecnico tecnico;
                    n = getNumber(ditta.getListTecnici(), "Seleziona tecnico da assegnare");
                    tecnico = ditta.getListTecnici().get(n - 1);
                    n = 2;
                    while (n != 0 && n != 1) {
                        System.out.println("La riparazione e' gia' presente? 1 per si, 0 per no");
                        n = Utilities.sc.nextInt();
                    }
                    if (n == 1) {
                        int c = getNumber(ditta.getListRip(), "Seleziona riparazione.");
                        //Riparazione rip = ditta.getListRip().get(c - 1);
                        //ditta.assegnaRip(rip, tecnico);
                        ditta.assegnaRip(ditta.getListRip().get(c - 1), tecnico);
                    } else
                        ditta.assegnaRip(tecnico);
                    break;
                case 3:
                    ditta.listaRipDaFare();
                    break;
                case 2:
                    Utilities.sc.nextLine();
                    System.out.println("Inserire indirizzo riparazione: ");
                    String str = Utilities.sc.nextLine();
                    n = 0;
                    while (n < 1 || n > 5) {
                        System.out.println("Inserire priorita (1-5)");
                        n = Utilities.sc.nextInt();
                    }
                    ditta.addRiparazione(new Riparazione(str, n));
                    break;
                case 5:
                    System.out.println(ditta.getMaxPrior());
                    break;
                case 6:
                    for (int i = 0; i < ditta.getListRip().size(); i++)
                        System.out.println(i + ". " + ditta.getListRip().get(i));
                    n = 0;
                    int n1 = -1;
                    while (n1 != 1 && n1 != 2) {
                        System.out.println("Vuoi completare una riparazione cercando per:\n1. Riparazioni\n2. Nome del tecnico");
                        n1 = Utilities.sc.nextInt();
                    }
                    if (n1 == 1) {
                        for(int i = 0; i < ditta.getListRip().size(); i++){
                            if(ditta.getListRip().get(i).getStato()==1)
                                System.out.println((i+1) + ". " + ditta.getListRip().get(i));
                        }
                        while (n < 1 || n > ditta.getListRip().size()) {
                            System.out.println("Seleziona riparazione. Inserire numero corrispondente");
                            n = Utilities.sc.nextInt();
                        }
                        ditta.fineRiparazione(ditta.getListRip().get(n - 1));
                    } else {
                        System.out.println("Inserisci il nome del tecnico");
                        Utilities.sc.nextLine();
                        String nome = Utilities.sc.nextLine();
                        if (ditta.fineRiparazione(nome))
                            System.out.println("Riparazione conclusa!");
                    }
                    break;
                case 7:
                    n = getNumber(ditta.getListTecnici(), "Inserire tecnico da mandare in ferie. ");
                    ditta.getListTecnici().get(n-1).setInFerie(true);
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
    private static int getNumber(ArrayList list, String message){
        int n = -1;
        for(int i = 0; i < list.size(); i++)
            System.out.println((i+1)+". " + list.get(i));
        while(n<0 || n > list.size()) {
            System.out.println(message + " Inserire numero corrispondente");
            n = Utilities.sc.nextInt();
        }
        return n;
    }

}
