//FA22
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class AutoCompletionTextField {
    private static final int MAX_ENTRIES = 10;

    public static void bindAutoCompletion(TextField textField, List<String> suggestions) {
        SortedSet<String> sortedSuggestions = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        sortedSuggestions.addAll(suggestions);

        textField.setOnKeyReleased(new AutoCompletionEventHandler(sortedSuggestions));
    }

    private static class AutoCompletionEventHandler implements EventHandler<KeyEvent> {
        private final SortedSet<String> suggestions;

        private AutoCompletionEventHandler(SortedSet<String> suggestions) {
            this.suggestions = suggestions;
        }

        @Override
        public void handle(KeyEvent event) {
            TextField textField = (TextField) event.getSource();
            String enteredText = textField.getText();
            if (enteredText.isEmpty()) {
                return;
            }

            if (event.getCode().isLetterKey() || event.getCode().isDigitKey()) {
                String suggestedText = null;
                for (String suggestion : suggestions) {
                    if (suggestion.toLowerCase().startsWith(enteredText.toLowerCase())) {
                        suggestedText = suggestion;
                        break;
                    }
                }

                if (suggestedText != null) {
                    textField.setText(suggestedText);
                    textField.selectRange(enteredText.length(), suggestedText.length());
                }
            } else if (event.getCode().isNavigationKey() || event.getCode().isWhitespaceKey() ||
                    event.getCode().isFunctionKey() || event.getCode().isMediaKey() ||
                    event.getCode().isModifierKey() || event.getCode().isArrowKey() ||
                    event.getCode().isNavigationKey()) {
                // Ignore non-text keys
                return;
            }
        }
    }
}
