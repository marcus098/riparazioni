public class Tecnico {
    private String nome;
    private boolean inFerie;

    public Tecnico(String nome){
        this.nome = nome;
        inFerie = false;
    }

    /*public void setNome(String nome) {
        this.nome = nome;
    }*/

    public String getNome() {
        return nome;
    }

    public boolean isInFerie() {
        return inFerie;
    }

    public void setInFerie(boolean inFerie) {
        this.inFerie = inFerie;
    }

    @Override
    public String toString() {
        return "tecnico: nome " + nome;
    }
}
