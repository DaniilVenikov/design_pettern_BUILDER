public class Main {
    public static void main(String[] args){
        try {
            Person mom = new PersonBuilder()
                    .setName("Ann")
                    .setSurname("Curry")
                    .setAge(27)
                    .setAddress("Denver")
                    .build();

            Person son = mom.newChildBuilder()
                    .setName("Stephen")
                    .build();
            System.out.println("Mom " + mom + " has a son " + son);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
