package gcouvoute.kata.bankaccountkata.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Sql("classpath:sql/bankclientcontrollertest.sql")
class BankClientControllerTest {

    private static final String ENDPOINT = "/client";
    private static final String ENDPOINT_ID = "/client/{id}";

    @Autowired
    MockMvc mockMvc;

    @Test
    void createClientWithEmptyName() throws Exception {
        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"\"}")
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Empty name"));
    }

    @Test
    void createClient() throws Exception {
        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"toto\"}")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"toto\", \"status\": \"ACTIVE\", \"balance\": 0}"));
    }

    @Test
    void getClientNotExiting() throws Exception {
        mockMvc.perform(get(ENDPOINT_ID, UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Client not found"));
    }

    @Test
    void getClient() throws Exception {
        mockMvc.perform(get(ENDPOINT_ID, "c7d9404d-eee4-405e-b7ca-425384d26cbe")
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"tata\", \"status\": \"ACTIVE\", \"balance\": 100}"));
    }

    @Test
    void deleteClientNotExiting() throws Exception {
        mockMvc.perform(delete(ENDPOINT_ID, UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Client not found"));
    }

    @Test
    void deleteClient() throws Exception {
        mockMvc.perform(delete(ENDPOINT_ID, "4f7b0a38-e1bf-46c5-8292-7eec8b165611"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}