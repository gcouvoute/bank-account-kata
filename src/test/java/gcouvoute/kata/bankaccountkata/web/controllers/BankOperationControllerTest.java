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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Sql("classpath:sql/bankoperationcontrollertest.sql")
class BankOperationControllerTest {

    private static final String ENDPOINT_GET = "/client/{id}/operations";
    private static final String ENDPOINT_POST = "/client/{id}/operation";

    @Autowired
    MockMvc mockMvc;

    @Test
    void makeOperationClientNotExiting() throws Exception {
        mockMvc.perform(post(ENDPOINT_POST, UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"DEPOSIT\", \"amount\": 100}")
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Client not found"));
    }

    @Test
    void makeOperationWithNegativeValue() throws Exception {
        mockMvc.perform(post(ENDPOINT_POST, "f274eed8-61eb-46f2-b32f-649758a18de2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"DEPOSIT\", \"amount\": -100}")
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Negative amount not allowed"));
    }

    @Test
    void makeDepositOperation() throws Exception {
        mockMvc.perform(post(ENDPOINT_POST, "94b1690f-aafa-4693-8c2e-919a978bdf04")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"DEPOSIT\", \"amount\": 100}")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("DEPOSIT"))
                .andExpect(jsonPath("$.amount").value(100))
                .andExpect(jsonPath("$.balance").value(100));
    }

    @Test
    void makeWithdrawalOperationNotEnoughBalance() throws Exception {
        mockMvc.perform(post(ENDPOINT_POST, "4c89cbc5-d9c7-4b49-ba80-423f66abae6e")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"WITHDRAWAL\", \"amount\": 100}")
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Negative balance not allowed"));
    }

    @Test
    void makeWithdrawalOperation() throws Exception {
        mockMvc.perform(post(ENDPOINT_POST, "c9cb1dbe-cd1b-48d2-8c8a-5d4b343d9fa8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"WITHDRAWAL\", \"amount\": 100}")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("WITHDRAWAL"))
                .andExpect(jsonPath("$.amount").value(100))
                .andExpect(jsonPath("$.balance").value(0));
    }

    @Test
    void getOperationsClientNotExiting() throws Exception {
        mockMvc.perform(get(ENDPOINT_GET, UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.cause").value("Client not found"));
    }

    @Test
    void getOperations() throws Exception {
        mockMvc.perform(get(ENDPOINT_GET, "90aa0584-f635-470d-a5fd-6e0fdae771a1")
                        .accept(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\"operation\":\"DEPOSIT\", \"amount\": 100, \"balance\": 100}," +
                        "{\"operation\":\"WITHDRAWAL\", \"amount\": 100, \"balance\": 0}" +
                        "]"));
    }
}