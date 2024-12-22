import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.Random;

public class User {
   protected int Id;
   protected String name;
   protected String Email;
   protected String password;
   protected String Role;

    public User(int id, String name, String email, String password, String role) {
        Id = id;
        this.name = name;
        Email = email;
        this.password = password;
        this.Role = role;
    }

    public User(String name, String email, String password, String role) {
        this.name = name;
        Email = email;
        this.password = password;
        Role = role;
    }

    public User() {

    }

    public int SighnUp(ArrayList<Adopter>adopters, ArrayList<Integer>generatiedIds){
       System.out.println("SIGN UP PAGE");
       System.out.println("Entre your name");
       Scanner scanner=new Scanner(System.in);
       this.name= scanner.next();
       System.out.println("Entre your Email");
       this.Email= scanner.next();
       System.out.println("Entre your Password");
      this.password= scanner.next();
      this.Role="Adopter";
      this.Id=IDGenerator(generatiedIds);
      adopters.add(new Adopter(this.Id,this.name,this.Email,this.password,this.Role));
      return this.Id;

   }
   public void SignMenu(ArrayList<Adopter>adopters,ArrayList<Admin>admins ,ArrayList<Integer>generatiedIds){
       Scanner scanner=new Scanner(System.in);
       System.out.println("_Registration Menu_");
       System.out.println("1. Sign Up");
       System.out.println("2. Log In");
       System.out.println("Choise 1/2");
       int choise = scanner.nextInt();
       while(choise>2||choise<1){
           System.out.println("Invalide Choise please entre a valide one");
           choise= scanner.nextInt();
       }
       if(choise==1){
           SighnUp(adopters,generatiedIds);
       }
       else {
           LogIn(adopters,admins,generatiedIds);
       }

   }
   public int IDGenerator(ArrayList<Integer>generatedIds){
       Random random = new Random();
       int id;
       do {
           id = 10000000 + random.nextInt(90000000); // Generate an 8-digit number
       } while (generatedIds.contains(id));
       return id;
   }
   public String LogIn(ArrayList<Adopter>adopters,ArrayList<Admin>admins,ArrayList<Integer>generatedIds){
       Scanner scanner=new Scanner(System.in);
       System.out.println("Entre your Email");
       this.Email= scanner.next();
       System.out.println("Entre your Password");
       this.password= scanner.next();
       boolean IsFound=false;
       String role = "";
       for(Adopter adopter: adopters){
           if(this.Email.equals(adopter.Email)){
               if(this.password.equals(adopter.password)){
                  role=adopter.Role;
               }
               else{
                   System.out.println("Wrong Password\nEntre (1) to try again \n (2) to register ");
                   int ch= scanner.nextInt();
                   while(ch>2||ch<1){
                       System.out.println("Invalide Choise please entre a valide one");
                       ch=scanner.nextInt();
                   }
                   if(ch==1){
                       LogIn(adopters,admins,generatedIds);
                   }
                   else{
                       SignMenu(adopters,admins,generatedIds);
                   }

               }
           }
           else {
               System.out.println("This email deos not exist");
               SignMenu(adopters,admins,generatedIds);
           }
       }
       return role;
   }

}
