package org.example.bookstore.model.address;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;



@Getter
@Setter
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int provinceId;

    private String name;

}
