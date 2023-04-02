package com.example.mucal.dto;

import com.example.mucal.domain.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private String title;
    private String category;

    public Show toShowEntity(){
        return Show.builder()
                .title(title)
                .category(category)
                .build();
    }
}
