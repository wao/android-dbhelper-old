package info.thinkmore.android.dbhelper;

import android.database.Cursor;
import lombok.*;

public class BaseField {
    @Getter
    Cursor cursor;

    @Getter
    String fieldName;

    int    fieldIndex = -1;

	protected BaseField(String fieldName, Cursor cursor) {
        this.fieldName = fieldName;
        this.cursor = cursor;
        fieldIndex = cursor.getColumnIndex(fieldName);
        if( fieldIndex == -1 ){
            throw new RuntimeException( String.format( "Can't find field name %s in cursor", fieldName ) );
        }
    }

    protected int columnIndex(){
        return fieldIndex;
    }

    public boolean isNull(){
        return cursor.isNull( columnIndex() );
    }
}
