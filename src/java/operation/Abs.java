package operation;

public class Abs extends Operation {

    @Override
    public String doOperation(machine.Machine machine) {
       String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result="请输入一个参数：";
            machine.state=2;
            
        }else{
            machine.result="绝对值是："+Math.abs(Integer.valueOf(str[1]));
            machine.state=1;
        }
        return "";
    }

}
