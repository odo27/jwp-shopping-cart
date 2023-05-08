package cart.controller.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import cart.controller.AbstractProductControllerTest;
import cart.controller.dto.ProductResponse;
import cart.domain.cart.Cart;
import cart.domain.product.Product;
import cart.domain.user.User;
import org.junit.jupiter.api.Test;

class CartSearchControllerTest extends AbstractProductControllerTest {

    @Test
    void 장바구니_조회_테스트() throws Exception {
        given(userRepository.findByEmail(any())).willReturn(Optional.of(new User("a@a.com", "password1")));
        final List<Cart> products = List.of(
                new Cart(1L, new Product(1L, "odo", "url", 1)),
                new Cart(2L, new Product(2L, "nunu", "url", 1))
        );
        given(cartSearchService.findByEmail(anyString())).willReturn(products);
        final List<ProductResponse> productResponses = List.of(
                new ProductResponse(1L, "odo", "url", 1),
                new ProductResponse(2L, "nunu", "url", 1)
        );
        final String result = objectMapper.writeValueAsString(productResponses);
        mockMvc.perform(get("/carts")
                        .header("Authorization", "Basic YUBhLmNvbTpwYXNzd29yZDE="))
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }
}
