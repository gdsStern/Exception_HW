public class Main {
    public static void main(String[] args) {
        try {
            validate("Stern_633","123", "123");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

        if(password.length()>20) {
            throw new WrongPasswordException("Длина пароля больше 20 символов");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!chars.contains(Character.toString(login.charAt(i)))) {
                throw new WrongLoginException("Логин содержит неверные символы");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!chars.contains(Character.toString(password.charAt(i)))) {
                throw new WrongPasswordException("Пароль содержит неверные символы");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        System.out.println("Проверка пройдена успешно");
    }
}