import java.util.ArrayList;
// Interface pour les employés à risque
interface EmployeARisque {
    double PRIME_RISQUE = 200.0; // Prime de risque fixe pour les employés à risque
}

// Classe abstraite Employe
abstract class Employe {
    protected String nom, prenom;
    protected int age;
    protected String dateEntree;

    // Constructeur
    public Employe(String nom, String prenom, int age, String dateEntree) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEntree = dateEntree;
    }

    // Méthode abstraite pour calculer le salaire
    public abstract double calculerSalaire();

    // Méthode pour obtenir le nom complet
    public String getNom() {
        return "L'employé " + prenom + " " + nom;
    }
}

// Classe abstraite pour les employés de production et de vente
abstract class ProductionVente extends Employe {
    protected double chiffreAffaire;

    // Constructeur
    public ProductionVente(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
        super(nom, prenom, age, dateEntree);
        this.chiffreAffaire = chiffreAffaire;
    }
}

// Classe Vendeur
class Vendeur extends ProductionVente {
    // Constructeur
    public Vendeur(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
        super(nom, prenom, age, dateEntree, chiffreAffaire);
    }

    // Calcul du salaire
    @Override
    public double calculerSalaire() {
        return chiffreAffaire * 0.2 + 400;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le vendeur " + prenom + " " + nom;
    }
}

// Classe Representant
class Representant extends ProductionVente {
    // Constructeur
    public Representant(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
        super(nom, prenom, age, dateEntree, chiffreAffaire);
    }

    // Calcul du salaire
    @Override
    public double calculerSalaire() {
        return chiffreAffaire * 0.2 + 800;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le représentant " + prenom + " " + nom;
    }
}

// Classe Technicien
class Technicien extends Employe {
    protected int unitesProduites;

    // Constructeur
    public Technicien(String nom, String prenom, int age, String dateEntree, int unitesProduites) {
        super(nom, prenom, age, dateEntree);
        this.unitesProduites = unitesProduites;
    }

    // Calcul du salaire
    @Override
    public double calculerSalaire() {
        return unitesProduites * 5;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le technicien " + prenom + " " + nom;
    }
}

// Classe Manutentionnaire
class Manutentionnaire extends Employe {
    protected int heuresTravaillees;

    // Constructeur
    public Manutentionnaire(String nom, String prenom, int age, String dateEntree, int heuresTravaillees) {
        super(nom, prenom, age, dateEntree);
        this.heuresTravaillees = heuresTravaillees;
    }

    // Calcul du salaire
    @Override
    public double calculerSalaire() {
        return heuresTravaillees * 65;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le manut. " + prenom + " " + nom;
    }
}

// Classe TechnARisque implémentant l'interface EmployeARisque
class TechnARisque extends Technicien implements EmployeARisque {
    // Constructeur
    public TechnARisque(String nom, String prenom, int age, String dateEntree, int unitesProduites) {
        super(nom, prenom, age, dateEntree, unitesProduites);
    }

    // Surcharge de la méthode calculerSalaire pour inclure la prime de risque
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + PRIME_RISQUE;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le technicien " + prenom + " " + nom;
    }
}

// Classe ManutARisque implémentant l'interface EmployeARisque
class ManutARisque extends Manutentionnaire implements EmployeARisque {
    // Constructeur
    public ManutARisque(String nom, String prenom, int age, String dateEntree, int heuresTravaillees) {
        super(nom, prenom, age, dateEntree, heuresTravaillees);
    }

    // Surcharge de la méthode calculerSalaire pour inclure la prime de risque
    @Override
    public double calculerSalaire() {
        return super.calculerSalaire() + PRIME_RISQUE;
    }

    // Surcharge de la méthode getNom
    @Override
    public String getNom() {
        return "Le manut. " + prenom + " " + nom;
    }
}

// Classe Personnel pour gérer une collection d'employés
import java.util.ArrayList;
import java.util.List;

class Personnel {
    private List<Employe> listeEmployes;

    // Constructeur
    public Personnel() {
        listeEmployes = new ArrayList<>();
    }

    // Ajouter un employé à la collection
    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    // Afficher le salaire de chaque employé
    public void afficherSalaires() {
        for (Employe employe : listeEmployes) {
            System.out.println(employe.getNom() + " gagne " + employe.calculerSalaire() + " francs.");
        }
    }

    // Calculer le salaire moyen
    public double salaireMoyen() {
        double somme = 0;
        for (Employe employe : listeEmployes) {
            somme += employe.calculerSalaire();
        }
        return somme / listeEmployes.size();
    }
}

// Classe principale avec la méthode main
class Salaires {
    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Kouassi", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Balo", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Mélanie", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Eman", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Cris", "Abordage", 30, "2001", 45));

        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
    }
}