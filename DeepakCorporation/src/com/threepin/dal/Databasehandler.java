package com.threepin.dal;

import java.sql.Date;
import java.util.ArrayList;

import com.threepin.models.clsClient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

  public class Databasehandler extends SQLiteOpenHelper{
	
	public static final int DATABASE_VERSION=1;
	public static final String DATABASE_NAME="MyDb";
	public static final String TABLE_CLIENT = "client";
	public static final String TABLE_AREA = "area";
	public static final String TABLE_EMPLOYEE="employee";
	public static final String TABLE_TRANSACTION="transactions";
	
	public static final String CLIENT_ID = "id";
    public static final String CLIENT_NAME = "name";
    public static final String CLIENT_VISIBLE="visible";
	
    
    public static final String EMPLOYEE_ID="emp_id";
    public static final String EMPLOYEE_NAME="emp_name";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    public static final String MANAGER_ID="manager_id";
    
    public static final String AREA_ID="a_id";
    public static final String AREA_NAME="a_name";
    
    public static final String TRANSACTION_ID="trans_id";
    public static final String TRANSACTION_TYPE="type";
    public static final String TRANSACTION_DATE="date";
    public static final String TRANSACTION_AMOUNT="amount";
    public static final String TRANSACTION_REMARK="remark";
   
	int C_id,E_id,A_id;
	String C_name,A_name,C_visible,E_name;
	
	
	
    
	public Databasehandler(Context context,String name, CursorFactory factory,int version) {
		// TODO Auto-generated constructor stub
		 super (context,DATABASE_NAME,factory,DATABASE_VERSION);
	}
	



	




	public Databasehandler(Context context) {
		super (context,DATABASE_NAME,null,DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String CREATE_CLIENTT_TABLE = "CREATE TABLE " + TABLE_CLIENT + "("
                +CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CLIENT_NAME + " TEXT,"
                + EMPLOYEE_ID + " INTEGER ," +AREA_ID  + " INTEGER ,"+CLIENT_VISIBLE +" BOOLEAN" +")";
        db.execSQL(CREATE_CLIENTT_TABLE);	
		
        String CREATE_AREA_TABLE = "CREATE TABLE " + TABLE_AREA + "(" 
        +AREA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +AREA_NAME+" TEXT"+")";
        db.execSQL(CREATE_AREA_TABLE);
        
        
        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_EMPLOYEE + "(" 
        		+EMPLOYEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EMPLOYEE_NAME + " TEXT, "
        		+USERNAME + " TEXT," +PASSWORD + " VARCHAR," +MANAGER_ID + " INTEGER" +")";
        db.execSQL( CREATE_EMPLOYEE_TABLE);
        
        String CREATE_TRANSACTION_TABLE = "CREATE TABLE " + TABLE_TRANSACTION + " ("
        		+TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CLIENT_ID + " INTEGER ," 
        		+EMPLOYEE_ID + " INTEGER ," +TRANSACTION_TYPE + " TEXT ,"
        		+TRANSACTION_AMOUNT + " INTEGER ," +TRANSACTION_DATE + " DATE ," +TRANSACTION_REMARK + " VARCHAR" +")";
        db.execSQL(CREATE_TRANSACTION_TABLE);
	}




 




	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		 db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
		 db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREA);
		 
	        // Create tables again
	        onCreate(db);
	}
	
	//Add Client
	public void addClient(String C_name,boolean C_visible,int A_id) {
		
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	   // values.put(CLIENT_ID, C_id); 
	    values.put(CLIENT_NAME,C_name ); 
	    //values.put(EMPLOYEE_ID, E_id);
	    values.put(AREA_ID, A_id);
	    values.put(CLIENT_VISIBLE, C_visible);
	    // Inserting Row
	    db.insert(TABLE_CLIENT, null, values);
	    db.close(); // Closing database connection
	    
	    
	}
	
	public void addEmployee(String E_Name,String usrnam,String pw,int mngr){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		E_Name="Amir";
		usrnam = "abc";
		pw="xyz";
		mngr=1;
		values.put(EMPLOYEE_NAME,E_Name);
		values.put(USERNAME, usrnam);
		values.put(PASSWORD, pw);
		values.put(MANAGER_ID, mngr);
		db.insert(TABLE_EMPLOYEE, null, values);
		db.close();
	}
	
	
	
		
		public long addArea(String A_name){
			SQLiteDatabase db =  this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(AREA_NAME,A_name);
			return db.insertOrThrow(TABLE_AREA,null,values);
		}
		
		
		public void addTransaction(int C_id,int E_id,String T_type,int amt,String date, String rmrk ){
			SQLiteDatabase db =  this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put(TRANSACTION_TYPE, T_type);
			values.put(TRANSACTION_AMOUNT, amt);
			values.put(TRANSACTION_DATE, date);
			values.put(TRANSACTION_REMARK, rmrk);
			 db.insert(TABLE_TRANSACTION, null, values);
			    db.close();
		}
	
	
	// Getting single Client
    public void getClient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_CLIENT, new String[] { CLIENT_ID,
                CLIENT_NAME, EMPLOYEE_ID,AREA_ID,CLIENT_VISIBLE }, CLIENT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
         this.C_id=Integer.parseInt(cursor.getString(0));
         this.C_name=  cursor.getString(1);
         this.E_id=Integer.parseInt(cursor.getString(2));
         this.A_id=Integer.parseInt(cursor.getString(3));
         this.C_visible=cursor.getString(4);
        // return contact
        //return this;
    }
    
    
    public ArrayList<clsClient> getAllClients() {
       
       // Select All Query
    	ArrayList<clsClient> results = new ArrayList<clsClient>();
       // String selectQuery = " SELECT " + CLIENT_NAME + "," + AREA_NAME + "  FROM " + TABLE_CLIENT + " JOIN " + TABLE_AREA + " ON " + TABLE_CLIENT + "." +AREA_ID+"=" + TABLE_AREA + "."+AREA_ID ;
    	String selectQuery = " SELECT " +CLIENT_ID+","+CLIENT_NAME+","+EMPLOYEE_ID+",client."+AREA_ID+","+AREA_NAME + "  FROM " + TABLE_CLIENT + " JOIN " + TABLE_AREA + " ON " + TABLE_CLIENT + "." +AREA_ID+"=" + TABLE_AREA + "."+AREA_ID ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
   
        if (cursor.moveToFirst()) {
            do {
                
            	/*String cnam=C_name=cursor.getString(1);
                String anam=A_name=cursor.getString(4);
                 results.add("Client:" + cnam + ",  Area:" + anam);*/
            	  
            	 clsClient clsc = new clsClient();
                 clsc.cid=cursor.getString(0);
                 clsc.cname=cursor.getString(1);
                 clsc.eid=cursor.getString(2);
                 clsc.aid=cursor.getString(3);
                 clsc.aname=cursor.getString(4);

            	
				results.add(clsc);
            } while (cursor.moveToNext());
        }
     
        return results;
    
    
    }
  
    
    public ArrayList<String> getCClients() {
        
        // Select All Query
     	ArrayList<String> results1 = new ArrayList<String>();
        // String selectQuery = " SELECT " + CLIENT_NAME + "," + AREA_NAME + "  FROM " + TABLE_CLIENT + " JOIN " + TABLE_AREA + " ON " + TABLE_CLIENT + "." +AREA_ID+"=" + TABLE_AREA + "."+AREA_ID ;
     	String selectQuery = " SELECT " +CLIENT_ID+","+CLIENT_NAME+","+EMPLOYEE_ID+",client."+AREA_ID+","+AREA_NAME + "  FROM " + TABLE_CLIENT + " JOIN " + TABLE_AREA + " ON " + TABLE_CLIENT + "." +AREA_ID+"=" + TABLE_AREA + "."+AREA_ID ;

         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(selectQuery, null);
    
         if (cursor.moveToFirst()) {
             do {
                 
             	String cnam=cursor.getString(1);
                // String anam=A_name=cursor.getString(4);
                  //results.add("Client:" + cnam + ",  Area:" + anam);
             	  results1.add(cnam);
             	 
             } while (cursor.moveToNext());
         }
      
         return results1;
     
     
     }
    
    public ArrayList<String>getTransaction(){
    	
    	
		return null;
    	
    }
 
     

    
      
	
	//Update Client
	public int updateClient(String C_name,String C_id) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    //values.put(CLIENT_ID, C_id);
	    values.put(CLIENT_NAME,C_name);
	    //values.put(EMPLOYEE_ID,E_id);
	   // values.put(AREA_ID, A_id);
	   // values.put(CLIENT_VISIBLE,C_visible);
	 
	    // updating row
	    return db.update(TABLE_CLIENT, values, CLIENT_ID + " = ?",
	            new String[] { String.valueOf(C_id) });
	}
	
	public int updateArea(String A_name,String A_id){
		SQLiteDatabase db =  this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(AREA_NAME,A_name);
		return db.update(TABLE_AREA, values, AREA_ID +  "=?", new String[] {String.valueOf(A_id) });
		
	}
	

	
	//Delete Client
	public void deleteClient(String C_id) {
	    SQLiteDatabase db = this.getWritableDatabase();
	    db.delete(TABLE_CLIENT, CLIENT_ID + " = ?",
	            new String[] { String.valueOf(C_id) });
	    db.close();
	}
	
	//Client Count
	public int getClientCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CLIENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
	
	

}
