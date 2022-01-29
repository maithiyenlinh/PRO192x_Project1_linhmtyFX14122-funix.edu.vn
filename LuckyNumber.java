import java.util.Scanner;

public class LuckyNumber {
    public static Scanner sc = new Scanner(System.in);
    public static final int MAX_NUMBER = 100;
    public static void main (String[] args) {
        String decideUser;
        int countPlayTimes = 0, guessedTimes = 0;
        int bestGame = Integer.MAX_VALUE;
        // one loop is a round game, and loop will stop when the user don't want play more
        do {
            countPlayTimes++;
            int luckyNumber = (int) Math.floor(Math.random() * MAX_NUMBER);
            System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến " + MAX_NUMBER + "...");
            System.out.println();
            // get the number of guesses each round and find the minimum number of guesses
            int guessedTotal = play(luckyNumber);
            if (guessedTotal <= bestGame) {
                bestGame = guessedTotal;
            };
            guessedTimes += guessedTotal;
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            decideUser = sc.next();
            System.out.println();
        } while (decideUser.equalsIgnoreCase("y") || decideUser.equalsIgnoreCase("yes"));
        report(countPlayTimes, guessedTimes, bestGame);
    }

    // handle the guesing number game, the method will return total guess in round game
    public static int play(int luckyNumber) {
        int guessedNumber;
        int countGuessedTime = 0;
        do {
            countGuessedTime++;
            System.out.print("Bạn đoán? ");
            guessedNumber = sc.nextInt();
            // handle guesing from user 
            if (guessedNumber > luckyNumber) {
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn");
            } else if (guessedNumber < luckyNumber) {
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn");
            } else {
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + countGuessedTime + " lân dự đoán");
            };
        } while (guessedNumber != luckyNumber);

        return countGuessedTime;
    }

    // handle printing the report: 
    // total rounds game, Total guessing, the average number of guesses, minimum number of guessses
    public static void report(int totalGames, int totalGuess, int bestGame) {
        System.out.println("Kết quả tổng quát của trò chơi: ");
        System.out.println("Tổng số lần chơi = " + totalGames);
        System.out.println("Tổng số lần dự đoán = " + totalGuess);
        double avgGuess = (double) totalGuess / totalGames;
        System.out.println("Số lần dự đoán trung bình mỗi lượt = " + String.format("%.1f", avgGuess));
        System.out.println("Số lần dự đoán ít nhất = " + bestGame);
    }
}