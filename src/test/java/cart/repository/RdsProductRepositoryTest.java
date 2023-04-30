package cart.repository;

import static cart.domain.product.ProductFixture.ODO_PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Optional;

import cart.dao.ProductDao;
import cart.domain.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("SpellCheckingInspection")
@JdbcTest
class RdsProductRepositoryTest {

    private RdsProductRepository rdsProductRepository;

    @Autowired
    private void setUp(final JdbcTemplate jdbcTemplate) {
        rdsProductRepository = new RdsProductRepository(new ProductDao(jdbcTemplate));
    }

    @Test
    void save() {
        final Product result = rdsProductRepository.save(ODO_PRODUCT);

        assertThat(result.getId()).isPositive();
    }

    @Nested
    class NotSaveTest {

        private long productId;

        @BeforeEach
        void setUp() {
            productId = rdsProductRepository.save(ODO_PRODUCT).getId();
        }

        @Test
        void update() {
            final Product product = new Product(productId, "누누", "newUrl", 3);
            final Product result = rdsProductRepository.update(product);

            assertAll(
                    () -> assertThat(result.getId()).isEqualTo(productId),
                    () -> assertThat(result.getName().getValue()).isEqualTo("누누"),
                    () -> assertThat(result.getImage().getValue()).isEqualTo("newUrl"),
                    () -> assertThat(result.getPrice().getValue()).isEqualTo(3)
            );
        }

        @Test
        void findAll() {
            final List<Product> result = rdsProductRepository.findAll();
            assertThat(result).hasSize(1);
        }

        @Test
        void findById() {
            final Optional<Product> result = rdsProductRepository.findById(productId);

            assertAll(
                    () -> assertThat(result).isPresent(),
                    () -> assertThat(result.get().getId()).isEqualTo(productId),
                    () -> assertThat(result.get().getName().getValue()).isEqualTo("오도"),
                    () -> assertThat(result.get().getImage().getValue()).isEqualTo("naver.com"),
                    () -> assertThat(result.get().getPrice().getValue()).isEqualTo(1)
            );
        }

        @Test
        void deleteById() {
            rdsProductRepository.deleteById(productId);

            final Optional<Product> result = rdsProductRepository.findById(productId);

            assertThat(result).isEmpty();
        }
    }
}
