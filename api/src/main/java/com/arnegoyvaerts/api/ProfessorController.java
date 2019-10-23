package com.arnegoyvaerts.api;

import com.arnegoyvaerts.api.dtos.CreateProfessorDto;
import com.arnegoyvaerts.api.dtos.ProfessorDto;
import com.arnegoyvaerts.api.dtos.UpdateProfessorDto;
import com.arnegoyvaerts.domain.Professor;
import com.arnegoyvaerts.domain.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorController.class);

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @PostMapping(path = "/dean", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody CreateProfessorDto createProfessorDto){
        Professor professorToCreate = new Professor(createProfessorDto.getFirstname(),
                createProfessorDto.getLastname());
        professorRepository.addProfessorToDataBase(professorToCreate);
        ProfessorDto professorToCreateDto = new ProfessorDto();
        professorToCreateDto.setId(professorToCreate.getId());
        professorToCreateDto.setFirstname(professorToCreate.getFirstname());
        professorToCreateDto.setLastname(professorToCreate.getLastname());

        return professorToCreateDto;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable ("id") String id){
        ProfessorDto getProfessor = new ProfessorDto();
        Professor professorToConvertToDto = professorRepository.getById(id);
        getProfessor.setId(professorToConvertToDto.getId());
        getProfessor.setFirstname(professorToConvertToDto.getFirstname());
        getProfessor.setLastname(professorToConvertToDto.getLastname());

        return getProfessor;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDto> getProfessors(){
        List<ProfessorDto> listOfProfessorDtos = new ArrayList<>();
        for(Professor professor : professorRepository.getAllProfessors()){
            ProfessorDto professorDtoToShow = new ProfessorDto();
            professorDtoToShow.setFirstname(professor.getFirstname());
            professorDtoToShow.setLastname(professor.getLastname());
            professorDtoToShow.setId(professor.getId());
            listOfProfessorDtos.add(professorDtoToShow);
        }
        return listOfProfessorDtos;
    }

    @PutMapping(path = "/dean/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UpdateProfessorDto editProfessor(@PathVariable ("id") String id, @RequestBody ProfessorDto professorDto){
        Professor professorToEdit = professorRepository.getById(id);
        professorToEdit.setFirstname(professorDto.getFirstname());
        professorToEdit.setLastname(professorDto.getLastname());
        UpdateProfessorDto editedProfessor = new UpdateProfessorDto();
        professorRepository.addProfessorToDataBase(professorToEdit);
        editedProfessor.setId(id);
        editedProfessor.setLastname(professorDto.getLastname());
        editedProfessor.setFirstname(professorDto.getFirstname());
        return editedProfessor;
    }

    @DeleteMapping(path = "/dean/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProfessor(@PathVariable ("id") String id){
        Professor professorToDelete = professorRepository.getById(id);
        professorRepository.deleteProfessorFromDataBase(professorToDelete);
    }
}
