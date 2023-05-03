package cart.service;

import java.util.List;

import cart.domain.cart.Cart;
import cart.domain.user.Email;
import cart.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartSearchService {

    private final CartRepository cartRepository;

    public CartSearchService(final CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> findByEmail(final String email) {
        return cartRepository.findByEmail(new Email(email));
    }
}
