/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dao.SkillDao;
import machine.Machine;
import po.PublicSkill;

/**
 *
 * @author Administrator
 */
public class Skill extends Operation {

    @Override
    public String doOperation(Machine machine) {
        SkillDao skillDao = new SkillDao();
        String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result = "请输入你想咨询哪方面的警务技能：";
            machine.state = 2;

        } else {
            PublicSkill publicSkill = skillDao.findBySkillName(str[1]);
            if (publicSkill != null) {
                machine.result = publicSkill.getIntroduce();
                machine.state = 1;
            } else {
                machine.result = "没有这个警务技能！请换一个！（射击、擒拿、军体拳、侦查、犯罪心理等等）";
                machine.state = 1;

            }

        }
        return "";
    }

}
