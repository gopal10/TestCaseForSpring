package com.stackroute.restaurantservice.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id

  //  @Pattern(regexp = "a-z+")
    private String restaurantId;
    @NotNull(message = "First name is a required field")
    private String restaurantName;


    private String restaurantLocation;
    @Size(min = 1 ,message="size should be gretaer than 5")
    private String restaurantImage;
}

