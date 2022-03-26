package castle.handler;

/**
 * @author filwsx
 * @create 2022-03-26 13:56
 */
public class helpHandler extends Handler{
    @Override
    public void handle() {
        System.out.print("迷路了吗？你可以做的命令有：go、bye、help");
        System.out.println("\n go的用法：\tgo east");
    }
}
