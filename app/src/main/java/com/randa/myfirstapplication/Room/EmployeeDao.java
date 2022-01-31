package com.randa.myfirstapplication.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee")
   List<Employee> getEmployee();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertEmployee(Employee employee);

    @Delete
    void deleteEmployee(Employee employee);

    @Query("UPDATE employee SET name=:name , address=:address WHERE id=:id ")
    void updateEmployee(String name, String address, int id);

}
