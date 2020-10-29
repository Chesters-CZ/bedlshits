import java.util.*;

public class map {
    public static tileType[][] mapka;

    public static void create(int size, int cars, int bats, int dests, int subs, int pats) throws Exception {
        mapka = new tileType[size][size];
        for (int i = 0; i < mapka.length; i++) {
            for (int i1 = 0; i1 < mapka[i].length; i1++) {
                mapka[i][i1] = tileType.WATER;
            }
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cars; i++) {
            System.out.println("Hrac 0 zada pozici x sveho " + i + ". carriera");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sveho " + i + ". carriera");
            int y = scanner.nextInt();
            try {
                addShit(type.size.CARRIER, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". carriera");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". carriera");
            y = scanner.nextInt();
            try {
                addShit(type.size.CARRIER, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        for (int i = 0; i < bats; i++) {
            System.out.println("Hrac 0 zada pozici x sveho " + i + ". battleshipu");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sveho " + i + ". battleshipu");
            int y = scanner.nextInt();
            try {
                addShit(type.size.BATTLESHIP, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". battleshipu");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". battleshipu");
            y = scanner.nextInt();
            try {
                addShit(type.size.BATTLESHIP, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        for (int i = 0; i < dests; i++) {
            System.out.println("Hrac 0 zada pozici x sveho " + i + ". destroyera");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sveho " + i + ". destroyera");
            int y = scanner.nextInt();
            try {
                addShit(type.size.DESTROYER, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". destroyera");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". destroyera");
            y = scanner.nextInt();
            try {
                addShit(type.size.DESTROYER, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        for (int i = 0; i < subs; i++) {
            System.out.println("Hrac 0 zada pozici x sve " + i + ". submariny");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sve " + i + ". submariny");
            int y = scanner.nextInt();
            try {
                addShit(type.size.SUBMARINE, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sve " + i + ". submariny");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sve " + i + ". submariny");
            y = scanner.nextInt();
            try {
                addShit(type.size.SUBMARINE, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
        for (int i = 0; i < pats; i++) {
            System.out.println("Hrac 0 zada pozici x sveho " + i + ". patrolu");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sveho " + i + ". patrolu");
            int y = scanner.nextInt();
            try {
                addShit(type.size.PATROL, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". patrolu");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". patrolu");
            y = scanner.nextInt();
            try {
                addShit(type.size.PATROL, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }

    public static void addShit(type.size val, int posx, int posy, boolean tym) throws Exception {
        if (map.mapka[posx][posy] != tileType.WATER) {
            throw new Exception("Tam uz neco je.");
        }
        int velkostLode;
        switch (val) {
            case CARRIER:
                velkostLode = 5;
                break;
            case BATTLESHIP:
                velkostLode = 4;
                break;
            case DESTROYER:
            case SUBMARINE:
                velkostLode = 3;
                break;
            case PATROL:
                velkostLode = 2;
                break;
            default:
                throw new Exception("ship type not specified");
        }
        for (int i = 0; i <= velkostLode; i++) {
            if (map.mapka[posx + i][posy] == tileType.WATER) {
                if (tym) {
                    map.mapka[posx + i][posy] = tileType.SHIPTRUE;
                } else {
                    map.mapka[posx + i][posy] = tileType.SHIPFALSE;
                }

            } else {
                throw new Exception("tam uz neco je");
            }
        }
    }

    public static void fajr(int posx, int posy, boolean attecker) throws Exception {
        if (attecker) {
            if (map.mapka[posx][posy] == tileType.SHIPFALSE) {
                map.mapka[posx][posy] = tileType.HIT;
            } else if (map.mapka[posx][posy] == tileType.WATER) {
                map.mapka[posx][posy] = tileType.MISS;
            } else {
                throw new Exception("invalidni target");
            }
        } else {
            if (map.mapka[posx][posy] == tileType.SHIPTRUE) {
                map.mapka[posx][posy] = tileType.HIT;
            } else if (map.mapka[posx][posy] == tileType.WATER) {
                map.mapka[posx][posy] = tileType.MISS;
            } else {
                throw new Exception("invalidni target");
            }
        }
        System.out.println(map.mapka[posx][posy]);
        System.out.println(posx+ " xx " + posy + " xx " + attecker);
    }

    public static int isWon() throws Exception {         // 0=player0 won, 1=player1 won, 2=nobody won, 3=no ships found
        int plr0 = 0;
        int plr1 = 0;
        for (int i = 0; i < mapka.length; i++) {
            for (int i1 = 0; i1 < mapka[i].length; i1++) {
                if (mapka[i][i1] == tileType.SHIPTRUE) {
                    plr1++;
                } else if (mapka[i][i1] == tileType.SHIPFALSE) {
                    plr0++;
                }
            }
        }

        System.out.println("plr0 " + plr0 + " and plr1 " + plr1);

        if (plr0 > 0 && plr1 > 0) {
            return 2;
        } else if (plr1 > 0) {
            return 1;
        } else if (plr0 > 0) {
            return 0;
        } else {
            return 3;
        }
    }
}
