import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgLengthReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context)
            throws IOException, InterruptedException {
        int avgValue = 0;
        int length = 0;

        for(Iterator i$ = values.iterator(); i$.hasNext(); ++length) {
            IntWritable value = (IntWritable)i$.next(); // sum of values
            avgValue += value.get();    // total values
        }

        avgValue /= length; // calculating average
        context.write(new Text("AvgLength"), new IntWritable(avgValue));
        System.out.println("\n\nName: Sameet Asadullah\nRoll Number: 18i-0479\n");
    }
}
