/**
 * @(#) Plongee.java
 */
package FFSSM;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;

    public HashSet<Plongeur> listeparticipant = new HashSet<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        listeparticipant.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        for ( Plongeur p : listeparticipant){
                if(p.getDernierelicence().estValide(Calendar.getInstance()) == FALSE){ 
                    return FALSE;
            }  
        }
        return TRUE;
    }

}
