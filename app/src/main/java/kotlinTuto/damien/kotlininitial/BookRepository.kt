package kotlinTuto.damien.kotlininitial

/*
public class BookRepository(){

    public static BookRepository singleton=null;

    public void getInstance(){
        if (singleton == null) {
            synchronized(BookRepository.class) {
                if (BookRepository.singleton == null) {
                    try {
                        BookRepository.singleton = new BookRepository() ;
                    } catch (LoadingSettingsException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return singleton;
    }

    public void initialize(){...}
    public void ...

}
 */


object BookRepository {

    private val listLivre: MutableList<Book> = mutableListOf()
    private var initialized = false

    fun initialize() {
        if (!initialized) {
            var title = "Harry Potter et la Chambre des Secrets"
            var auteur = "J. K. Rowling"
            var resumer = "Harry Potter fait une deuxième rentrée fracassante en voiture volante à l'école des sorciers. Cette deuxième année ne s'annonce pas de tout repos… surtout depuis qu'une étrange malédiction s'est abattue sur les élèves. Entre les cours de potion magique, les matchs de quidditch et les combats de mauvais sorts, Harry trouvera-t-il le temps de percer le mystère de la Chambre des Secrets? Un livre magique pour sorciers et sorcières confirmés!"
            var livre = Book(title, auteur, resumer)
            listLivre.add(livre)

            title = "La tour des Anges"
            auteur = "PHILIP PULLMAN"
            resumer = "Le jeune Will, à la recherche de son père disparu depuis de longues années, croit avoir tué un homme. Dans sa fuite, il franchit la brèche qui lui permet de passer dans un monde parallèle. Là, à Cittàgazze, la ville au-delà de l'Aurore, il rencontre Lyra. Les deux enfants devront lutter contre les forces obscures du mal et, pour accomplir leur quête, pénétrer dans la mystérieuse Tour des Anges..."
            livre = Book(title, auteur, resumer)
            listLivre.add(livre)

            title = "un exemple spécial"
            livre = Book(title)
            listLivre.add(livre)

            auteur = "damien"
            livre = Book(auteur = auteur)
            listLivre.add(livre)

            title = "LÉGENDE"
            auteur = "David GEMMELL"
            resumer = "Druss est une légende.\n" +
                    "Ses exploits sont connus de tous. Mais au lieu de la richesse et de la célébrité, il a choisi de vivre retiré loin des hommes, au sommet d'une montagne, avec pour seuls compagnons quelques léopards des neiges. Là, le vieux guerrier attend son ennemi de toujours, la mort.\n" +
                    "Dros Delnoch est une forteresse.\n" +
                    "C'est le seul endroit par lequel une armée peut traverser les montagnes. Protégée par six remparts, elle était la place forte de l'Empire drenaï. C'est maintenant leur dernier bastion, car tous les autres sont tombés devant l'envahisseur Nadir."
            livre = Book(title, auteur, resumer)
            listLivre.add(livre)
            initialized = true
        }
    }

/*public List<Sting> getAllTitle(){
        List<String> res = new ArrayList<>();
        for(Book b : listLivre){
            res.add(b.getTitle());
        }
        return res;
}*/

    fun getAllTitle(): List<String> {
        return listLivre.map { book: Book -> book.title }
    }



/*public Book getByTitle(String title){
    for (Book b: listLivre){
        if (b.title.equals(title))
            return book;
    };
}*/

    fun getByTitle(title:String):Book? = listLivre.find { book:Book -> book.title.equals(title) }
}