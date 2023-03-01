package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//POJO (Plain Old Java Object)

@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Data //@Getter + @Setter + @ToString + @EqualsAndHashCode
public class Person {

    // @Getter
    @EqualsAndHashCode.Include
    private String cnp;

    // @Getter
    //  @Setter
    private String name;

    //  @Getter
    //  @Setter
    @ToString.Exclude
    private LocalDate birthDate;

    @ToString.Include
    public String birthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (this.birthDate != null) {
            return this.birthDate.format(formatter);
        }
        return null;

    }

    public void method1(@NonNull String param1) {
        System.out.println("In method 1");
    }

}
