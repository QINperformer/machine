/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import dao.SkillDao;
import machine.Machine;
import po.PublicSkill;

/**
 *
 * @author Administrator
 */
public class SkillSentence extends Sentence{
    
    @Override
    public void toOperationString(Machine machine) {
        SkillDao skillDao=new SkillDao();
       System.out.println(machine.natrualWords);
        //获取自然语言
        String sentence = this.getSentence();
        //数据库匹配技能
        PublicSkill publicSkill = skillDao.match(sentence);
        String rString = "skill %s";
        if (publicSkill==null) {
            rString = "skill";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString,publicSkill.getSkillName());
        }
    }
    
}
