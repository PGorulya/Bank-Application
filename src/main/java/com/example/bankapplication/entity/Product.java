package com.example.bankapplication.entity;

import com.example.bankapplication.entity.enums.CurrencyType;
import com.example.bankapplication.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    @Column(name = "currenct_code", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CurrencyType currencyCode;

    @Column(name = "interest_rate", nullable = false, precision = 4)
    private BigDecimal interestRate;

    @Column(name = "limit", nullable = false)
    private Integer limit;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Agreement> agreements;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
