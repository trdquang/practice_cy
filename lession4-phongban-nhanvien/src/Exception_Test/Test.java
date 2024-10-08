package Exception_Test;public class Test {

    public static void someMethod() throws IdException {
        // Logic có thể ném IdException
        throw new IdException("Some error");
    }

    public static void main(String[] args) {
        try {
            someMethod();
        }catch (IdException e){

        }
    }
}
