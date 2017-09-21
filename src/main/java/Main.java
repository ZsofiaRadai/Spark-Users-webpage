public class Main {
    public static void main(String[] args){
        User Mike = new User("Mike", "Mike@gmail.com");
        User Azazello = new User("Azazello", "Azazello@gmail.com");
        //System.out.println(Azazello.getId());
        UserService newUserService = new UserService();
        //System.out.println(newUserService.getUser(1).getName());
        newUserService.createUser("Tyler Durden", "tyler@gmail.com");
        newUserService.updateUser(3, "Mr. Palahniuk", "palahniuk@gmail.com");
        /*for (User u: newUserService.getAllUsers()) {
            System.out.println(u.getName());
            System.out.println(u.getId());
        }*/
        new UserController(newUserService);
    }
}
