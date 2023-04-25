package cart.dto;

import java.util.Objects;

public class ProductResponse {
    private final long id;
    private final String name;
    private final String image;
    private final int price;

    public ProductResponse(final long id, final String name, final String image, final int price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductResponse that = (ProductResponse) o;
        return id == that.id && price == that.price && Objects.equals(name, that.name) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, price);
    }
}
