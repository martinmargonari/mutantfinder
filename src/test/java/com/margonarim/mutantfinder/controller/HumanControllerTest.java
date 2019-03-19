package com.margonarim.mutantfinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.services.HumanService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HumanController.class, StatsController.class})
public class HumanControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private HumanService humanService;

    private Map<String, String[]> humanJson;
    private Map<String, String[]> mutantJson;
    @Before
    public void init() {
        Human human = new Human(new String[]{"ATGC","GTCA","CCCC","ATGC"});
        Human mutant = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        humanJson = new HashMap<>();
        humanJson.put("dna", human.getDna());

        mutantJson = new HashMap<>();
        mutantJson.put("dna", mutant.getDna());
    }

    @Test
    public void givenPostToMutant_whenSendingMutantDna_thenRetrieveStatusOK() throws Exception {
        this.mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mutantJson)))
                .andExpect(status().isOk());

    }

    @Test
    public void givenPostToMutant_whenSendingNonMutantDna_thenRetrieveStatusForbidden() throws Exception {
        this.mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(humanJson)))
                .andExpect(status().isForbidden());
    }

    @Test
    public void givenGetToStats_whenHavingInsertedManyHumans_thenRetrieveJsonWithStats() throws Exception {
        this.mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(humanJson)));

        this.mockMvc.perform(post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mutantJson)));

        this.mockMvc.perform(get("/stats")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

}
