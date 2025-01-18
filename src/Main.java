public class Main {
    public static void main(String[] args) {
        inputs inputs = new inputs();
        inputs.init();
        System.out.println(" --- ZOO LIGHTS TICKET --- ");
        System.out.println("Name: " + inputs.getName());
        System.out.println("Age: " + inputs.getAge());
        System.out.println("Cost: " + inputs.getCost());
        System.out.println("Can Drink Alcohol: "+ inputs.getAlcohol());
        if(inputs.getWeight()<=300&&inputs.getHeight()>=48){
            System.out.println("You can ride the train!");
        }
        System.out.println("ID: "+inputs.idConstructor());
    }
}