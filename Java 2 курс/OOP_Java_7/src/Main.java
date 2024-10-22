import java.lang.reflect.*;

public class Main
{
    public static void main(String[] args) {

        Class<?> stringClass1 = String.class;
        Class<?> stringClass2 = "".getClass();

        try {
            Class<?> stringClass3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int modifiers = stringClass1.getModifiers();
        System.out.println("Modifiers of String class: " + Modifier.toString(modifiers));



        int mod = Modifier.PUBLIC;
        if((modifiers & mod) != 0)
        {System.out.println("Modifier is public");}

        Constructor<?>[] constructors = stringClass1.getConstructors();
        System.out.println("\nPublic constructors of String class:\n");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //Constructor<?> constructor = stringClass1.getConstructor(String.class);

        Field[] fields = stringClass1.getDeclaredFields();
        System.out.println("\nFields of String class:\n");
        for (Field field : fields) {
            System.out.println(field);
        }


        Class<?>[] interfaces = stringClass1.getInterfaces();
        System.out.println("\nInterfaces");
        for(Class<?> i : interfaces){
            System.out.println(i);
        }

        Method[] methods = stringClass1.getMethods();
        System.out.println("\nPublic methods of String class:\n");
        for (Method method : methods) {
            System.out.println(method);
        }

        try {
            Method lengthMethod = stringClass1.getMethod("charAt", int.class);
            String testString = "String";
            char chracter = testString.charAt(0);
            char length = (char) lengthMethod.invoke(testString, 0);
            System.out.println("Length of the string \"" + testString + "\" is: " + length);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
