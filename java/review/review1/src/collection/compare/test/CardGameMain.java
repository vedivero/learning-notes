package collection.compare.test;

public class CardGameMain {

    public static void main(String[] args) {

        Deck deck = new Deck();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        for (int i = 0; i < 5; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        player1.showHand();
        player2.showHand();

        getWinner(player1, player2);
    }

    private static Player getWinner(Player player1, Player player2) {
        int sum1 = player1.rankSum();
        int sum2 = player2.rankSum();

        if (sum1 > sum2) {
            return player1;
        } else if (sum1 == sum2) {
            return null;
        } else {
            return player2;
        }
    }
}
