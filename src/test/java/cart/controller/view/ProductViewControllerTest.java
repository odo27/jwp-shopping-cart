package cart.controller.view;

import static cart.domain.product.ProductFixture.NUNU_ID_PRODUCT;
import static cart.domain.product.ProductFixture.ODO_ID_PRODUCT;
import static cart.dto.ResponseFixture.NUNU_RESPONSE;
import static cart.dto.ResponseFixture.ODO_RESPONSE;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import cart.controller.AbstractProductControllerTest;
import cart.controller.dto.ProductResponse;
import cart.domain.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
class ProductViewControllerTest extends AbstractProductControllerTest {

    @Test
    void 상품_조회_테스트() throws Exception {
        //given
        final List<Product> products = List.of(NUNU_ID_PRODUCT, ODO_ID_PRODUCT);
        given(productSearchService.findAll()).willReturn(products);
        final List<ProductResponse> expected = List.of(NUNU_RESPONSE, ODO_RESPONSE);

        //when
        mockMvc.perform(get("/"))

                //then
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attribute("products", equalTo(expected)));
    }

    @Test
    void 어드민_페이지_조회_테스트() throws Exception {
        //given
        final List<Product> products = List.of(NUNU_ID_PRODUCT, ODO_ID_PRODUCT);
        given(productSearchService.findAll()).willReturn(products);
        final List<ProductResponse> expected = List.of(NUNU_RESPONSE, ODO_RESPONSE);

        //when
        mockMvc.perform(get("/admin"))

                //then
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(model().attribute("products", equalTo(expected)));
    }
}
