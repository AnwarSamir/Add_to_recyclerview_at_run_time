package com.asi.addtorecyclerviewatruntime;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button mAddButton;
    final Context context=this;
    private ArrayList<FeedItem> feedlist;
    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntialDeclaration();
    }
    public void IntialDeclaration()
    {
        mRecyclerView=(RecyclerView)findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAddButton=(Button)findViewById(R.id.ADDButton);
        mAddButton.setOnClickListener(mClickListener);
        feedlist = new ArrayList<>();
    }
    View.OnClickListener mClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog_layout);
            dialog.setTitle(" Enter New Tuple");
            final TextView mMailEditText, mNameEditText;
            Button mADDButton, mDismiss;
            mMailEditText = (EditText) dialog.findViewById(R.id.MailEditText);
            mNameEditText = (EditText) dialog.findViewById(R.id.NameEditText);
            mADDButton = (Button) dialog.findViewById(R.id.AddButton);
            mADDButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean a=false;
                    boolean b=true;
                    boolean c=true;
                    String MAIL=mMailEditText.getText().toString();
                    String NAME=mNameEditText.getText().toString();
                    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                    if(NAME.equals(""))
                    {
                        c=false;
                        Toast.makeText(MainActivity.this,"please insert Name",Toast.LENGTH_LONG).show();
                    }
                    if(MAIL.equals(""))
                    {
                        b=false;
                        Toast.makeText(MainActivity.this,"please insert m@il id",Toast.LENGTH_LONG).show();
                    }
                    else if(MAIL.matches(EMAIL_PATTERN))
                    {
                        a=true;
                    }
                    else {
                        Toast.makeText(MainActivity.this,"invalid em@il id",Toast.LENGTH_LONG).show();
                    }
                    if(a&&b&&c) {
                        ArrayList feed = new ArrayList<FeedItem>();
                        FeedItem Feed = new FeedItem(NAME, MAIL);
                        myAdapter = new MyAdapter(MainActivity.this, feedlist);
                        mRecyclerView.setAdapter(myAdapter);
                        feedlist.add(Feed);
                        dialog.dismiss();
                    }
                }
            });
            mDismiss = (Button) dialog.findViewById(R.id.DismissButton);
            mDismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    };
}