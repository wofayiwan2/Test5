package Demo04;

import java.io.File;
import java.io.IOException;

/***
 * 管道-过滤软件体系结构实验代码
 * @author 韩卓远
 * 202131044119
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File inFile = new File("F:\\input.txt");
        File outFile = new File("F:\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}