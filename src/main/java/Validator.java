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

    //MARK
    public static ValidationResult validateMarkCommand(String user_input, List<Task> tasks) {
        String[] user_input_split = user_input.split(" ");

        if (user_input_split.length < 2) {
            return ValidationResult.fail("You need to say which task you want to mark..\nFormat it like this: mark [index]");
        }

        try {
            int mark_index = Integer.parseInt(user_input_split[1]);
            if (mark_index > tasks.size() || mark_index < 0) {
                return ValidationResult.fail("The index you entered is out of bounds...");
            }
            return ValidationResult.success();
        } catch (NumberFormatException e) {
            return  ValidationResult.fail("The index needs to be a number dude");
        }

    }



    //DEADLINE
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
        if (by_index < 0) {
            return ValidationResult.fail("Yo you forgot the /by keyword, lock in bro!!");
        }
        if (by_index == 1) {
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

    //EVENT
    public static ValidationResult validateEventCommand(String user_input) {
        String[] user_input_split = user_input.split(" ");
        if (user_input_split.length < 6) {
            return ValidationResult.fail("Your input was incorrect!\n" +
                    "Format like this: event [task] /from [start] /to [end]");
        }

        String[] args = user_input.split(" ");
        List<String> argsList = Arrays.asList(args);

        int from_index = -10;
        int to_index = -10;

        for (int i=1; i<argsList.size(); i++) {
            if (argsList.get(i).equals("/from")) {
                from_index = i;
            } else if (argsList.get(i).equals("/to")) {
                to_index = i;
            }
        }

        if (from_index < 0) {
            return ValidationResult.fail("You must have the /from keyword when setting an event");
        }
        if (to_index < 0) {
            return ValidationResult.fail("You must have the /to keyword when setting an event");
        }
        if (from_index == 1 || to_index == 1) {
            return ValidationResult.fail("Your event name goes first, right after the 'event' keyword");
        }
        if (from_index == argsList.size()-1 ||  to_index == argsList.size()-1) {
            return ValidationResult.fail("You cant end with a keyword");
        }
        if (from_index >= to_index) {
            return ValidationResult.fail("You must define the /from before the /to");
        }

        String description = String.join(" ", argsList.subList(1, from_index));
        String start_time = String.join(" ", argsList.subList(from_index+1, to_index));
        String end_time = String.join(" ", argsList.subList(to_index+1, argsList.size()));

        if (description.isEmpty() || start_time.isEmpty() || end_time.isEmpty()) {
            return ValidationResult.fail("You cant leave any empty fields..");
        }

        return ValidationResult.success();

    }


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
