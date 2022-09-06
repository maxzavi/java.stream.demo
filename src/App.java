import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Integer [] threads = {1,1,1,1,1,1,1,1,1,1,1,1};

        Stream.of(threads).parallel().forEach(t -> {
            //System.out.println(t);
            try {
                process(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void process(Integer i) throws InterruptedException{
        var dtFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        var start =  LocalDateTime.now().format(dtFormater);
        Thread.sleep(i*1000*2);
        System.out.printf("|%d|%s|%s|\n",i, 
        start,
        LocalDateTime.now().format(dtFormater)); 
    }
}
