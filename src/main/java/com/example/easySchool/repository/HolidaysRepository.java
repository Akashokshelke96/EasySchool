package com.example.easySchool.repository;

import com.example.easySchool.models.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HolidaysRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidaysRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Holiday> findAllHolidays() {
        String sql = "SELECT REASON, DAY FROM HOLIDAYS";
        List<Holiday> list = jdbcTemplate.query(sql ,
                new RowMapper<Holiday>() {
                    @Override
                    public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
                        String reason = rs.getString("REASON");
                        String day = rs.getString("DAY");
                        Holiday holiday = Holiday.builder().reason(reason).day(day).build();
                        return holiday;
                    }
                });
        return list;
    }
}
