package Vista;

import Modelo.MazoCartas;

public class Print {

    public Print(){

    }
    public void choseeGame(){
         String elegirOpcion = """
                Elija uno de los siguientes Juegos:
                    1) Rummy Juego Original
                    2) Rummikub
                    3) Gin Rummy
                    4) Rummy Argentino
                
                """;
    }

    public void verTodasLasCartas(MazoCartas barajaCartaRef){
        for (int i = 0; i < barajaCartaRef.getListBarajaCartas().size() ; i++) {
            System.out.println(barajaCartaRef.getListBarajaCartas().get(i).toString());
        }
    }
}
