package COM.TQC.GDD02;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GDD02 extends Activity {	
	 private ListView list;
	 private ListAdapter listadapter;
	 private String[] arr;
	 private int[] intarr;
	 public String _mes="";
	 private Button btn1,btn2,btn3;
	 private mySQLiteOpenHelper gaaSQLiteOpenHelper;
	 private Cursor myCursor;
	 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        findview();
        setlist();
        setlisenter();
    }
    
    public void findview()
    {
    	   list = (ListView) findViewById(R.id.ListView);
    	   btn1=(Button)findViewById(R.id.button1);
           btn2=(Button)findViewById(R.id.button2);
           btn3=(Button)findViewById(R.id.button3);
    }
    
    public void setlist()
    {
    	//arr=new String[]{"111","222","333"};
    	 gaaSQLiteOpenHelper = new mySQLiteOpenHelper(this);  
         myCursor = gaaSQLiteOpenHelper.select(); 
        
         String mTitleRaw = null;
         ArrayList al = new ArrayList();
         myCursor.moveToFirst();
         while(!myCursor.isAfterLast()) {           	
         	mTitleRaw= myCursor.getString(myCursor.getColumnIndex("note_text"));
         	Toast.makeText(GDD02.this,mTitleRaw,Toast.LENGTH_SHORT).show();
             al.add(mTitleRaw);
             myCursor.moveToNext();
         }

         arr = (String[])al.toArray(new String[al.size()]);
      
         listadapter = new ListAdapter();
         list.setAdapter(listadapter);
         list.setOnItemClickListener(new OnItemClickListener() {

 			@Override
 			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
 					long arg3) {
 				// TODO Auto-generated method stub
 				
 			}});
    }
    
    public void setlisenter()
    {    	   
        btn1.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(GDD02.this,_mes.toString(),Toast.LENGTH_SHORT).show();
			}});
        btn2.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				_mes="";
			}});
        btn3.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}});
        
    }
    
    private  class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arr.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View view, ViewGroup arg2) {
			// TODO Auto-generated method stub
			if (view ==	null) 
			{					               
				view = getLayoutInflater().inflate(R.layout.listitem, null);
			}
			 final TextView name = (TextView) view.findViewById(R.id.wishname);
			 CheckBox ck = (CheckBox) view.findViewById(R.id.checkBox1);
			 if(arr!=null)
			 {
			 name.setText(arr[arg0]);
             name.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  Toast.makeText(GDD02.this,"TextView事件",Toast.LENGTH_SHORT).show();
				}});
             
             
             ck.setOnCheckedChangeListener(new OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
					// TODO Auto-generated method stub
					if(arg1)
					{
						//name.getText().toString();
						_mes=_mes+" "+name.getText().toString();
						Toast.makeText(GDD02.this,name.getText().toString(),Toast.LENGTH_SHORT).show();
					}	
					else
					{
						Toast.makeText(GDD02.this,"CheckBox事件",Toast.LENGTH_SHORT).show();
					}
				}});
             
			 }
             return view;
			//return null;
		}
    	
    }
}