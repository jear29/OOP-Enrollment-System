package org.example.service;

import org.example.model.Section;
import java.util.List;

public interface ISectionService {
    void addSection(Section section);
    void updateSection(Section section);
    String removeSection(Section section);
    List<Section> getAllSections();
}
