package jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Products {
    private int idp;
    private String name;
    private String descr;
    private String availab;
    private String amount;
    private String price;

}
