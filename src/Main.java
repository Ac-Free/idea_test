import sun.font.CreatedFontTracker;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//class MyThreadFactory implements ThreadFactory {
//    private static final MyThreadFactory INSTANCE = new MyThreadFactory();
//
//    private static final String TITLE = "MY_THREAD-";
//    private static int count = 0;
//
//    private MyThreadFactory(){}
//
//    public static MyThreadFactory getInstance(){
//        return INSTANCE;
//    }
//
//    @Override
//    public Thread newThread(Runnable r) {
//        return new Thread(r,TITLE + (count++));
//    }
//}
//
//class MyRunnable implements Runnable{
//    AtomicInteger count = new AtomicInteger(5);
//
//    @Override
//    public void run() {
//        while(count.get() > 0){
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if(count.get() > 0){
//                System.out.println(Thread.currentThread().getName() + "    " + count.get() );
//                count.compareAndSet(count.get(),count.get()-1);
//            } else {
//                break;
//            }
//        }
//    }
//}























public class Main {
    public static AtomicInteger money = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        int[] data = new int[] {100,200,300,400,500};

        for(int i = 0;i < data.length;i ++){
            final int temp = data[i];
            new Thread(new Runnable() {
                @Override
                public void run() {
                    money.addAndGet(temp);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(money);
    }

}




