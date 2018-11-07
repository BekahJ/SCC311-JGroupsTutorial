import org.jgroups.*;

public class ReceiverTest
extends ReceiverAdapter {

    private static Channel channel;
    
    public static void main(String args[]) {

        //Create/Connect to the channel (group)
        try {
            channel = new JChannel();
            channel.connect("RecieverTestChannel");
        } catch(Exception e) {
            System.out.println("## Error Creating Channel");
            e.printStackTrace();
        }

        //Set the channel receiver instance (see extends ReceiverAdapter at top)
        channel.setReceiver(new ReceiverTest());

        //Send 10 messages to the channel's receiver
        for(int i=0 ; i<10 ; i++) {
            System.out.println("Sending Message #"+i);
            try {
                channel.send(new Message(null, null, "Hello "+i));
                Thread.currentThread().sleep(1000);
            } catch(Exception e) {
                System.out.println("Error Sending Message");
            }
        }

        channel.close();
    }

    public void receive(Message msg) {
        System.out.println((String)msg.getObject());
    }

    public void viewAccepted(View newView) {
        System.out.println("** view: "+newView);
    }

}
    
