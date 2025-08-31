import java.util.Arrays;
import java.util.List;

public class Validator {
    //TTODO
    public static ValidationResult validateTodoCommand(String user_input) {
        String[] user_input_split = user_input.split(" ");

        if (user_input_split.length < 2) {
            return ValidationResult.fail("You forgot to describe you're task buddy..\nFormat it like this: todo [description]");
        }

        String description = user_input_split[1];
        if (description.isEmpty()) {
            return ValidationResult.fail("You're description is empty.. why are you scheduling nothing?");
        }

        return ValidationResult.success();
    }

    public static ValidationResult validateDeadlineCommand(String user_input) {
        String[] user_input_split = user_input.split(" ");
        List<String> argsList = Arrays.asList(user_input_split);
        if (argsList.size() < 4) {
            return ValidationResult.fail("Bro, you forgot some details of your deadline!\n" +
                    "Format: deadline [description] /by [deadline_date]");
        }

        int by_index = -10;
        for (int i=1; i<argsList.size(); i++) {
            if (argsList.get(i).equals("/by")) {
                by_index = i;
                break;
            }
        }
        if (by_index == -10) {
            return ValidationResult.fail("Yo you forgot the /by keyword, lock in bro!!");
        }
        if ( by_index == 1) {
            return ValidationResult.fail("Dude, you're meant to provide the deadline description first..");
        }
        if (by_index == argsList.size()-1) {
            return ValidationResult.fail("You forgot to enter a deadline after /by...");
        }

        String description = String.join(" ", argsList.subList(1, by_index)).trim();
        if (description.isEmpty()) {
            return ValidationResult.fail("You're description is empty.. why are you scheduling?");
        }

        String deadline = String.join(" ", argsList.subList(by_index+1, argsList.size())).trim();
        if (deadline.isEmpty()) {
            return ValidationResult.fail("You're deadline is empty.. why are you stressed?");
        }

        return ValidationResult.success();
    }

    //MARK


    //nested public class that holds the results of a validations
    public static class ValidationResult {
        //private class to hold validation results
        private final boolean is_valid;
        private final String error_message;

        private ValidationResult(boolean is_valid, String error_message) {
            this.is_valid = is_valid;
            this.error_message = error_message;
        }

        public static ValidationResult success() {
            return new ValidationResult(true, null);
        }

        public static ValidationResult fail(String error_message) {
            return new ValidationResult(false, error_message);
        }

        public boolean isValid() {
            return is_valid;
        }

        public String getErrorMessage() {
            return error_message;
        }
    }

}
