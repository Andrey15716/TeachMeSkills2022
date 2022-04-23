package task2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cars {
    private String name;
    private String description;
    private String imageName;
    private int price;
}