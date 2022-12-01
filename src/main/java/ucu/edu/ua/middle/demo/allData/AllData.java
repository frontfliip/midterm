package ucu.edu.ua.middle.demo.allData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CompaniesData")
public class AllData {
    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String twitter;
    private String facebook;
    private String logo;
    private String icon;
    private String size;
    private String employee_count;
    private String address;
}
