package db.his.util;

import db.his.Annotation.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwt on 2016/1/1.
 */
public class AnnotationUtils {

    public static String getTableName(Object obj){
        Table table = obj.getClass().getAnnotation(Table.class);
        return table.value();
    }

    public static String getInsertSql(Object obj){
        String tableName = getTableName(obj);
        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> list = new ArrayList<String>();
        for(Field f : fields){
            list.add(f.getName());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(tableName).append(" values( ");
        for(int i=0;i<fields.length;i++){
            Object o=null;
            try {
                o = fields[i].get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if(i==0) {
                sb.append(o);
            }else {
                sb.append(" , ").append(o);
            }
        }
        sb.append(");");

        return sb.toString();
    }


}
