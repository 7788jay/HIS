package db.his.dao;

import db.his.util.AnnotationUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by lwt on 2016/1/1.
 */
public class BaseDao<T> {

    public Class<T> beanClazz;

    public BaseDao(){
        Type type = this.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType){
            Type[] p = ((ParameterizedType)type).getActualTypeArguments();
            beanClazz = (Class<T>)p[0];
        }
    }


    public int insert(T obj){
        String tableName = AnnotationUtils.getTableName(obj);

        return 0;
    }




}
