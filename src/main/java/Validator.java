import java.util.Arrays;
import java.util.List;


public class Validator {


    //TTODO
    public static ValidationResult validateTodoCommand(String userInput) {
        String[] userInputSplit = userInput.split(" ");

        if (userInputSplit.length < 2) {
            return ValidationResult.fail("You forgot to describe you're task buddy..");
        }

        String description = userInputSplit[1];
        if (description.isEmpty()) {
            return ValidationResult.fail("You're description is empty.. why are you scheduling nothing?");
        }

        return ValidationResult.success();
    }


    //MARK
    public static ValidationResult validateMarkCommand(String userInput, List<Task> tasks) {
        String[] userInputSplit = userInput.split(" ");

        if (userInputSplit.length < 2) {
            return ValidationResult.fail("You need to say which task you want to mark..");
        }

        try {
            int markIndex = Integer.parseInt(userInputSplit[1]);
            if (markIndex > tasks.size() || markIndex <= 0) {
                return ValidationResult.fail("The index you entered is out of bounds...");
            }
            return ValidationResult.success();
        } catch (NumberFormatException e) {
            return  ValidationResult.fail("The index needs to be a number dude");
        }

    }


    //DEADLINE
    public static ValidationResult validateDeadlineCommand(String userInput) {
        String[] userInputSplit = userInput.split(" ");
        List<String> argsList = Arrays.asList(userInputSplit);
        if (argsList.size() < 4) {
            return ValidationResult.fail("Bro, you forgot some details of your deadline!");
        }

        int byIndex = -10;
        for (int i=1; i<argsList.size(); i++) {
            if (argsList.get(i).equals("/by")) {
                byIndex = i;
                break;
            }
        }
        if (byIndex < 0) {
            return ValidationResult.fail("Yo you forgot the /by keyword, lock in bro!!");
        }
        if (byIndex == 1) {
            return ValidationResult.fail("Dude, you're meant to provide the deadline description first..");
        }
        if (byIndex == argsList.size()-1) {
            return ValidationResult.fail("You forgot to enter a deadline after /by...");
        }

        String description = String.join(" ", argsList.subList(1, byIndex)).trim();
        if (description.isEmpty()) {
            return ValidationResult.fail("You're description is empty.. why are you scheduling?");
        }

        String deadline = String.join(" ", argsList.subList(byIndex+1, argsList.size())).trim();
        if (deadline.isEmpty()) {
            return ValidationResult.fail("You're deadline is empty.. why are you stressed?");
        }

        return ValidationResult.success();
    }


    //EVENT
    public static ValidationResult validateEventCommand(String userInput) {
        String[] userInputSplit = userInput.split(" ");
        if (userInputSplit.length < 6) {
            return ValidationResult.fail("Your input was incorrect!");
        }

        String[] args = userInput.split(" ");
        List<String> argsList = Arrays.asList(args);

        int fromIndex = -10;
        int toIndex = -10;

        for (int i=1; i<argsList.size(); i++) {
            if (argsList.get(i).equals("/from")) {
                fromIndex = i;
            } else if (argsList.get(i).equals("/to")) {
                toIndex = i;
            }
        }

        if (fromIndex < 0) {
            return ValidationResult.fail("You must have the /from keyword when setting an event");
        }
        if (toIndex < 0) {
            return ValidationResult.fail("You must have the /to keyword when setting an event");
        }
        if (fromIndex == 1 || toIndex == 1) {
            return ValidationResult.fail("Your event name goes first, right after the 'event' keyword");
        }
        if (fromIndex == argsList.size()-1 ||  toIndex == argsList.size()-1) {
            return ValidationResult.fail("You cant end with a keyword");
        }
        if (fromIndex >= toIndex) {
            return ValidationResult.fail("You must define the /from before the /to");
        }

        String description = String.join(" ", argsList.subList(1, fromIndex));
        String startTime = String.join(" ", argsList.subList(fromIndex+1, toIndex));
        String endTime = String.join(" ", argsList.subList(toIndex+1, argsList.size()));

        if (description.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            return ValidationResult.fail("You cant leave any empty fields..");
        }

        return ValidationResult.success();

    }



    //nested public class that holds the results of a validations
    public static class ValidationResult {
        //private class to hold validation results
        private final boolean isValid;
        private final String errorMessage;

        private ValidationResult(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }

        public static ValidationResult success() {
            return new ValidationResult(true, null);
        }

        public static ValidationResult fail(String errorMessage) {
            return new ValidationResult(false, errorMessage);
        }

        public boolean isValid() {
            return isValid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

}
