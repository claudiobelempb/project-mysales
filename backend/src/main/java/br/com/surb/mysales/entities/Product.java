package br.com.surb.mysales.entities;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

  @Serial
  private static final long serialVersionUID = 7494611404154924779L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String sku;
  private String name;
  private BigDecimal price;
  private String description;

  public Product() {
  }

  public Product(Builder builder) {
    id = builder.id;
    sku = builder.sku;
    name = builder.name;
    price = builder.price;
    description = builder.description;
  }

  public Long getId() {
    return id;
  }

  public String getSku() {
    return sku;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private Long id;
    private String sku;
    private String name;
    private BigDecimal price;
    private String description;

    private Builder() {
    }

    public static Builder aProduct() {
      return new Builder();
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder sku(String sku) {
      this.sku = sku;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder price(BigDecimal price) {
      this.price = price;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Product build() {
     return new Product(this);
    }
  }
}
