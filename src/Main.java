import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Admin>admins=new ArrayList<>();
        ArrayList<Adopter>adopters=new ArrayList<>();
        UsersFile.ReadUserData(admins,adopters);
        for(Adopter adopter:adopters){
            System.out.println(adopter.Id);
        }
        User user=new User();
        ArrayList<Integer>generatedIds=new ArrayList<>();
        user.SignMenu(adopters,admins,generatedIds);
        UsersFile.WriteUserData(admins,adopters);
    }
}