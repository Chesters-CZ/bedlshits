import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Main.begin();
        Scanner scanner = new Scanner(System.in);
        int result = 2;
        while (result == 2) {
            System.out.println("hrac 0 hraje");
            System.out.println("vyber x utoku");
            int x = scanner.nextInt();
            System.out.println("vyber y utoku");
            int y = scanner.nextInt();
            map.fajr(x, y, false);

            System.out.println("hrac 1 hraje");
            System.out.println("vyber x utoku");
            x = scanner.nextInt();
            System.out.println("vyber y utoku");
            y = scanner.nextInt();
            map.fajr(x, y, true);

            result = map.isWon();
            System.out.println("result: " + result);
        }

        switch (result){
            case 0:
                System.out.println("player 0 won, congrats!");
                break;
            case 1:
                System.out.println("player 1 won, congrats!");
                break;
            case 3:
                System.out.println("oops, i forgot!");
                System.out.println("player 0 won one turn ago, congrats!");
                break;
        }
    }

    public static void begin() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jak velky pole chces? Minimum je 10");
        int velky = scanner.nextInt();
        if (velky < 10) {
            throw new Exception("Debilku, zadals moc maly pole!");
        }
        System.out.println("Vyborne. Od kazdyho typu lode budete kazdej mit k dispozici 1 aby se to veslo.");
        map.create(velky, 0, 0, 0, 0, 1);
    }
}
