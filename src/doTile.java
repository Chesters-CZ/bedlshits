public class doTile extends Field {
    @Override
    public void deklarace(whatdo whattodo, int wherex, int wherey, tile.type settile, tile.shipSize setsize, boolean attacker) throws Exception {
        nyni = whattodo;
        extra = wherex;
        ypsilon = wherey;
        tvorenyTile = settile;
        tvorenaLod = setsize;
        utocnik = attacker;
        doField();
    }
}