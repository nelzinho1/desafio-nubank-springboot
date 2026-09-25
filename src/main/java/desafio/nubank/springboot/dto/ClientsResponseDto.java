package desafio.nubank.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientsResponseDto {

    private Long id;
    private String name;
    private List<ContactsResponseDto> contactsDto;
}
