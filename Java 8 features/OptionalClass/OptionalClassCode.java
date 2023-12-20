package OptionalClass;


import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalClassCode {

    public static Optional<String> getName(){
        String name = "java";
        return Optional.ofNullable(name);
    }
    public static void main(String[] args) {

        String str = "Is not empty";
        Optional<String> optional = Optional.ofNullable(str);

        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("optional is empty"));

        Optional<String> name= getName();
    }
}
