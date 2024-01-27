import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        // Mendapatkan tipe dari List<String>
        Type type = getGenericType(new MyClass());

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            for (Type typeArgument : typeArguments) {
                System.out.println("Type Argument: " + typeArgument);
            }
        }
    }

    static class MyClass implements MyInterface<List<String>> {
        // ...
    }

    interface MyInterface<T> {
        // ...
    }

    static Type getGenericType(Object obj) {
        return obj.getClass().getGenericInterfaces()[0];
    }
}