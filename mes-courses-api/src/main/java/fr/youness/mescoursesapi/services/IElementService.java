package fr.youness.mescoursesapi.services;

import fr.youness.mescoursesapi.beans.Element;

import java.util.List;

public interface IElementService {
    List<Element> getElements();
    public boolean deleteElement(Long id);
    public Element updateAndSaveElement(Element e);
}
