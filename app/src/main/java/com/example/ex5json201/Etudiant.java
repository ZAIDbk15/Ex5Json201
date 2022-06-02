package com.example.ex5json201;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String ident;
    private String nom;
    private String ville;
    private String naissance;
    private double noteFr;
    private double noteHist;
    private double noteMath;
    private double notePhys;
public  Etudiant() {}

    public  Etudiant(String ident,String nom,String ville,String naissance,double noteFr,double noteHist,double noteMath,double notePhys) {
        this.ident=ident;
        this.nom=nom;
        this.ville=ville;
        this.naissance=naissance;
        this.noteFr=noteFr;
        this.noteHist=noteHist;
        this.noteMath=noteMath;
        this.notePhys=notePhys;


    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getNaissance() {
        return this.naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public double getNoteFr() {
        return noteFr;
    }

    public void setNoteFr(double noteFr) {
        this.noteFr = noteFr;
    }

    public double getNoteHist() {
        return noteHist;
    }

    public void setNoteHist(double noteHist) {
        this.noteHist = noteHist;
    }
    public double getNoteMath() {
        return noteMath;
    }

    public void setNoteMath(double noteMath) {
        this.noteMath = noteMath;
    }
    public double getNotePhys() {
        return notePhys;
    }

    public void setNotePhys(double notePhys) {
        this.notePhys = notePhys;
    }


}
