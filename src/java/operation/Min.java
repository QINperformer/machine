package operation;

import machine.Machine;

public class Min extends Operation {

    @Override
    public String doOperation(Machine machine) {
        String str[] = machine.operationString.split(" ");
        if (str.length <= 2) {
            machine.result = "请输入两个参数：";
            machine.state = 2;
        } else {
            machine.result = "最小值是：" + Math.min(Integer.valueOf(str[1]), Integer.valueOf(str[2]));
            machine.state = 1;
        }
        return "";
    }

}
