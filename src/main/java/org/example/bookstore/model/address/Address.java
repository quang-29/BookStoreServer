package org.example.bookstore.model.address;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@MappedSuperclass
public abstract class Address {

    @ManyToOne
    @JoinColumn(name = "province_id")
    protected Province province;

    @ManyToOne
    @JoinColumn(name = "district_id")
    protected District district;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    protected Ward ward;

    protected String detail;
}
