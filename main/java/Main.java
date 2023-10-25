import Demo02.Alphabetizer;
import Demo02.Input;
import Demo02.Output;
import Demo02.Shift;
import Demo03.KWICSubject;
import Demo04.Pipe;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0;
        System.out.println("请选择\n1.主程序-子程序\n 2.面向对象\n 3.事件系统\n 4.管道-过滤对应的体系结构：");
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();

        switch (i) {
            case 1:
                System.out.println("执行主程序-子程序代码块");
                System.out.println("主程序-子程序是一种传统的软件体系结构风格，\n" +
                        "其中主程序是整个程序的入口点，\n" +
                        "负责控制程序的执行流程和调用子程序来完成具体的任务。\n" +
                        "子程序是独立的代码块，\n" +
                        "用于完成特定的功能，主程序通过调用子程序来实现整个程序的功能。\n");
                Input input = new Input();
                input.input("F:\\input.txt");
                Shift shift = new Shift(input.getLineTxt());
                shift.shift();
                Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
                alphabetizer.sort();
                Output output = new Output(alphabetizer.getKwicList());
                output.output("F:\\output.txt");
                try {
                    String fileName = "F:\\output.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("执行面向对象代码块");
                System.out.println("面向对象是一种软件设计方法，\n" +
                        "将程序中的数据和操作封装到对象中，\n" +
                        "通过对象之间的交互来实现程序的功能。\n" +
                        "面向对象的设计思想强调数据和操作的关联性，\n" +
                        "通过定义类和对象来描述和管理程序的结构和行为。\n");
                Input input2 = new Input();
                input2.input("F:\\input.txt");
                Shift shift2 = new Shift(input2.getLineTxt());
                shift2.shift();
                Alphabetizer alphabetizer2 = new Alphabetizer(shift2.getKwicList());
                alphabetizer2.sort();
                Output output2 = new Output(alphabetizer2.getKwicList());
                output2.output("F:\\output.txt");
                try {
                    String fileName = "F:\\output.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("执行事件系统代码块");
                System.out.println("事件系统是一种基于事件和消息的软件体系结构风格，\n" +
                        "其中程序通过监听和处理事件来实现功能。\n" +
                        "事件系统中，程序通过注册事件监听器来接收特定的事件，\n" +
                        "并在事件发生时触发相应的处理逻辑。\n");
                //创建主题
                KWICSubject kwicSubject = new KWICSubject();
                //创建观察者
                Demo03.Input input3 = new Demo03.Input("F:\\input.txt");
                Demo03.Shift shift3 = new Demo03.Shift(input3.getLineTxt());
                Demo03.Alphabetizer alphabetizer3 = new Demo03.Alphabetizer(shift3.getKwicList());
                Demo03.Output output3 = new Demo03.Output(alphabetizer3.getKwicList(), "F:\\output.txt");

                // 将观察者加入主题
                kwicSubject.addObserver(input3);
                kwicSubject.addObserver(shift3);
                kwicSubject.addObserver(alphabetizer3);
                kwicSubject.addObserver(output3);
                // 逐步调用各个观察者
                kwicSubject.startKWIC();
                try {
                    String fileName = "F:\\output.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("执行管道-过滤对应的体系结构代码块");
                System.out.println("管道-过滤器是一种将程序的处理过程分解为多个独立的过滤器，\n" +
                        "通过管道将过滤器连接起来，实现数据的流动和处理。\n" +
                        "每个过滤器负责特定的数据处理任务，通过输入流和输出流来接收和输出数据。\n");
                File inFile = new File("F:\\input.txt");
                File outFile = new File("F:\\output.txt");
                Pipe pipe1 = new Pipe();
                Pipe pipe2 = new Pipe();
                Pipe pipe3 = new Pipe();
                Demo04.Input input4 = new Demo04.Input(inFile, pipe1);
                Demo04.Shift shift4 = new Demo04.Shift(pipe1, pipe2);
                Demo04.Alphabetizer alphabetizer4  = new Demo04.Alphabetizer(pipe2, pipe3);
                Demo04.Output output4 = new Demo04.Output(outFile,pipe3);
                input4.transform();
                shift4.transform();
                alphabetizer4.transform();
                output4.transform();
                try {
                    String fileName = "F:\\output.txt"; // 要打开的文件路径

                    ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", fileName);
                    processBuilder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("无效选择");
        }
    }
}