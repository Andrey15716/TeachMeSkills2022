package task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Reader {
    private String name;
    private String email;
    private boolean isMailSent;
    private List<Book> books;
}
