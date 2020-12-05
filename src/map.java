import java.util.*;

public class map {


    public tile.type[][] mapka = new tile.type[10][10];
    public tile.shipSize[][] shipSizes;

    public void editmapka(int exks, int wai, tile.type watto){
        mapka[exks][wai] = watto;
    }

    public tile.type readmapka(int exks, int wai){
        return mapka[exks][wai];
    }

    public void editsizes(int exks, int wai, tile.shipSize changeto){
    }
    public tile.shipSize readsizes(int exks, int wai){
        return shipSizes[exks][wai];
    }

    public void create(int size, int cars, int bats, int dests, int subs, int pats) throws Exception {
        for (int i = 0; i < mapka.length; i++) {
            for (int i1 = 0; i1 < mapka[i].length; i1++) {
                new doTile().deklarace(Field.whatdo.CREATE, i, i1, tile.type.WATER, tile.shipSize.NEITHER, false);
            }
        }
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cars; i++) {
            System.out.println("Hrac 0 zada pozici x sveho " + i + ". carriera");
            int x = scanner.nextInt();
            System.out.println("Hrac 0 zada pozici y sveho " + i + ". carriera");
            int y = scanner.nextInt();
            try {
                addShit(tile.shipSize.CARRIER, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". carriera");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". carriera");
            y = scanner.nextInt();
            try {
                addShit(tile.shipSize.CARRIER, x, y, true);
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
                addShit(tile.shipSize.BATTLESHIP, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". battleshipu");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". battleshipu");
            y = scanner.nextInt();
            try {
                addShit(tile.shipSize.BATTLESHIP, x, y, true);
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
                addShit(tile.shipSize.DESTROYER, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". destroyera");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". destroyera");
            y = scanner.nextInt();
            try {
                addShit(tile.shipSize.DESTROYER, x, y, true);
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
                addShit(tile.shipSize.SUBMARINE, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sve " + i + ". submariny");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sve " + i + ". submariny");
            y = scanner.nextInt();
            try {
                addShit(tile.shipSize.SUBMARINE, x, y, true);
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
                System.out.println("davam tvorit PATROL @ " + x +"/"+ y + " pro tym false");
                addShit(tile.shipSize.PATROL, x, y, false);
            } catch (Exception e) {
                throw new Exception(e);
            }

            System.out.println("Hrac 1 zada pozici x sveho " + i + ". patrolu");
            x = scanner.nextInt();
            System.out.println("Hrac 1 zada pozici y sveho " + i + ". patrolu");
            y = scanner.nextInt();
            try {
                addShit(tile.shipSize.PATROL, x, y, true);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }

    public void addShit(tile.shipSize val, int posx, int posy, boolean tym) throws Exception {
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
                if (tym) {
                    new doTile().deklarace(Field.whatdo.CREATE, posx + i, posy, tile.type.SHIPTRUE, val, false);
                } else {
                    // map.mapka[posx + i][posy] = tile.type.SHIPFALSE;
                    new doTile().deklarace(Field.whatdo.CREATE, posx + i, posy, tile.type.SHIPFALSE, val, false);
                }


        }
    }

    public static void fajr(int posx, int posy, boolean attecker) throws Exception {
        /* if (attecker) {
            if (map.mapka[posx][posy] == tile.type.SHIPFALSE) {
                map.mapka[posx][posy] = tile.type.HIT;
            } else if (map.mapka[posx][posy] == tile.type.WATER) {
                map.mapka[posx][posy] = tile.type.MISS;
            } else {
                throw new Exception("invalidni target");
            }
        } else {
            if (map.mapka[posx][posy] == tile.type.SHIPTRUE) {
                map.mapka[posx][posy] = tile.type.HIT;
            } else if (map.mapka[posx][posy] == tile.type.WATER) {
                map.mapka[posx][posy] = tile.type.MISS;
            } else {
                throw new Exception("invalidni target");
            }
        } */

        new doTile().deklarace(Field.whatdo.FIRE, posx, posy, tile.type.NEITHER, tile.shipSize.NEITHER, attecker);
        System.out.println(new map().readmapka(posx, posy));
        System.out.println(posx+ " xx " + posy + " xx " + attecker);
    }

    public static int isWon() throws Exception {         // 0=player0 won, 1=player1 won, 2=nobody won, 3=no ships found
        int plr0 = 0;
        int plr1 = 0;
        for (int i = 0; i < Main.velky; i++) {
            for (int i1 = 0; i1 < Main.velky; i1++) {
                if (new map().readmapka(i, i1) == tile.type.SHIPTRUE) {
                    plr1++;
                } else if (new map().readmapka(i, i1) == tile.type.SHIPFALSE) {
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
