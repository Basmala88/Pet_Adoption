import java.io.*;
import java.util.ArrayList;

public class UsersFile {
    public static void ReadUserData(ArrayList<Admin> admins, ArrayList<Adopter> adopters) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line = reader.readLine();
            if (line == null || !line.equals("Users Info")) {
                throw new IOException("Invalid file format");
            }
            while ((line = reader.readLine()) != null) {
                String role = line;
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                String email = reader.readLine();
                String password = reader.readLine();
                if (role.equals("Admin")) {
                    admins.add(new Admin(id, name, email, password, role));
                } else {
                    adopters.add(new Adopter(id, name, email, password, role));
                }
                line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    throw new IOException("File format error: Missing blank line after user data");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void WriteUserData(ArrayList<Admin> admins, ArrayList<Adopter> adopters) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"))) {
            writer.write("Users Info");
            writer.newLine();
            for (Admin admin : admins) {
                writer.write(admin.Role);
                writer.newLine();
                writer.write(String.valueOf(admin.Id));
                writer.newLine();
                writer.write(admin.name);
                writer.newLine();
                writer.write(admin.Email);
                writer.newLine();
                writer.write(admin.password);
                writer.newLine();
                writer.newLine();
            }
            for (Adopter user : adopters) {
                writer.write(user.Role);
                writer.newLine();
                writer.write(String.valueOf(user.Id));
                writer.newLine();
                writer.write(user.name);
                writer.newLine();
                writer.write(user.Email);
                writer.newLine();
                writer.write(user.password);
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
