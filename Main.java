import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        AnyClass1 a = new AnyClass1();
        AnyClass2 b = new AnyClass2();
        copy(a, b);
        System.out.println(b.val1);
        System.out.println(b.val2);
    }

    public static void copy(Object source, Object dist) {
        Class<?> sourceClass = source.getClass();
        Class<?> distClass = dist.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            DoNotCopy a = sourceField.getAnnotation(DoNotCopy.class);
            try {
                Field distField = distClass.getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                distField.setAccessible(true);
                if (a == null) {
                    distField.set(dist, sourceField.get(source));
                } else {
                    distField.set(dist, a.arg());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
