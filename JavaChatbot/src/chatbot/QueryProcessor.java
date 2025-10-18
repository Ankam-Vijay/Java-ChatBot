package chatbot;

import knowledge.JavaKnowledgeBase;
import knowledge.GeminiClient;


public class QueryProcessor {
    private final JavaKnowledgeBase knowledgeBase;

    public QueryProcessor(JavaKnowledgeBase kb) {
        this.knowledgeBase = kb;
    }

    public String handleQuery(String query) {
        String answer = knowledgeBase.getAnswer(query);
        if (answer.contains("don't have an answer")) {
            return GeminiClient.fetchAnswer(query);
        }
        return answer;
    }
}
