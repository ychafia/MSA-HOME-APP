package fr.youness.mesepargnesapi.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Totaux {
    @Id
    private Integer id_type;
    private Double total_type;
    private double montant;
    private Integer year;

    public Totaux() { }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public Double getTotal_type() {
        return total_type;
    }

    public void setTotal_type(Double total_type) {
        this.total_type = total_type;
    }

    public double getMontant() { return montant; }

    public void setMontant(double montant) { this.montant = montant; }

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }

    @Override
    public String toString() {
        return "Totaux{" +
                "id_type=" + id_type +
                ", total_type=" + total_type +
                ", montant=" + year +
                ", year=" + year +
                '}';
    }
}
