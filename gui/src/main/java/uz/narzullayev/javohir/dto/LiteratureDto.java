package uz.narzullayev.javohir.dto;/* 
 @author: Javohir
  Date: 1/30/2022
  Time: 12:01 PM*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import uz.narzullayev.javohir.entity.Literature;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LiteratureDto {
    public interface OnCreate {
    }

    public interface OnUpdate {
    }

    @NotNull(groups = OnUpdate.class)
    private Long id;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class})
    private String bookName;

    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    private MultipartFile file;

    public LiteratureDto(Literature literature) {
        this.id = literature.getId();
        this.bookName = literature.getBookName();
    }
}