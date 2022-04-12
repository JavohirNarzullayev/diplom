package uz.narzullayev.javohir.service.impl;/* 
 @author: Javohir
  Date: 4/12/2022
  Time: 2:11 PM*/

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import uz.narzullayev.javohir.domain.Science;
import uz.narzullayev.javohir.exception.RecordNotFoundException;
import uz.narzullayev.javohir.repository.ScienceRepository;
import uz.narzullayev.javohir.service.ScienceService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScienceServiceImpl implements ScienceService {
    private final ScienceRepository scienceRepository;


    @Override
    public void add(@NotNull Science science) {
        scienceRepository.save(science);
    }

    @Override
    public void update(@NotNull Science science) {
        scienceRepository.save(science);
    }

    @Override
    public void delete(Long id) {
        scienceRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Science findById(Long id) {
        return scienceRepository.findById(id)
                .orElseThrow(() ->
                        new RecordNotFoundException("No science found with id: " + id, "Science", "id"));
    }

    @Override
    @Transactional(readOnly = true)
    public DataTablesOutput<Science> findAll(DataTablesInput input) {
        return scienceRepository.findAll(input);
    }

    @Override
    public List<Science> findAll() {
        return scienceRepository.findAll();
    }

    @Override
    public DataTablesOutput<Science> findAll(DataTablesInput input, String scienceName) {
        return scienceRepository.findAll(input, new Specification<Science>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<Science> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(scienceName)) {
                    predicates.add(criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("scienceName")), "%" + scienceName + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        });
    }
}