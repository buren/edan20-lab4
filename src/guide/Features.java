package guide;

/**
 * User: buren
 * Date: 10/1/13
 * Time: 5:39 PM
 */
public class Features {
    String topPostagStack;
    String secondPostagStack;
    String firstPostagQueue;
    String secondPostagQueue;
    String topPostagStackFw;
    String topStackLcDeprel;
    String canLA;
    String canRE;

    public Features(){
       this.topPostagStack = topPostagStack;
       this.secondPostagStack = secondPostagStack;
       this.firstPostagQueue = firstPostagQueue;
       this.secondPostagQueue = secondPostagQueue;
       this.topPostagStackFw = topPostagStackFw;
       this.topStackLcDeprel = topStackLcDeprel;
       this.canLA = canLA;
       this.canRE = canRE;
    }


    /* GET METHODS */

    public String getTopPostagStack() { return topPostagStack; }
    public String getSecondPostagStack() { return secondPostagStack; }
    public String getFirstPostagQueue() { return firstPostagQueue; }
    public String getSecondPostagQueue() { return secondPostagQueue; }
    public String getTopPostagStackFw() { return topPostagStackFw; }
    public String getTopStackLcDeprel() { return topStackLcDeprel; }
    public String getCanLA() { return canLA; }
    public String getCanRE() { return canRE; }

    /* SET METHODS */

    public void setTopPostagStack(String topPostagStack) { this.topPostagStack = topPostagStack; }
    public void setSecondPostagStack(String secondPostagStack) { this.secondPostagStack = secondPostagStack; }
    public void setFirstPostagQueue(String firstPostagQueue) { this.firstPostagQueue = firstPostagQueue; }
    public void setSecondPostagQueue(String secondPostagQueue) { this.secondPostagQueue = secondPostagQueue; }
    public void setTopPostagStackFw(String topPostagStackFw) { this.topPostagStackFw = topPostagStackFw; }
    public void setTopStackLcDeprel(String topStackLcDeprel) { this.topStackLcDeprel = topStackLcDeprel; }
    public void setCanLA(String canLA) { this.canLA = canLA; }
    public void setCanRE(String canRE) { this.canRE = canRE; }


}
