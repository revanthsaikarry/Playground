package com.example.demoapp;

    import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DemoTask,DemoInteface2 {

    Button Load_class_btn;
    TextView Student_name;
    TextView Roll_no;
    TextView Division_class;
    TextView Book_id;
    TextView Book_title;
    TextView Book_author;
    Button Add_btn;
    Button Delete_btn;
    Button Display_btn;
    TextView Array_data;
    EditText Add_data;
    EditText Delete_data;
    EditText Display_data;
//    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interfacedemo();
        DemoInterface();
        DemoClass d = new DemoClass();
        d.interfacedemo1(getApplicationContext());

        Student_name = findViewById(R.id.Student_name);
        Roll_no = findViewById(R.id.Roll_no);
        Division_class = findViewById(R.id.Division_class);
        Book_id = findViewById(R.id.Book_ID);
        Book_title = findViewById(R.id.Book_title);
        Book_author = findViewById(R.id.Book_author);

        Load_class_btn = findViewById(R.id.Load_class_btn);
        Load_class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDetails std1 = new StudentDetails("Rakesh G","2SD16CS122","VI B");
                BookDetails bookDetails= new BookDetails("1110","Chemistry", "Dr. Danial clurk");
                Student_name.setText(std1.name);
                Roll_no.setText(std1.roll_no);
                Division_class.setText(std1.division);
                Book_id.setText(bookDetails.book_id);
                Book_title.setText(bookDetails.Book_title);
                Book_author.setText(bookDetails.Book_author);
            }
        });


        final ArrayList<String> Array = new ArrayList<String>();
        Add_btn = findViewById(R.id.Add_btn);
        Delete_btn = findViewById(R.id.Delete_btn);
        Display_btn = findViewById(R.id.Display_btn);
        Array_data = findViewById(R.id.Array_data);
        Delete_data = findViewById(R.id.DataToDelete);
        Add_data = findViewById(R.id.DataToStore);

        Add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Add_data.getText().toString();

                Log.d("Add_data", "onClick: Add_data");
//                String value1 = "bbb";
                Array.add(value);
//                Array.add(value1);
            }
        });
        Display_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<Array.size();i++) {
//                Array_data.setText(Array.get(0) ,0, Array.size());
//                Array_data.setText(String Array.get(0), 0, Array.size());
                    Array_data.setText(Array_data.getText()+Array.get(i)+ "\n");
                    System.out.println(Array.get(i));
                }
            }
        });
        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = Delete_data.getText().toString();
                Array.remove(value);
            }
        });

    }

    @Override
    public void interfacedemo() {
        Log.d("Interface", "interfacedemo: This method is from Inteface DemoTask.....");
        Toast toast=Toast.makeText(getApplicationContext(), "This method is from inteface", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void DemoInterface() {
        Toast toast=Toast.makeText(getApplicationContext(), "this method is from DemoInterface2", Toast.LENGTH_LONG);
        toast.show();
    }
}



