package src;

/**
 *Klasse um die Anzahl der Bälle, sowie den Spielscore wiedergibt
 * @Author Tjark Jansen
 * @Author Sehri Singh
 */
public class GameLogic {
    private int ballCount;
    private int score;

    /**
     * Konstruktor Methode
     * @param ballCount Anzahl der noch verfügbaren Bälle
     * @param score Anzahl der verdienten Punkte
     */
    public GameLogic(int ballCount, int score){
        this.ballCount = ballCount;
        this.score = score;
    }
}
