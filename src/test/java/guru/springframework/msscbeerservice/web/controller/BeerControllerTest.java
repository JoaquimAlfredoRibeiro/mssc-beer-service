package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class
)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get(BeerController.BASE_URL + "/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post(BeerController.BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(beerDtoJson))
                                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        BeerDTO beerDTO = BeerDTO.builder().build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put(BeerController.BASE_URL + "/" + UUID.randomUUID().toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }
}