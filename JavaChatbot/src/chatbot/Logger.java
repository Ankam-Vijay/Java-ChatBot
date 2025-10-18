package chatbot;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
public class Logger{
private static final String LOG_FILE ="resources/logs/chatlog.txt";
public void logInteraction(String query,String response){
try(FileWriter writer = new FileWriter(LOG_FILE,true)){
writer.write(LocalDateTime.now() + "\n");
writer.write("User: "+query+"\n");
writer.write("Bot: "+response+"\n");
}catch(IOException e){
System.out.println("Logging failed: "+e.getMessage());
}
}
}

