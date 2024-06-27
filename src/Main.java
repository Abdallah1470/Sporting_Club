public class Main {
    public static void main(String[] args) {

        Sports[] sports = new Sports[20];
        for (int i = 0; i < sports.length; i++) {
            sports[i] = new Sports();
            sports[i].selectGame();
        }
        System.out.println("\n\n###############################################");
        Sports.display();
        System.out.println("\t###########################################");
        BallSports.display();
        System.out.println("\t*******************************************");
        WaterSports.display();
        System.out.println("\t*******************************************");
        Athletics.display();
        System.out.println("\t*******************************************");
        Gymnastics.display();
        System.out.println("\t*******************************************");
        for (Sports sport : sports) {
            sport.info();
        }
    }
}
