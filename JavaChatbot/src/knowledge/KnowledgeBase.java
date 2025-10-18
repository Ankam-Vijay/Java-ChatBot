package knowledge;
import java.util.HashMap;
public abstract class KnowledgeBase implements IknowledgeBase{
protected HashMap<String, String> faq;
public KnowledgeBase(){
faq=new HashMap<>();
loadFAQs();
}
protected abstract void loadFAQs();
@Override
public String getAnswer(String query){
String cleanedQuery = query.toLowerCase().trim();
if(faq.containsKey(cleanedQuery)){
    return faq.get(cleanedQuery);
}
for(String key : faq.keySet()){
    String[] words=cleanedQuery.split("\\s+");
    for(String word : words){
    if(key.contains(word)){
        return faq.get(key);
    }
  }
}
return "Sorry, I don't have an answer for that yet.";
}
}
