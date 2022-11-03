package com.example.labo4;

public class repas {



    int noRepas;
    String nom, description, categorie;
    double prix;

    @Override
    public String toString() {
        return "repas{" +
                "noRepas=" + noRepas +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                '}';
    }

    public repas(){

    }

    public repas(int NoRepas, String Nom, String Description, String Categorie, double Prix) {

        this.noRepas = NoRepas;
        this.nom = Nom;
        this.description = Description;
        this.categorie = Categorie;
        this.prix = Prix;

    }

    public int getNoRepas() {
        return noRepas;
    }

    public void setNoRepas(int noRepas) {
        this.noRepas = noRepas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


}
