package org.example.bookstore.model.address;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private int districtId;

    private String name;

}
