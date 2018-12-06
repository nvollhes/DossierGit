/**
 * @(#) Moniteur.java
 */
package FFSSM;

import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public LinkedList<Embauche> listeemployeur = new LinkedList<>();
   private ArrayList <Licence> leslicencesdumoniteur = new ArrayList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
        for (int i = 0; i < listeemployeur.size(); i++) {
            if (listeemployeur.get(i).estTerminee() == FALSE) {
                return listeemployeur.get(i).getEmployeur();
            }
        }
        return null;

    }

    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {
        listeemployeur.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return listeemployeur;
    }
    public void ajouterLicence(Licence l){
        leslicencesdumoniteur.add(l);
    }
    public ArrayList <Licence> getLeslicencesduplongeur() {
        return leslicencesdumoniteur;
    }
    
    public Licence getDernierelicence(){
        if (leslicencesdumoniteur.size()>0){
        return leslicencesdumoniteur.get(leslicencesdumoniteur.size()-1);
        }
        else{
            throw new UnsupportedOperationException("Le plongeur n'a pas de licence");
        }
    }
}
