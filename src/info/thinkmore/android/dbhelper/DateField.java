package info.thinkmore.android.dbhelper;

import java.util.Date;

import android.database.Cursor;

public class DateField extends BaseField {

	public DateField(String fieldName, Cursor cursor) {
		super(fieldName, cursor);
	}

    public Date get(){
        if( isNull() ){
            throw new RuntimeException( String.format( "Field %s contains null value", getFieldName() ) );
        }
        return new Date( cursor.getInt( columnIndex() ) );
    }

    public Date get( Date defvalue){
        if( isNull() ){
            return defvalue;
        }
        return new Date( cursor.getInt( columnIndex() ) );
    }
}
