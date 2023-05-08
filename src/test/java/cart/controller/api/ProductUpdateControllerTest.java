package cart.controller.api;

import static cart.domain.product.ProductFixture.NUNU_ID_PRODUCT;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cart.controller.AbstractProductControllerTest;
import cart.controller.dto.ProductRequest;
import cart.controller.dto.ProductResponse;
import cart.dto.RequestFixture;
import cart.dto.ResponseFixture;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

@SuppressWarnings({"NonAsciiCharacters"})
class ProductUpdateControllerTest extends AbstractProductControllerTest {

    @Test
    void 상품_업데이트_테스트() throws Exception {
        // given
        given(productUpdateService.update(anyLong(), anyString(), anyString(), anyInt())).willReturn(NUNU_ID_PRODUCT);
        final ProductRequest productRequest = RequestFixture.NUNU_REQUEST;
        final String request = objectMapper.writeValueAsString(productRequest);
        final ProductResponse productResponse = ResponseFixture.NUNU_RESPONSE;
        final String result = objectMapper.writeValueAsString(productResponse);
        final int id = 1;

        // when
        mockMvc.perform(put("/products/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }
}
