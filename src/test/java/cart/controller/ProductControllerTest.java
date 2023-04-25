package cart.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import cart.dto.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void 상품_조회_테스트() throws Exception {
        final List<ProductResponse> productResponses = List.of(
                new ProductResponse(1, "누누", "naver.com", 1),
                new ProductResponse(2, "오도", "naver.com", 1)
        );
        final String result = objectMapper.writeValueAsString(productResponses);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }
}
