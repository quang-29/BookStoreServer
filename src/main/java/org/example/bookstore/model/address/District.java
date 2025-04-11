package org.example.bookstore.model.address;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    private int id;

    private int provinceId;

    private String name;

}
