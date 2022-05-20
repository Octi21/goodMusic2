package start;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private FileWriter writer;
    private DateTimeFormatter dateTimeFormatter;

    public Audit() {
        try
        {
            this.writer = new FileWriter("src/start/audit.csv");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void write(String str)
    {
        try
        {
            writer.append(str);
            writer.append(", ");
            writer.append(dateTimeFormatter.format(LocalDateTime.now()));
            writer.append("\n");
            writer.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
