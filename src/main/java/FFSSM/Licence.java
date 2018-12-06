/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Calendar;
import static java.util.Calendar.YEAR;

public class Licence {

    public Personne possesseur;

    public String numero;

    public Calendar delivrance;

    public int niveau;

    public Club club;

    public Licence(Personne possesseur, String numero, Calendar delivrance, int niveau, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.niveau = niveau;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public Calendar getDelivrance() {
        return delivrance;
    }

    public int getNiveau() {
        return niveau;
    }

    public Club getClub() {
        return club;
    }
    public Club setClub(Club c){
        return  c = club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(Calendar d) {
        d.add(YEAR,-1);
        if ( d.before(delivrance)==TRUE){
            return TRUE;
        }
        return FALSE;
    }

}
