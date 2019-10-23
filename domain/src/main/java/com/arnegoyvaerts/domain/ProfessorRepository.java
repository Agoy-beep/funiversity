package com.arnegoyvaerts.domain;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProfessorRepository {

    private Map<String,Professor> professorDb;

    public ProfessorRepository() {
        this.professorDb = new HashMap<>();
    }

    public void addProfessorToDataBase(Professor professorToAdd){
        professorDb.put(professorToAdd.getId(), professorToAdd);
    }
    public void deleteProfessorFromDataBase(Professor professorToDelete){
        professorDb.remove(professorToDelete.getId(), professorToDelete);
    }

    public Professor getById(String id){
        Professor foundProf = professorDb.get(id);
        if(foundProf == null){
            throw new NoSuchElementException();
        }
        else{
            return foundProf;
        }
    }

    public List<Professor> getAllProfessors(){
        return new ArrayList<>(professorDb.values());
    }

}
