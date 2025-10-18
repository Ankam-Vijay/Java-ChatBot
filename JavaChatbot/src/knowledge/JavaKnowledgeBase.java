package knowledge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaKnowledgeBase extends KnowledgeBase {
    private static final String FAQ_FILE = "resources/java_faq.txt";

    @Override
    protected void loadFAQs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FAQ_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    String question = parts[0].trim().toLowerCase();
                    String answer = parts[1].trim();
                    faq.put(question, answer);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load FAQs: " + e.getMessage());
        }
    }
}