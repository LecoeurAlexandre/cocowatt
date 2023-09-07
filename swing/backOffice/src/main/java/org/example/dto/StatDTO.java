package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StatDTO {
    private int drivers;
    private int travellers;
    private double electricPercentage;
    private int doneTrips;
    private int notDoneTrips;
    private double km;
    private int books;
}
