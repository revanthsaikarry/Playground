package com.example.demoapp;

    import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DemoTask,DemoInteface2 {

    Button Load_class_btn;
    TextView Student_name;
    TextView Roll_no;
    TextView Division_class;
    TextView Book_id;
    TextView Book_title;
    TextView Book_author;

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



