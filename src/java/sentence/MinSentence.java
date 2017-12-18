package sentence;

import java.util.List;
import machine.Machine;

public class MinSentence extends Sentence {

    @Override
    public void toOperationString(Machine machine) {
        String sentence = this.getSentence();
        //提取句子里面的所有数字
        List<String> string = util.StringUtil.getNumInString(sentence);
        String rString = "min %s %s";
        if (string.size() != 2) {
            //参数不够
            machine.state = 2;
            rString = "min";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString, string.get(0), string.get(1));
        }
    }

}
