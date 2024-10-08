package p1_theory.service.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import p1_theory.dto.StudentDTO;
import p1_theory.model.StudentModel;
import p1_theory.service.IStudentService;
 

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstruct
public class StudentService implements IStudentService<StudentDTO, StudentModel> {

    @Override
    public int caculate() {
        return 0;
    }

    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public int save(Object object) {
        return 0;
    }
}
