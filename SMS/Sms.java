import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Sms{
    private Person sender;
    private Person receiver;
    private String messageContent;
    private boolean status;
    private String messageId;
    private LocalDateTime sentTime;
    private LocalDateTime receiveTime;
    private static int counter = 0;
{
    this.messageId = String.format("%04d", ++counter);
}
public Person getSender() {
    return sender;
}
public void setSender(Person sender) {
    this.sender = sender;
}
public Person getReceiver() {
    return receiver;
}
public void setReceiver(Person receiver) {
    this.receiver = receiver;
}
public String getMessageContent() {
    return messageContent;
}
public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
}
public boolean isStatus() {
    return status;
}
public void setStatus(boolean status) {
    this.status = status;
}
public String getMessageId() {
    return messageId;
}
public void setMessageId(String messageId) {
    this.messageId = messageId;
}
public LocalDateTime getSentTime() {
    return sentTime;
}
public void setSentTime(LocalDateTime sentTime) {
    this.sentTime = sentTime;
}
public LocalDateTime getReceiveTime(){
    return receiveTime;
}
public void setReceiveTime(LocalDateTime receiveTime) {
    this.receiveTime = receiveTime;
}
Sms(Person receiver,String content, boolean f){
    this.sender = new Person("Ayesha Javed", "03458763908", "aysha@gmail.com");
    this.receiver = receiver;
    this.messageContent = content;
    this.status = f;
    this.sentTime = LocalDateTime.now().plusSeconds(counter);
}
public void setReceiveTime(){
    this.status = true;//seen
    this.receiveTime = LocalDateTime.now().plusMinutes(counter);
}
 private String formatTime(LocalDateTime time) {
        if (time == null) {
            return "Not Seen";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }

@Override
public String toString(){
    return "SMS: " + getMessageId() +
           "\nContent: " + getMessageContent() +
           "\nReceiver: " + getReceiver() +
           "\nStatus: " + (isStatus() ? "Seen" : "Delivered") +
           "\nReceive Time: " + (isStatus() ? formatTime(getReceiveTime() ): "Not seen")+
           "\nSender: " + getSender() +
           "\nSent Time: " + formatTime(getSentTime());
        }
}
