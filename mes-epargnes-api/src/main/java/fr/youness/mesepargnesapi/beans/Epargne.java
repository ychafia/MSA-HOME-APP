package fr.youness.mesepargnesapi.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name="Epargne")
@Table(name="epargne")
public class Epargne implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_epargne;
    private String date_epargne;
    private int montant_epargne;
    private String motif_epargne;

    @ManyToOne
    private TypeEpargne type_epargne;

    @ManyToOne
    private Year year_epargne;

    public Epargne() { }

    public Epargne(String date_epargne, int montant_epargne, String motif_epargne) {
        this.date_epargne = date_epargne;
        this.montant_epargne = montant_epargne;
        this.motif_epargne = motif_epargne;
    }

    public Long getId_epargne() { return id_epargne; }

    public void setId_epargne(Long id_epargne) { this.id_epargne = id_epargne; }

    public String getDate_epargne() { return date_epargne; }

    public void setDate_epargne(String date_epargne) { this.date_epargne = date_epargne; }

    public int getMontant_epargne() { return montant_epargne; }

    public void setMontant_epargne(int montant_epargne) { this.montant_epargne = montant_epargne; }

    public String getMotif_epargne() { return motif_epargne; }

    public void setMotif_epargne(String motif_epargne) { this.motif_epargne = motif_epargne; }

    public TypeEpargne getType_epargne() { return type_epargne; }

    public void setType_epargne(TypeEpargne type_epargne) { this.type_epargne = type_epargne; }

    public Year getYear_epargne() { return year_epargne; }

    public void setYear_epargne(Year year_epargne) { this.year_epargne = year_epargne; }

    @Override
    public String toString() {
        return "Epargne{" +
                "id_epargne=" + id_epargne +
                ", date_epargne='" + date_epargne + '\'' +
                ", montant_epargne=" + montant_epargne +
                ", motif_epargne='" + motif_epargne + '\'' +
                ", type_epargne=" + type_epargne +
                ", year_epargne=" + year_epargne +
                '}';
    }
}
