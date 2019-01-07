package ihm;

/**
 * Classe servant de point d'entrée au programme
 * @author Daouya-Pauline
 */
public class Start{

    public static void main(String[] args) {
        GestionVueAbstraite ihm = new Vue();
        ihm.init();
    }
}
