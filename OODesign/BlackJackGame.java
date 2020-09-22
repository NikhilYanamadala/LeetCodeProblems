package OODesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

enum Suit {
    DIAMONDS, HEARTS, CLUBS, TREES
}

enum Point {
    C_ACE_1, C_2, C_3, C_4, C_5, C_6, C_7, C_8, C_9, C_10, C_JACK, C_QUEEN, C_KING
}

class Card {
    public static final int FIRST_SUIT_ORDINAL = 10;
    private Suit suit;
    private Point point;

    Card(Suit s, Point point) {
        this.suit = s;
        this.point = point;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getPoints() {
        if (getPoint().ordinal() <= Point.C_10.ordinal()) {
            return getPoint().ordinal() + 1;
        } else
            return 10;
    }
}

abstract class BLPlayer {
    private String name;
    private List<Card> hand = new ArrayList<>();

    abstract boolean canPlay();

    abstract boolean wantToPlay();

    public BLPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPoints() {
        int minTotal = 0;
        int maxTotal = 0;
        for (Card c : hand) {
            int points = c.getPoints();
            minTotal += points;
            maxTotal += c.getPoint() == Point.C_ACE_1 ? 11 : points;
        }
        return maxTotal > 21 ? minTotal : maxTotal;
    }

    public void addCard(Card c) {
        hand.add(c);
    }
}

class BlackJackPlayer extends BLPlayer {
    public BlackJackPlayer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints() < 21;
    }

    @Override
    boolean wantToPlay() {
        return getTotalPoints() < 17;
    }
}

class Dealer extends BLPlayer {
    public Dealer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints() < 21;
    }

    @Override
    boolean wantToPlay() {
        return true;
    }
}

class Deck {
    public List<Card> cards = new ArrayList<>();

    Deck() {
        createDeck();
        shuffleCards();
    }

    public void createDeck() {
        for (Suit s : Suit.values()) {
            for (Point p : Point.values()) {
                cards.add(new Card(s, p));
            }
        }
    }
    public void shuffleCards(){
        Collections.shuffle(cards);
    }
    public Card removeOneCard(){
        if(cards.isEmpty()){
            System.out.println("Exception");
        }
        return cards.remove(cards.size()-1);
    }
}

class BLMove {
    private BLPlayer person;
    private Card card;

    public BLPlayer getPerson() {
        return person;
    }

    public void setPerson(BLPlayer person) {
        this.person = person;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BLMove(BLPlayer player, Card card) {
        this.person = player;
        this.card = card;
    }
}

public class BlackJackGame {
    private BLPlayer player = null;
    private BLPlayer dealer = new Dealer("Steve");
    private Deck deckOfCards = new Deck();
    private List<BLMove> moves = new ArrayList<>();
    private Card hiddenDealerCard = null;
    public BlackJackGame(String playerName){
        this.player = new BlackJackPlayer(playerName);
    }

    public void play(){
        // the first dealer card
        hiddenDealerCard = deckOfCards.removeOneCard();

        // give a card to each player
        giveNewCard(dealer);
        giveNewCard(player);

        // let the player play as long as he wants and we are not over
        while (player.canPlay() && player.wantToPlay() && !gameEnded()) {
            giveNewCard(player);
        }

        // if the player did not get over (and the game ended), let the dealer play
        if (!gameEnded()) {
            // first, turn the hidden card
            giveCard(dealer, hiddenDealerCard);
            // then play until either wins
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        // show who won
        showWinner();
    }
    public void giveNewCard(BLPlayer player){
        giveCard(player,deckOfCards.removeOneCard());
    }
    public void giveCard(BLPlayer p,Card c){
        BLMove m = new BLMove(p,c);
        moves.add(m);
        p.addCard(m.getCard());

    }
    public boolean gameEnded(){
        if(player.getTotalPoints()>21){
            return true;
        }else if(dealer.getTotalPoints()>21){
            return true;
        }
        return false;
    }
    public void showWinner(){
        if(player.getTotalPoints()>21){
            System.out.println("player lost");
        }else if(dealer.getTotalPoints()>21){
            System.out.println("Dealer Lost");
        }else {
            BLPlayer winner = player.getTotalPoints() > dealer.getTotalPoints()?player:dealer;
            System.out.println(winner.getName()+"Points:"+winner.getTotalPoints());
        }
    }

    public static void main(String[] args) {
        BlackJackGame b= new BlackJackGame("Nikhil");
        b.play();
    }
}
