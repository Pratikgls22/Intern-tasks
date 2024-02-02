package org.example.namedparameterjdbctemplate.repositry.Impl;

import lombok.RequiredArgsConstructor;
import org.example.namedparameterjdbctemplate.dto.StudentRequestDto;
import org.example.namedparameterjdbctemplate.model.Student;
import org.example.namedparameterjdbctemplate.repositry.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int save(StudentRequestDto studentRequestDto) {
        String query = "INSERT INTO student_info" + "(name, email, grade)" + "VALUES(:Name,:Email,:Grade);";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("Name", studentRequestDto.getName());
        parameterSource.addValue("Grade", studentRequestDto.getGrade());
        parameterSource.addValue("Email", studentRequestDto.getEmail());

        return jdbcTemplate.update(query, parameterSource);
    }

    @Override
    public List<Student> findAll() {
        String query = "SELECT *" + "FROM student_info;";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public List<Student> findById(Long id) {
        String query = "SELECT * FROM student_info where id = :Id;";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("Id", id);
        return jdbcTemplate.queryForStream(query, parameterSource, new BeanPropertyRowMapper<>(Student.class)).toList();
    }

    @Override
    public String deleteById(Long id) {
        String query = "DELETE FROM student_info WHERE id = :Id";
        MapSqlParameterSource  parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("Id",id);
        jdbcTemplate.update(query, parameterSource);
        return "Deleted !!"+id;
    }

    @Override
    public int save(Long id, StudentRequestDto studentRequestDto) {
        String query = "UPDATE student_info SET name=:Name, email=:Email, grade=:Grade WHERE id=:Id;";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("Id",id);
        parameterSource.addValue("Name",studentRequestDto.getName());
        parameterSource.addValue("Grade",studentRequestDto.getGrade());
        parameterSource.addValue("Email",studentRequestDto.getEmail());

        return jdbcTemplate.update(query,parameterSource);
    }

}
