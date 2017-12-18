package machine;

import dao.KeywordDao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import operation.Operation;

import po.Keyword;
import sentence.Sentence;

public class Machine {

    KeywordDao keywordDao = new KeywordDao();
    //自然语言
    public String natrualWords = "";
    //要执行的表达式 add 2 3
    public String operationString = "";
    //结果自然语言
    public String result = "";
    //机器人状态
    public int state = 1;//1已经完成交互  2接受参数中    
    //当前指令
    public Keyword currentKeyword;

    public Machine() {

    }

    //执行自然语言
    public void run() {
        System.out.println("(keywordDao==null):" + (keywordDao == null));
        if (natrualWords.equalsIgnoreCase("cl")) {
            this.state = 1;
            this.currentKeyword = null;
            this.result = "恢复状态成功!";
        }
        //已经完成交互状态
        if (state == 1) {
            //获取句子的关键字
            Keyword keyWord = keywordDao.getKeyWordByNatrualWords(natrualWords);
            currentKeyword = keyWord;
            //根据关键字生成表达式
            //获取表达式处理类
            try {
                Sentence sentence1 = (Sentence) Class.forName(keyWord.getOperation().getSentenceClass()).newInstance();
                //转换成表达式
                sentence1.setSentence(natrualWords);
                sentence1.toOperationString(this);
            } catch (Exception e) {
                this.state = 1;
                this.currentKeyword = null;
                this.result = "输入格式异常，请重新进入话题。";
                e.printStackTrace();
            }
            try {
                Operation operation = (Operation) Class.forName(keyWord.getOperation().getOperationClass()).newInstance();
                //尝试执行表达式
                operation.doOperation(this);
            } catch (Exception e) {
                this.state = 1;
                this.currentKeyword = null;
                this.result = "输入格式异常，请重新进入话题。";
                e.printStackTrace();
            }

        } else {
            //正在接受参数
            operationString += (" " + natrualWords);
            try {
                Operation operation = (Operation) Class.forName(currentKeyword.getOperation().getOperationClass()).newInstance();
                operation.doOperation(this);
            } catch (Exception e) {
                this.state = 1;
                this.currentKeyword = null;
                this.result = "输入格式异常，请重新进入话题。";
                e.printStackTrace();
            }
        }

    }

}
