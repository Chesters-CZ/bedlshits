abstract class Field {
    public static tile.type tvorenyTile;
    public static tile.shipSize tvorenaLod;
    public static int extra;
    public static int ypsilon;
    public static whatdo nyni;
    static boolean utocnik;

    public void deklarace(whatdo whattodo, int wherex, int wherey, tile.type settile, tile.shipSize setsize, boolean attacker) throws Exception {
        tvorenyTile = tile.type.WATER;
        tvorenaLod = tile.shipSize.PATROL;
        extra = 0;
        ypsilon = 0;
        utocnik = true;
        nyni = whatdo.CREATE;
        doField();
    }

    public void doField() throws Exception {
        switch (nyni) {
            case CREATE:
                //map.mapka[extra][ypsilon] = tvorenyTile;
                new map().editmapka(extra, ypsilon, tvorenyTile);

                if (tvorenyTile == tile.type.SHIPFALSE || tvorenyTile == tile.type.SHIPTRUE) {
                    System.out.println("tvořim " + tvorenaLod + "na x/y" + extra + "/" + ypsilon);
                    System.out.println("na shipsizes(x/y) je " + new map().readmapka(extra, ypsilon));
                    new map().editmapka(extra, ypsilon, tvorenyTile);
                    new map().editsizes(extra, ypsilon, tvorenaLod);
                }
                break;
            case FIRE:
                if (utocnik) {
                    if (new map().readmapka(extra, ypsilon) == tile.type.SHIPFALSE) {
                        new map().editmapka(extra, ypsilon, tile.type.HIT);
                    } else {
                        new map().editmapka(extra, ypsilon, tile.type.MISS);
                    }
                } else {
                    if (new map().readmapka(extra, ypsilon) == tile.type.SHIPTRUE) {
                        new map().editmapka(extra, ypsilon, tile.type.HIT);
                    } else {
                        new map().editmapka(extra, ypsilon, tile.type.MISS);
                    }
                }
        }

    }

    public enum whatdo {
        CREATE, FIRE
    }
}
