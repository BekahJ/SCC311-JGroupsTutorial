import org.jgroups.*;
import org.jgroups.blocks.*;
import org.jgroups.util.*;

import java.util.Random;

public class ClusterMember {

    private static final String CLUSTER_NAME = "RAND_CLUSTER";
    private static final int TIMEOUT = 1000;
    private JChannel channel;

    public static int generateRandom(int min, int max) {
        System.out.println("[CM] Generating Random");
        return ((new Random()).nextInt(max - min) + min);
    }

    public void start() throws Exception {
        //Setup and connect to the channel
        this.channel = new JChannel();
        this.channel.connect(CLUSTER_NAME);
    }

    public static void main(String args[]) throws Exception{
        new ClusterMember().start();
    }

}