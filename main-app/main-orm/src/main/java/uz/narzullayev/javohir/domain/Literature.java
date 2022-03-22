package uz.narzullayev.javohir.domain;/*
 @author: Javohir
  Date: 1/30/2022
  Time: 11:54 AM*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.narzullayev.javohir.domain.audit.BaseAuditingEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "literature")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Literature extends BaseAuditingEntity implements Serializable {
    private String bookName;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "file_entity_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FileEntity fileEntity;


}