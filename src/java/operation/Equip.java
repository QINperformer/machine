package operation;

import dao.EquipDao;
import machine.Machine;
import po.PublicEquip;

public class Equip extends Operation {

    EquipDao equipDao = new EquipDao();

    @Override
    public String doOperation(Machine machine) {
        String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result = "你想了解的装备名称是什么？";
            machine.state = 2;
        } else {
            PublicEquip publicEquip = equipDao.findByEquip(str[1]);
            machine.result = publicEquip.getEquipName() + "的简介是：" + publicEquip.getIntroduce();
            machine.state = 1;
        }
        return "";
    }
}
