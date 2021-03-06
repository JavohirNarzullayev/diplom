package uz.narzullayev.javohir.domain;/* 
 @author: Javohir
  Date: 6/4/2022
  Time: 12:32 AM*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import uz.narzullayev.javohir.constant.QuizChoice;
import uz.narzullayev.javohir.domain.audit.BaseAuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz extends BaseAuditingEntity implements Serializable {

    @Column(name = "question", nullable = false, columnDefinition = "TEXT")
    private String question;

    @Type(type = "jsonb")
    @Column(name = "choices", columnDefinition = "jsonb")
    private List<QuizChoice> choices;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "science_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Science science;


}
