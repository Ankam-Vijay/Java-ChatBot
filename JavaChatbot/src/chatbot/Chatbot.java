package chatbot;
import knowledge.JavaKnowledgeBase;
import utils.Constants;
import java.util.Scanner;
public class Chatbot{
private QueryProcessor processor;
private UserSession session;
private Logger logger;
public Chatbot(){
this.processor=new QueryProcessor(new JavaKnowledgeBase());
this.session=new UserSession();
this.logger=new Logger();
}
public void start(){
Scanner scanner=new Scanner(System.in);
System.out.println(Constants.WELCOME_MESSAGE);
while(true){
System.out.println("You: ");
String input=scanner.nextLine();
if(input.equalsIgnoreCase("exit")) break;
if(input.equalsIgnoreCase("history")){
session.printHistory();
continue;
}
String response=processor.handleQuery(input);
session.addToHistory(input,response);
logger.logInteraction(input,response);
System.out.println("Bot: "+response);
}
System.out.println(Constants.GOODBYE_MESSAGE);
scanner.close();
}
} 

