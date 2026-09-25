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
public class ClientsRequestDto {

    private String name;
    private List<ContactsRequestDto> contactsDto;
}
