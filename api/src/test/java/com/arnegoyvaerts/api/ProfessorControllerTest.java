package com.arnegoyvaerts.api;


import com.arnegoyvaerts.api.dtos.CreateProfessorDto;
import com.arnegoyvaerts.api.dtos.ProfessorDto;
import com.arnegoyvaerts.api.dtos.UpdateProfessorDto;
import com.arnegoyvaerts.domain.Professor;
import com.arnegoyvaerts.domain.ProfessorRepository;
import io.restassured.RestAssured;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessorControllerTest {

    @Test
    public void createProfessor() {
        CreateProfessorDto createProfessorDto = new CreateProfessorDto()
                .setFirstname("Stevens")
                .setLastname("Pinker");

        ProfessorDto professorDto = RestAssured
                .given()
                    .body(createProfessorDto)
                    .accept(JSON)
                    .contentType(JSON)
                .when()
                    .port(8080)
                    .post("/professors/dean")
                .then()
                    .assertThat()
                    .statusCode(HttpStatus.CREATED.value())
                    .extract()
                    .as(ProfessorDto.class);

        assertThat(professorDto.getId()).isNotBlank();
        assertThat(professorDto.getFirstname()).isEqualTo(createProfessorDto.getFirstname());
        assertThat(professorDto.getLastname()).isEqualTo(createProfessorDto.getLastname());
    }

    @Test
    public void getProfessor() {
    }

    @Test
    public void getProfessors() {
    }

    @Test
    public void editProfessor() {
        Professor professor = new Professor("Stevens", "Pinkers");
        ProfessorRepository db = new ProfessorRepository();

        db.addProfessorToDataBase(professor);

        ProfessorDto professorDto = new ProfessorDto()
                //.setId(professor.getId())
                .setFirstname("Steve")
                .setLastname("Pinker");

        UpdateProfessorDto updateProfessorDto = RestAssured
                .given()
                    .body(professorDto)
                    .accept(JSON)
                    .contentType(JSON)
                .when()
                    .port(8080)
                    .put("/professors/dean/" +professor.getId())
                .then()
                    .assertThat()
                    //.statusCode(HttpStatus.ACCEPTED.value())
                    .extract()
                        .as(UpdateProfessorDto.class);

        assertThat(professorDto.getId()).isNotBlank();
        assertThat(professorDto.getFirstname()).isEqualTo(updateProfessorDto.getFirstname());
        assertThat(professorDto.getLastname()).isEqualTo(updateProfessorDto.getLastname());

    }

    @Test
    public void deleteProfessor() {
    }
}
