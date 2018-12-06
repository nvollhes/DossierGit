/**
 * @(#) Club.java
 */
package FFSSM;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.HashSet;
import java.util.Set;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    public HashSet<Plongee> listeplongee = new HashSet<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public HashSet<Plongee> plongeesNonConformes() {
        HashSet<Plongee> plongeenulle = new HashSet<>();
        for ( Plongee p : listeplongee){
            if(p.estConforme()==FALSE){
               plongeenulle.add(p);
            } 
        }
        return plongeenulle;
        
    }

    public void organisePlongee(Plongee p) {
        if ( p.estConforme()==TRUE){
            listeplongee.add(p);
        }
        else{
            throw new UnsupportedOperationException("On ne peut pas organiser de plongée car non-conforme");
        }
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
