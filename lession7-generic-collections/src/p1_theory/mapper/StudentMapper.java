package p1_theory.mapper;

import entity.StudentEntity;
import p1_theory.dto.StudentDTO;

public class StudentMapper {
    public StudentDTO toDto(StudentEntity entity){
        return StudentDTO.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .build();
    }

//    public StudentEntity toEntity(StudentDTO dto){
//
//    }
}
