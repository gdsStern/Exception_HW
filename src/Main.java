public class Main {
    public static void main(String[] args) {
        try {
            validate("Stern633","1233", "123");
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        }

    }

    public static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

        if(password.length()>20) {
            throw new WrongPasswordException("Длина пароля больше 20 символов");
        }
        for (int i = 0; i < login.length(); i++) {
            if (chars.contains(Character.toString(login.charAt(i)))) {
                continue;
            } else {
                throw new WrongLoginException("Логин содержит неверные символы");
            }

        }
        for (int i = 0; i < password.length(); i++) {
            if (chars.contains(Character.toString(password.charAt(i)))) {
                continue;
            } else {
                throw new WrongPasswordException("Пароль содержит неверные символы");
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        System.out.println("Проверка пройдена успешно");
    }
}