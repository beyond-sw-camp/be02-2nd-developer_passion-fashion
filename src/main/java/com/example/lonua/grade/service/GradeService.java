package com.example.lonua.grade.service;

import com.example.lonua.exception.errorCode.ErrorCode;
import com.example.lonua.exception.exception.GradeException;
import com.example.lonua.grade.model.PostCreateReq;
import com.example.lonua.grade.model.entity.Grade;
import com.example.lonua.grade.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void create(PostCreateReq postCreateReq) {
        Optional<Grade> result = gradeRepository.findByGradeType(postCreateReq.getGradeType());
        if(result.isPresent()) {
            throw new GradeException(ErrorCode.DUPLICATED_USER, String.format("Id is %s", postCreateReq.getGradeType()));
        }

        gradeRepository.save(Grade.builder()
                        .gradeType(postCreateReq.getGradeType())
                        .discountRate(postCreateReq.getDiscountRate())
                .build());
    }
}
