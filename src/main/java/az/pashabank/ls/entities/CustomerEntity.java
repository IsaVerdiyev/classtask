package az.pashabank.ls.entities;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private Long id;

    private String firstName;

    private String lastName;
}
