/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFFSSM;

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nvollhes
 */
public class TestFFSSM {

    public Calendar diplome;
    public Calendar delivrance;
    public Calendar delivrancefausse;
    public Calendar datevalidation;
    public Licence licenceMoniteur;
    public Licence licenceInvalide;
    public Plongeur p1;
    public Plongeur p2;
    public Moniteur moniteur;
    public Club club1;
    public Personne personne;
    public Plongee plongee1;
    public Site site1;

    @Before
    public void setUp() {
        this.diplome = diplome;
        this.delivrance = delivrance;
        this.delivrancefausse = delivrancefausse;
        this.moniteur= moniteur;
        this.licenceMoniteur = licenceMoniteur;
        this.licenceInvalide = licenceInvalide;
        this.p1 = p1;
        this.p2= p2;
        this.personne = personne;
        this.datevalidation = datevalidation;
        this.site1 = site1;
        this.plongee1 = plongee1;
        Calendar diplome = Calendar.getInstance();
        Calendar delivrance = Calendar.getInstance();
        Calendar delivrancefausse = Calendar.getInstance();
        Calendar datevalidation = Calendar.getInstance();
        datevalidation.set(2019, 05, 01);
        delivrancefausse.set(2014, 21, 24);
        delivrance.set(2018, 10, 20);
        diplome.set(1998, 8, 12);
        Club club1 = new Club(moniteur,"Mon club","06.08.09.10.11");
        Personne personne = new Personne("001", "Quelqu'un", "DeBizarre", "14 Avenue de Nulle part", "06 66 66 66 66", diplome);
        Licence licenceMoniteur = new Licence(moniteur,"423", delivrance,4,club1);
        
        
        
    }

@Test
        public void testLicence(){
        assertEquals(true,licenceMoniteur.estValide(datevalidation));
        assertEquals(false,licenceInvalide.estValide(datevalidation));
    }
    
    @Test
        public void testEmbauche(){
        Embauche e = new Embauche(delivrance,moniteur,club1);
        Embauche f = new Embauche(datevalidation,moniteur,club1);
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        e.terminer(date);
        assertEquals(true,e.estTerminee());
        assertEquals(false,f.estTerminee());
    }
    
    @Test
        public void testMoniteur(){
        assertEquals(null,moniteur.employeur());
        Calendar date = Calendar.getInstance();
        date.set(2018,11,20);
        moniteur.nouvelleEmbauche(club1, date);
        assertEquals(club1,moniteur.employeur());
    }
}
