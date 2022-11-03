package com.example.labo4;

public class commande {

    int noCommande, noRepas;
    String nomClient, telClient, nom;
    double prix;

    @Override
    public String toString() {
        return "commande{" +
                "noCommande=" + noCommande +
                ", noRepas=" + noRepas +
                ", nomClient='" + nomClient + '\'' +
                ", telClient='" + telClient + '\'' +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }

    public commande(){

    }


    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public int getNoRepas() {
        return noRepas;
    }

    public void setNoRepas(int noRepas) {
        this.noRepas = noRepas;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public commande(int NoCommande, String NomClient, String TelClient, int NoRepas, String Nom, double Prix){

        this.noCommande = NoCommande;
        this.nomClient = NomClient;
        this.telClient = TelClient;
        this.noRepas = NoRepas;
        this.nom = Nom;
        double prix = Prix;
    }

}
