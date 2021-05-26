import javax.lang.model.type.PrimitiveType;
import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DoNotCopy {
     int arg();
}
