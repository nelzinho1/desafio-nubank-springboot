package desafio.nubank.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactsResponseDto {

    private Long id;
    private String email;
    private String cel;
    private Long clientsId;
}
