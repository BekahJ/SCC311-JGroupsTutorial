import org.jgroups.*;

public class ReceiverTest
extends ReceiverAdapter {

    private static Channel channel;
    
    public static void main(String args[]) {
        try {
            channel = new JChannel();
            channel.connect("RecieverTestChannel");
        } catch(Exception e) {
            System.out.println("## Error Creating Channel");
            e.printStackTrace();
        }
        channel.setReceiver(new ReceiverTest());

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
        System.out.println(msg.getObject());
    }

    public void viewAccepted(View newView) {
        System.out.println("** view: "+newView);
    }

}
    
