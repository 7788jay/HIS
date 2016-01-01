package db.his.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created by lwt on 2016/1/1.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={TYPE})
public @interface Table {

    String value() default "";

}



