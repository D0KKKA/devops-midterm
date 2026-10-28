package kz.iitu.kukurekin.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class StudentApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void updatesStudentForKukurekinDanil() throws Exception {
        String created = mockMvc.perform(post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Kukurekin Danil\",\"email\":\"danil.37554@iitu.kz\"}"))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andReturn().getResponse().getContentAsString();
        String id = created.replaceAll(".*\\\"id\\\":(\\d+).*", "$1");

        mockMvc.perform(put("/api/students/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Kukurekin Danil Updated\",\"email\":\"danil.37554@iitu.kz\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Kukurekin Danil Updated"));
    }
}
