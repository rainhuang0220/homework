package com.niit;

import com.niit.config.MyBatisUtil;
import com.niit.mapper.UserMapper;
import com.niit.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SqlSession session = MyBatisUtil.getSession().openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);

        while (true) {
            System.out.println("=====User Management System=====");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit Program");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    User u = new User();
                    System.out.println("Enter user name: ");
                    u.setName(sc.next());
                    System.out.println("Enter user gender (Male, Female): ");
                    u.setGender(sc.next());
                    System.out.println("Enter user age: ");
                    u.setAge(sc.nextInt());
                    mapper.insertUser(u);
                    System.out.println("User has been inserted with id: " + u.getId());
                    goNext(sc);
                    break;
                case 2:
                    User query = new User();
                    System.out.println("Enter user name (Press Enter to Skip): ");
                    String name = sc.nextLine();
                    query.setName(name.trim().isEmpty() ? null : name.trim());

                    System.out.println("Enter user gender (Male, Female) (Press Enter to Skip): ");
                    String gender = sc.nextLine();
                    query.setGender(gender.trim().isEmpty() ? null : gender.trim());

                    System.out.println("Enter user age (Press Enter to Skip): ");
                    String age = sc.nextLine();
                    query.setAge(age.trim().isEmpty() ? null : Integer.parseInt(age.trim()));

                    List<User> list = mapper.getAllUsers(query);
                    System.out.printf("%-10s %-15s %-15s %-15s%n", "ID", "Name", "Gender", "Age");
                    System.out.println("--------------------------------------------------------------------");
                    for (User user : list) {
                        System.out.printf("%-10s %-15s %-15s %-15s%n",
                                user.getId(), user.getName(), user.getGender(), user.getAge());
                    }
                    goNext(sc);
                    break;
                case 3:
                    User update = new User();
                    System.out.println("Enter user id to update: ");
                    update.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Enter new name (Press Enter to Skip): ");
                    String newName = sc.nextLine();
                    update.setName(newName.trim().isEmpty() ? null : newName.trim());

                    System.out.println("Enter new gender (Male, Female) (Press Enter to Skip): ");
                    String newGender = sc.nextLine();
                    update.setGender(newGender.trim().isEmpty() ? null : newGender.trim());

                    System.out.println("Enter new age (Press Enter to Skip): ");
                    String newAge = sc.nextLine();
                    update.setAge(newAge.trim().isEmpty() ? null : Integer.parseInt(newAge.trim()));

                    if (update.getName() == null && update.getGender() == null && update.getAge() == null) {
                        System.out.println("No fields provided. Update skipped.");
                    } else {
                        mapper.updateUser(update);
                        System.out.println("User updated successfully.");
                    }
                    goNext(sc);
                    break;
                case 4:
                    System.out.println("Enter user id to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    mapper.deleteUser(id);
                    System.out.println("User deleted successfully.");
                    goNext(sc);
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
                    goNext(sc);
            }
        }
    }

    private static void goNext(Scanner sc) {
        System.out.println("Press any key to continue...");
        sc.nextLine();
    }
}