package org.example.service.impl;

import org.example.model.Section;
import org.example.service.ISectionService;

import java.util.ArrayList;
import java.util.List;

public class SectionServiceImpl implements ISectionService {
    private List<Section> sectionList = new ArrayList<>();

    @Override
    public void addSection(Section section) {
        sectionList.add(section);
    }

    @Override
    public void updateSection(Section section) {
        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getSectionId().equals(section.getSectionId())) {
                sectionList.set(i, section);
                break;
            }
        }
    }

    @Override
    public String removeSection(Section section) {
        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(i).getSectionId().equals(section.getSectionId())) {
                sectionList.remove(i);
                return "Successfully removed";
            }
        }
        return "Error: Section not found";
    }

    @Override
    public List<Section> getAllSections() {
        return sectionList;
    }
}
