package uz.narzullayev.javohir.service;/* 
 @author: Javohir
  Date: 1/30/2022
  Time: 11:52 AM*/


import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import uz.narzullayev.javohir.domain.Literature;
import uz.narzullayev.javohir.dto.LiteratureDto;

import java.util.List;

public interface LiteratureService {

    DataTablesOutput<Literature> findAll(DataTablesInput input, LiteratureDto filterDto, Long userId);

    Literature findById(Long id);

    void update(LiteratureDto literatureDto, Long userDetails);


    void remove(Long id);

    void save(LiteratureDto literatureDto, Long userId);

    List<Literature> findAll();
}
