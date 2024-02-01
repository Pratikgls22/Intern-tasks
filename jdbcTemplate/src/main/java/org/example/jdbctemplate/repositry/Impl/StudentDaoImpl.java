package org.example.jdbctemplate.repositry.Impl;

import lombok.RequiredArgsConstructor;
import org.example.jdbctemplate.dto.StudentRequestDto;
import org.example.jdbctemplate.model.Student;
import org.example.jdbctemplate.repositry.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(StudentRequestDto studentRequestDto) {
        String query = "INSERT INTO student_info" + "(name, email, grade)" +
                "VALUES(?,?,?);";
        return jdbcTemplate.update(query, studentRequestDto.getName(), studentRequestDto.getEmail(), studentRequestDto.getGrade());
    }

    @Override
    public List<Student> findAll() {
        String query = "SELECT *" + "FROM student_info;";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            return new Student(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("grade"));
        });
    }

    @Override
    public List<Student> findById(Long id) {
        String query = "SELECT * FROM student_info where id = ?;";
//        RowMapper<Student> rowMapper = (rs, rowNum) -> new Student(rs.getLong("id"),
//                rs.getString("name"),
//                rs.getString("email"),
//                rs.getNString("grade"));
        return jdbcTemplate.query(query,(rs, rowNum) -> new Student(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getNString("grade")),id);
    }

    @Override
    public String deleteById(Long id) {
        String query = "DELETE FROM student_info WHERE id = ? ";
        System.out.println("query = " + query);
        jdbcTemplate.update(query,id);
        return "Deleted This Id :"+id;
    }

    @Override
    public int save(Long id, StudentRequestDto studentRequestDto) {
        String query = "UPDATE student_info SET name=?, email=?, grade=? WHERE id=?;";
        System.out.println("query = " + query);
        return jdbcTemplate.update(query, studentRequestDto.getName(), studentRequestDto.getEmail(), studentRequestDto.getGrade(),id);
    }

}
