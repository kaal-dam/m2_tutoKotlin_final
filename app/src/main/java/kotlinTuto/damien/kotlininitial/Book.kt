package kotlinTuto.damien.kotlininitial

data class Book(val title: String = "un autre exemple",val auteur: String = "n'a pas d'auteur",val resumer: String = "n'a pas de résumé")

/*
public class Book{
    private String title;
    private String auteur;
    private String resumer;

    public Book(String title,String auteur, String resumer){
        this.title=title;
        this.auteur=auteur;
        this.resumer=resumer;
    }

    public Book(String title,String auteur){
        this.title=title;
        this.auteur=auteur;
        this.resumer="n'a pas de résumé";
    }

    public Book(String title, String resumer){
        this.title=title;
        this.auteur="n'a pas d'auteur";
        this.resumer=resumer;
    }

    public Book(String auteur, String resumer){
        this.title="un autre exemple";
        this.auteur=auteur;
        this.resumer=resumer;
    }
     public Book(String auteur){
        this.title=title;
        this.auteur=auteur;
        this.resumer="n'a pas de résumé";
    }
     public Book(String resumer){
        this.title=un autre exemple";
        this.auteur="n'a pas d'auteur";
        this.resumer=resumer;
    }
     public Book(String title){
        this.title=title;
        this.auteur="n'a pas d'auteur";
        this.resumer="n'a pas de résumé";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book Book = (Book) o;

        if (!getTitle().equals(Book.getTitle())) return false;
        if (!getAuteur().equals(Book.getAuteur())) return false;
        return getResumer().equals(Book.getResumer());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAuteur().hashCode();
        result = 31 * result + getResumer().hashCode();
        return result;
    }

    public String getTitle() {
    
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResumer() {
        return resumer;
    }

    public void setResumer(String resumer) {
        this.resumer = resumer;
    }
}
 */