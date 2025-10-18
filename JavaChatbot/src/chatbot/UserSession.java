package chatbot;
import java.util.ArrayList;
public class UserSession{
private ArrayList<String> history;
public UserSession(){
history=new ArrayList<>();
}
public void addToHistory(String query,String response){
history.add("Q: "+query+"\nA: "+response);
}
public void printHistory(){
for (String entry : history){
System.out.println(entry);
}
}
}
