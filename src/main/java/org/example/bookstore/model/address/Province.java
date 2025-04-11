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
public class Province {

    @Id
    private int id;

    private String name;

}
