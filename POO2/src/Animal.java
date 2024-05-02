 class Animal {
    int matricule;
    String nom;

    public int getMatricule() {
        return matricule;

    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
        System.out.println("le matricule permet de reconnaitre l'animal");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static int getLongevite() {
        return longevite;
    }

    public static void setLongevite(int longevite) {
        Animal.longevite = longevite;
    }

    static  int longevite=25 ;
    //constructeur
    public Animal(int matricule,String nom){
        this.matricule=matricule;
        this.nom=nom;
    }

    public Animal() {

    }

}
