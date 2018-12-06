package FFSSM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne{
    
	private int niveau;
        private ArrayList <Licence> leslicencesduplongeur = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau=niveau;
    }
    
    public void ajouterLicence(Licence l){
        leslicencesduplongeur.add(l);
    }

    public int getNiveau() {
        return niveau;
    }

    public ArrayList <Licence> getLeslicencesduplongeur() {
        return leslicencesduplongeur;
    }
    
    public Licence getDernierelicence(){
        if (leslicencesduplongeur.size()>0){
        return leslicencesduplongeur.get(leslicencesduplongeur.size()-1);
        }
        else{
            throw new UnsupportedOperationException("Le plongeur n'a pas de licence");
        }
    }
    
}
