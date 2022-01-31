package com.randa.myfirstapplication.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.randa.myfirstapplication.ExternalDataBase.DatabaseLogin;
import com.randa.myfirstapplication.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {

    EditText empName, empAddress;
    Button save, delete,update;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        empName=findViewById(R.id.emp_name);
        empAddress=findViewById(R.id.emp_address);
        list=findViewById(R.id.emp_list);
        save=findViewById(R.id.save_emp);
        delete=findViewById(R.id.delete_emp);
        update=findViewById(R.id.update_emp);


        EmployeeDataBase employeeDataBase=EmployeeDataBase.getInstance(this);

        List<Employee> employees=employeeDataBase.employeeDao().getEmployee();
        if(employees==null){
            Toast.makeText(EmployeeActivity.this, "no Data",Toast.LENGTH_LONG).show();

        } else{
            ArrayList<String> names =new ArrayList<>();
            for(Employee emp:employees){
                names.add(emp.getName() +" "+emp.getId());
            }
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
            list.setAdapter(adapter);
        }




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee=new Employee(empName.getText().toString(), empAddress.getText().toString());
             employeeDataBase.employeeDao().insertEmployee(employee);


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeDataBase.employeeDao().deleteEmployee(new Employee(5));


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                employeeDataBase.employeeDao().updateEmployee(empName.getText().toString(), empAddress.getText().toString(),7);


            }
        });

    }
}