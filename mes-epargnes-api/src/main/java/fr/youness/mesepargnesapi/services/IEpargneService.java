package fr.youness.mesepargnesapi.services;

import fr.youness.mesepargnesapi.beans.Epargne;
import fr.youness.mesepargnesapi.beans.TypeEpargne;
import fr.youness.mesepargnesapi.beans.Year;

import java.util.List;


public interface IEpargneService {
    List<Epargne> getAllEpargnes();
    List<Epargne> getEpargnes(String year);
    List<Year> getYears();
    List<TypeEpargne> findTypeEpargnesByYear(String year);
}